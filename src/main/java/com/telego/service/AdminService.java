package com.telego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telego.model.AreaDTO;
import com.telego.model.BoxDTO;
import com.telego.model.CabinDTO;
import com.telego.model.CityDTO;
import com.telego.model.CountryDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.LandlinePhoneDTO;
import com.telego.model.ModelDTO;
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
		List<AreaDTO> areas = lookupService.getAllAreas();
		List<BoxDTO> boxes = lookupService.getAllBoxes();
		List<CabinDTO> cabins = lookupService.getAllCabins();
		List<CityDTO> cities = lookupService.getAllCities();
		List<FeatureDTO> features = lookupService.getAllFeatures();
		List<LandlinePhoneDTO> phones = lookupService.getAllLandlinePhones();

		response.setCountries(countries);
		response.setAreas(areas);
		response.setBoxes(boxes);
		response.setCabins(cabins);
		response.setCities(cities);
		response.setFeatures(features);
		response.setLandlinePhones(phones);
		
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	
	public AdminLookupsResponse getCitiesByCountryId(Long id) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CityDTO> citiesResult = lookupService.getCitiesByCountryId(id);
		response.setCities(citiesResult);
	      return response ;
				  
	}

	
	
	public AdminLookupsResponse processCountries(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CountryDTO> addedAndupdatedCountries = request.getCountries();
		List<CountryDTO> deletedCountries = request.getDeletedCountries();
		
		addedAndupdatedCountries = lookupService.saveCountries(addedAndupdatedCountries);
		lookupService.deleteCountries(deletedCountries);
		
		response.setCountries(addedAndupdatedCountries);
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public AdminLookupsResponse processCities(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CityDTO> cities = request.getCities();
		
		lookupService.saveCities((List<CityDTO>) ModelDTO.filterUpdatesModels(cities));
		lookupService.deleteCities((List<CityDTO>) ModelDTO.filterDeletesModels(cities));
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public AdminLookupsResponse processAreas(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<AreaDTO> areas = request.getAreas();
		
		lookupService.saveAreas((List<AreaDTO>) ModelDTO.filterUpdatesModels(areas));
		lookupService.deleteAreas((List<AreaDTO>) ModelDTO.filterDeletesModels(areas));
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public AdminLookupsResponse processBoxes(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<BoxDTO> boxes = request.getBoxes();
		
		lookupService.saveBoxes((List<BoxDTO>) ModelDTO.filterUpdatesModels(boxes));
		lookupService.deleteBoxes((List<BoxDTO>) ModelDTO.filterDeletesModels(boxes));
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public AdminLookupsResponse processCabins(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CabinDTO> cabins = request.getCabins();
		
		lookupService.saveCabins((List<CabinDTO>) ModelDTO.filterUpdatesModels(cabins));
		lookupService.deleteCabins((List<CabinDTO>) ModelDTO.filterDeletesModels(cabins));
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public AdminLookupsResponse processFeatures(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<FeatureDTO> features = request.getFeatures();
		
		lookupService.saveFeatures((List<FeatureDTO>) ModelDTO.filterUpdatesModels(features));
		lookupService.deleteFeatures((List<FeatureDTO>) ModelDTO.filterDeletesModels(features));
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public AdminLookupsResponse processLandlinePhones(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<LandlinePhoneDTO> phones = request.getLandlinePhones();
		
		lookupService.saveLandlinePhones((List<LandlinePhoneDTO>) ModelDTO.filterUpdatesModels(phones));
		lookupService.deleteLandlinePhones((List<LandlinePhoneDTO>) ModelDTO.filterDeletesModels(phones));
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
}
