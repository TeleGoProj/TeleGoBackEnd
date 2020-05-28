package com.telego.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telego.database.entity.PhoneUser;
import com.telego.database.rep.PhoneUserRepository;
import com.telego.model.PhoneUserDTO;
import com.telego.model.response.ProfileResponse;
import com.telego.util.EntityMapper;

@Service
public class ProfileService {
	
	@Autowired
	PhoneUserRepository phoneUserRepository;
	
	@Autowired
	private EntityMapper mapper;
	
	public ProfileResponse getPhoneUser(Long id) {
		PhoneUser entity = phoneUserRepository.findById(id).get();
		PhoneUserDTO dto = mapper.mapToPhoneUserDTO(entity);
		
		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}
	
	public ProfileResponse saveOrUpdatePhoneUser(PhoneUserDTO dto) {
		PhoneUser entity = mapper.mapToPhoneUserEntity(dto);
		entity = phoneUserRepository.save(entity);
		dto = mapper.mapToPhoneUserDTO(entity);
		
		ProfileResponse profileResponse = new ProfileResponse(dto);
		return profileResponse;
	}
}
