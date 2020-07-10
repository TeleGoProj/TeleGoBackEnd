package com.telego.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.telego.database.entity.Feature;
import com.telego.database.entity.LandlinePhone;
import com.telego.database.entity.PhoneUser;
import com.telego.database.entity.UserFeature;
import com.telego.database.rep.FeatureRepository;
import com.telego.database.rep.LandlinePhoneRepository;
import com.telego.database.rep.PhoneUserRepository;
import com.telego.database.rep.UserFeatureRepository;
import com.telego.model.CountryDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.PhoneUserDTO;
import com.telego.model.request.ProfileRequest;
import com.telego.model.response.ProfileResponse;
import com.telego.util.EntityMapper;

@Service
public class ProfileService {

	@Autowired
	private PhoneUserRepository phoneUserRepository;
	
	@Autowired
	private LookupService lookupService;
	
	@Autowired
	private LandlinePhoneRepository landlinePhoneRepository;
	
	@Autowired
	private UserFeatureRepository userFeatureRepository;
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@Autowired
	private EntityMapper mapper;

	public ProfileResponse getPhoneUser(Long id) {
		PhoneUser entity = phoneUserRepository.getOne(id);
		PhoneUserDTO dto = mapper.mapToPhoneUserDTO(entity);
		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}
	
	
	public Long authenticate(String fname , String password) {
		
		PhoneUser user= phoneUserRepository.getByfNameAndLoginPassword(fname, password);
		Long userid = user.getUserId();
		return userid;
	}
	

	
	@Transactional
	public ProfileResponse saveOrUpdatePhoneUser(ProfileRequest profileRequest) {
		PhoneUserDTO dto = profileRequest.getUser();
		
		PhoneUser entityToSave = mapper.mapToPhoneUserEntity(dto);
		PhoneUser entityAtDatabase = phoneUserRepository.getOne(entityToSave.getUserId());
		
		if(entityToSave.getLandlinePhones() != null && !entityToSave.getLandlinePhones().isEmpty()) {
			LandlinePhone phoneEntity = landlinePhoneRepository.getOne(entityToSave.getLandlinePhones().get(0).getLandlinePhoneId());
			entityToSave.getLandlinePhones().get(0).setBox(phoneEntity.getBox());
		}
		
		userFeatureRepository.deleteByPhoneUserByUser(entityAtDatabase);
		
		if(entityToSave.getUserFeatures() != null && !entityToSave.getUserFeatures().isEmpty()) {

			List<UserFeature> featuresFromUI = entityToSave.getUserFeatures();
			if(featuresFromUI != null && ! featuresFromUI.isEmpty()) {
				for(UserFeature userFeature: featuresFromUI) {
					Feature feature = featureRepository.getOne(userFeature.getFeatureByFeatureId().getFeatureId());
					userFeature.setFeatureByFeatureId(feature);
					userFeature.setPhoneUserByUser(entityAtDatabase);
					userFeatureRepository.save(userFeature);
				}
			}
		}
		
		entityToSave = phoneUserRepository.save(entityToSave);
		dto = mapper.mapToPhoneUserDTO(entityToSave);

		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}
	
	public ProfileResponse uploadImage(Long id, MultipartFile uploadedImage) {
		PhoneUser entity = phoneUserRepository.getOne(id);
		
		if (uploadedImage != null)
			try {
				entity.setImage(uploadedImage.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		entity = phoneUserRepository.save(entity);
		
		PhoneUserDTO dto = mapper.mapToPhoneUserDTO(entity);
		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}
	
	public List<CountryDTO> getAllCountries(){
		return lookupService.getAllCountries();
	}
	
	public List<FeatureDTO> getAllFeatures(){
		return lookupService.getAllFeatures();
	}
}
