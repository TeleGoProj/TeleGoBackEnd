package com.telego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telego.database.entity.PhoneUser;
import com.telego.database.rep.PhoneUserRepository;
import com.telego.model.PhoneUserDTO;
import com.telego.model.request.UserSearchRequest;
import com.telego.model.response.UserSearchResponse;
import com.telego.util.EntityMapper;
@Service
public class UserSearchService {
	@Autowired
	private PhoneUserRepository phoneUserRepository;

	@Autowired
	private EntityMapper mapper;
	
	public UserSearchResponse searchForUsers(UserSearchRequest request) {

		List<PhoneUser> matchedUsersEntities = null;
		
		boolean searchFeature = request.getFeatureName() != null && !request.getFeatureName().isEmpty();
		boolean searchPhone = request.getPhoneNumber() != null && request.getPhoneNumber() != 0L;
		
		if(searchFeature && searchPhone)
			matchedUsersEntities = phoneUserRepository.findByLandlinePhones_PhoneNumberAndUserFeatures_FeatureByFeatureId_Name(request.getPhoneNumber(), request.getFeatureName());
		
		else if(searchFeature && !searchPhone)
			matchedUsersEntities = phoneUserRepository.findByUserFeatures_FeatureByFeatureId_Name(request.getFeatureName());
		
		else if (!searchFeature && searchPhone)
			matchedUsersEntities = phoneUserRepository.findByLandlinePhones_PhoneNumber(request.getPhoneNumber());
		
		else
			matchedUsersEntities = phoneUserRepository.findAll();
		
		List<PhoneUserDTO> matchedUsers = mapper.mapToPhoneUsersDTOs(matchedUsersEntities);
		UserSearchResponse response = new UserSearchResponse(matchedUsers);
		return response;
	}
}
