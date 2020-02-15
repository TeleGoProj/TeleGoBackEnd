package com.telego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telego.model.CountryDTO;
import com.telego.model.request.AdminLookupsRequest;
import com.telego.model.response.AdminLookupsResponse;
import com.telego.model.status.STATUS;

@Service
public class AdminService {
	
	@Autowired
	private LookupService lookupService;
	
	public AdminLookupsResponse getAdminLookupsResponse() {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CountryDTO> countries  = lookupService.getAllCountries();
		// TODO areas;
		// TODO boxes;
		// TODO cabins;
		// TODO cities;
		// TODO countries;
		// TODO features;
		// TODO phones;
		// TODO logistics;
		// TODO features;
		// TODO phoneUsers;
		
		response.setLookupsCountries(countries);
		
		// TODO set every one into the response object
		
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	public AdminLookupsResponse updateAdminLookupsResponse(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CountryDTO> addCountries = request.getAddedCountries();
		List<CountryDTO> updatedCountries = request.getUpdatedCountries();
		List<CountryDTO> deletedCountries = request.getDeletedCountries();
		
		
		// TODO Do the same for each of the below
		// TODO areas;
		// TODO boxes;
		// TODO cabins;
		// TODO cities;
		// TODO features;
		// TODO phones;
		// TODO logistics;
		// TODO features;
		// TODO phoneUsers;
		
		lookupService.saveCountries(addCountries);
		lookupService.saveCountries(updatedCountries);
		lookupService.deleteCountries(deletedCountries);
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
}
