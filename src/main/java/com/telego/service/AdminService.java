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

		
		
		response.setLookupsCountries(countries);
		response.setLookupsAreas(areas);
		response.setLookupsBoxes(boxes);
		response.setLookupsCabins(cabins);
		response.setLookupsCities(cities);
		response.setLookupsFeatures(features);

		
		
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
	
	public AdminLookupsResponse updateAdminLookupsResponse(AdminLookupsRequest request) {
		AdminLookupsResponse response = new AdminLookupsResponse();
		
		List<CountryDTO> addCountries = request.getAddedCountries();
		List<CountryDTO> updatedCountries = request.getUpdatedCountries();
		List<CountryDTO> deletedCountries = request.getDeletedCountries();
		
		List<AreaDTO> addAreas = request.getAddedAreas();
		List<AreaDTO> updatedAreas = request.getUpdatedAreas();
		List<AreaDTO> deletedAreas = request.getDeletedAreas();
		
		List<BoxDTO> addBoxes = request.getAddedBoxes();
		List<BoxDTO> updatedBoxes = request.getUpdatedBoxes();
		List<BoxDTO> deletedBoxes = request.getDeletedBoxes();
		
		List<CabinDTO> addCabins = request.getAddedCabins();
		List<CabinDTO> updatedCabins = request.getUpdatedCabins();
		List<CabinDTO> deletedCabins = request.getDeletedCabins();
		
		List<CityDTO> addCities = request.getAddedCities();
		List<CityDTO> updatedCities = request.getUpdatedCities();
		List<CityDTO> deletedCities = request.getDeletedCities();
		
		List<FeatureDTO> addFeatures = request.getAddedFeatures();
		List<FeatureDTO> updatedFeatures = request.getUpdatedFeatures();
		List<FeatureDTO> deletedFeatures = request.getDeletedFeatures();
		
		
		
		lookupService.saveCountries(addCountries);
		lookupService.saveCountries(updatedCountries);
		lookupService.deleteCountries(deletedCountries);
		
		lookupService.saveAreas(addAreas);
		lookupService.saveAreas(updatedAreas);
		lookupService.deleteAreas(deletedAreas);
		
		lookupService.saveBoxes(addBoxes);
		lookupService.saveBoxes(updatedBoxes);
		lookupService.deleteBoxes(deletedBoxes);
		
		lookupService.saveCabins(addCabins);
		lookupService.saveCabins(updatedCabins);
		lookupService.deleteCabins(deletedCabins);
		
		lookupService.saveCities(addCities);
		lookupService.saveCities(updatedCities);
		lookupService.deleteCities(deletedCities);
		
		
		lookupService.saveFeatures(addFeatures);
		lookupService.saveFeatures(updatedFeatures);
		lookupService.deleteFeatures(deletedFeatures);
				
		response.setStatus(STATUS.SUCCESS);
		return response;
	}
}
