package com.telego.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telego.database.entity.Country;
import com.telego.database.rep.CountryRepository;
import com.telego.model.CountryDTO;
import com.telego.util.EntityMapper;

@Service
public class LookupService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private EntityMapper mapper;
	
	public List<CountryDTO> getAllCountries(){
		logger.info("getAllCountries - entry");
		
		List<Country> countriesDatabase = countryRepository.findAll();
		List<CountryDTO> countriesDTOs = mapper.mapToCountriesDTOs(countriesDatabase);
		
		logger.info("getAllCountries - return: {}", countriesDatabase);
		return countriesDTOs;
	}
}
