package com.telego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telego.database.entity.Country;
import com.telego.database.rep.CountryRepository;
import com.telego.model.CountryDTO;
import com.telego.util.EntityMapper;

@Service
public class LookupService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private EntityMapper mapper;

	public List<CountryDTO> getAllCountries() {
		List<Country> countriesDatabase = countryRepository.findAll();
		List<CountryDTO> countriesDTOs = mapper.mapToCountriesDTOs(countriesDatabase);
		return countriesDTOs;
	}

	public List<CountryDTO> saveCountries(List<CountryDTO> countries) {
		if(countries == null)
			return null;
		
		List<Country> countriesEntities = mapper.mapToCountriesEntities(countries);
		countriesEntities = countryRepository.saveAll(countriesEntities);
		countryRepository.flush();
		countries = mapper.mapToCountriesDTOs(countriesEntities);
		return countries;
	}

	public void deleteCountries(List<CountryDTO> countries) {
		if(countries == null)
			return;
		
		List<Country> countriesEntities = mapper.mapToCountriesEntities(countries);
		countryRepository.deleteAll(countriesEntities);
	}

	// TODO getAllAreas;
	// TODO saveAreas;
	// TODO deleteAreas;
	
	
	// TODO getAllBoxes;
	// TODO saveBoxes;
	// TODO deleteBoxes;
	
	
	// TODO getAllCabin;
	// TODO saveAllCabin;
	// TODO deleteAllCabin;
	
	
	// TODO getAllCity;
	// TODO saveAllCity;
	// TODO deleteCity;
	
	
	// TODO getAllCountries;
	// TODO saveCountries;
	// TODO deleteCountries;
	
	
	// TODO getAllFeatures;
	// TODO saveFeatures;
	// TODO deleteFeatures;
}
