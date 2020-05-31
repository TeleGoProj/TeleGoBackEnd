package com.telego.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.telego.database.entity.PhoneUser;
import com.telego.database.rep.PhoneUserRepository;
import com.telego.model.CountryDTO;
import com.telego.model.PhoneUserDTO;
import com.telego.model.request.ProfileRequest;
import com.telego.model.response.ProfileResponse;
import com.telego.util.EntityMapper;

@Service
public class ProfileService {

	@Autowired
	private PhoneUserRepository phoneUserRepository;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private EntityMapper mapper;

	public ProfileResponse getPhoneUser(Long id) {
		PhoneUser entity = phoneUserRepository.getOne(id);
		PhoneUserDTO dto = mapper.mapToPhoneUserDTO(entity);
		dto.setLoginName(null);
		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}

	public ProfileResponse saveOrUpdatePhoneUser(ProfileRequest profileRequest) {
		PhoneUserDTO dto = profileRequest.getUser();

		PhoneUser entity = mapper.mapToPhoneUserEntity(dto);
		entity = phoneUserRepository.save(entity);
		dto = mapper.mapToPhoneUserDTO(entity);

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
		return adminService.getAllCountries();
	}
}
