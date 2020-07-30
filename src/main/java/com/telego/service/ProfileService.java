package com.telego.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.telego.database.entity.Area;
import com.telego.database.entity.Box;
import com.telego.database.entity.Cabin;
import com.telego.database.entity.City;
import com.telego.database.entity.Country;
import com.telego.database.entity.Feature;
import com.telego.database.entity.LandlinePhone;
import com.telego.database.entity.PhoneUser;
import com.telego.database.entity.UserFeature;
import com.telego.database.rep.AreaRepository;
import com.telego.database.rep.BoxRepository;
import com.telego.database.rep.CabinRepository;
import com.telego.database.rep.CityRepository;
import com.telego.database.rep.CountryRepository;
import com.telego.database.rep.FeatureRepository;
import com.telego.database.rep.LandlinePhoneRepository;
import com.telego.database.rep.PhoneUserRepository;
import com.telego.database.rep.UserFeatureRepository;
import com.telego.model.AreaDTO;
import com.telego.model.BoxDTO;
import com.telego.model.CabinDTO;
import com.telego.model.CityDTO;
import com.telego.model.CountryDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.LandlinePhoneDTO;
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
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	
	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private CabinRepository cabinRepository;
	
	@Autowired
	private BoxRepository boxRepository;


	
	
	@Autowired
	private EntityMapper mapper;

	public ProfileResponse getPhoneUser(Long id) {
		PhoneUser entity = phoneUserRepository.getOne(id);
		PhoneUserDTO dto = mapper.mapToPhoneUserDTO(entity);
		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}
	
	
public  ProfileResponse authenticate( ProfileRequest request) {
		
		ProfileResponse profileResponse = null;
        PhoneUserDTO dto = request.getUser();
		
		List<PhoneUser> entityAtDatabase = phoneUserRepository.getByLoginNameAndLoginPassword(dto.getLoginName() , dto.getLoginPassword() );
		
	
		if(dto.getLoginName().equals(entityAtDatabase.get(0).getLoginName()) && dto.getLoginPassword().equals(entityAtDatabase.get(0).getLoginPassword()))
		{
			List<PhoneUserDTO> dto2 = mapper.mapToPhoneUsersDTOs(entityAtDatabase);
			 profileResponse = new ProfileResponse(dto2.get(0));

		}
		
		return profileResponse;
	}
	
	
@Transactional
public  ProfileResponse signUp( ProfileRequest request) {
	

	ProfileResponse profileResponse = null;
	
    PhoneUserDTO dto = request.getUser();
    
	PhoneUser entityToSave = mapper.mapToPhoneUserEntity(dto);
	entityToSave = phoneUserRepository.save(entityToSave);

	dto = mapper.mapToPhoneUserDTO(entityToSave);
	
	
	profileResponse = new ProfileResponse(dto);
	return profileResponse;
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
