package com.telego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telego.database.entity.Area;
import com.telego.database.entity.Box;
import com.telego.database.entity.Cabin;
import com.telego.database.entity.City;
import com.telego.database.entity.Country;
import com.telego.database.entity.Feature;
import com.telego.database.entity.LandlinePhone;
import com.telego.database.rep.AreaRepository;
import com.telego.database.rep.BoxRepository;
import com.telego.database.rep.CabinRepository;
import com.telego.database.rep.CityRepository;
import com.telego.database.rep.CountryRepository;
import com.telego.database.rep.FeatureRepository;
import com.telego.database.rep.LandlinePhoneRepository;
import com.telego.model.AreaDTO;
import com.telego.model.BoxDTO;
import com.telego.model.CabinDTO;
import com.telego.model.CityDTO;
import com.telego.model.CountryDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.LandlinePhoneDTO;
import com.telego.util.EntityMapper;

@Service
public class LookupService {

	

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private BoxRepository boxRepository;

	@Autowired
	private CabinRepository cabinRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private FeatureRepository featureRepository;

	@Autowired
	private LandlinePhoneRepository landlinePhoneRepository;

	@Autowired
	private EntityMapper mapper;

	public List<CountryDTO> getAllCountries() {
		List<Country> countriesDatabase = countryRepository.findAll();
		List<CountryDTO> countriesDTOs = mapper.mapToCountriesDTOs(countriesDatabase);
		return countriesDTOs;
	}
	
	public  List<CityDTO> getCitiesByCountryId(Long id) {
		List<City> citiesDatabase = cityRepository.getCitiesByCountryId(id);
		List<CityDTO> citiesDTOs = mapper.mapToCitiesDTOs(citiesDatabase);
		return citiesDTOs;
	}
	
	

	public List<CountryDTO> saveCountries(List<CountryDTO> countries) {
		if (countries == null)
			return null;

		List<Country> countriesEntities = mapper.mapToCountriesEntities(countries);
		countriesEntities = countryRepository.saveAll(countriesEntities);
		countryRepository.flush();
		countries = mapper.mapToCountriesDTOs(countriesEntities);
		return countries;
	}

	public void deleteCountries(List<CountryDTO> countries) {
		if (countries == null)
			return;

		List<Country> countriesEntities = mapper.mapToCountriesEntities(countries);
		countryRepository.deleteAll(countriesEntities);
	}

///////////////////////////////////////////////////////////////////////////////	
	public List<AreaDTO> getAllAreas() {
		List<Area> areasDatabase = areaRepository.findAll();
		List<AreaDTO> areasDTOs = mapper.mapToAreasDTOs(areasDatabase);
		return areasDTOs;
	}

	public List<AreaDTO> saveAreas(List<AreaDTO> areas) {
		if (areas == null)
			return null;

		List<Area> areasEntities = mapper.mapToAreasEntities(areas);
		areasEntities = areaRepository.saveAll(areasEntities);
		areaRepository.flush();
		areas = mapper.mapToAreasDTOs(areasEntities);
		return areas;
	}

	public void deleteAreas(List<AreaDTO> areas) {
		if (areas == null)
			return;

		List<Area> areasEntities = mapper.mapToAreasEntities(areas);
		areaRepository.deleteAll(areasEntities);
	}
///////////////////////////////////////////////////////////////////////////////

	public List<BoxDTO> getAllBoxes() {
		List<Box> boxesDatabase = boxRepository.findAll();
		List<BoxDTO> boxesDTOs = mapper.mapToBoxesDTOs(boxesDatabase);
		return boxesDTOs;
	}

	public List<BoxDTO> saveBoxes(List<BoxDTO> boxes) {
		if (boxes == null)
			return null;

		List<Box> boxesEntities = mapper.mapToBoxesEntities(boxes);
		boxesEntities = boxRepository.saveAll(boxesEntities);
		areaRepository.flush();
		boxes = mapper.mapToBoxesDTOs(boxesEntities);
		return boxes;
	}

	public void deleteBoxes(List<BoxDTO> boxes) {
		if (boxes == null)
			return;

		List<Box> boxesEntities = mapper.mapToBoxesEntities(boxes);
		boxRepository.deleteAll(boxesEntities);
	}
///////////////////////////////////////////////////////////////////////////////

	public List<CabinDTO> getAllCabins() {
		List<Cabin> CabinsDatabase = cabinRepository.findAll();
		List<CabinDTO> CabinsDTOs = mapper.mapToCabinsDTOs(CabinsDatabase);
		return CabinsDTOs;
	}

	public List<CabinDTO> saveCabins(List<CabinDTO> cabins) {
		if (cabins == null)
			return null;

		List<Cabin> cabinsEntities = mapper.mapToCabinsEntities(cabins);
		cabinsEntities = cabinRepository.saveAll(cabinsEntities);
		cabinRepository.flush();
		cabins = mapper.mapToCabinsDTOs(cabinsEntities);
		return cabins;
	}

	public void deleteCabins(List<CabinDTO> cabins) {
		if (cabins == null)
			return;

		List<Cabin> cabinsEntities = mapper.mapToCabinsEntities(cabins);
		cabinRepository.deleteAll(cabinsEntities);
	}
///////////////////////////////////////////////////////////////////////////////

	public List<CityDTO> getAllCities() {
		List<City> citiesDatabase = cityRepository.findAll();
		List<CityDTO> citiesDTOs = mapper.mapToCitiesDTOs(citiesDatabase);
		return citiesDTOs;
	}

	public List<CityDTO> saveCities(List<CityDTO> cities) {
		if (cities == null)
			return null;

		List<City> citiesEntities = mapper.mapToCitiesEntities(cities);
		citiesEntities = cityRepository.saveAll(citiesEntities);
		cityRepository.flush();
		cities = mapper.mapToCitiesDTOs(citiesEntities);
		return cities;
	}

	public void deleteCities(List<CityDTO> cities) {
		if (cities == null)
			return;

		List<City> citiesEntities = mapper.mapToCitiesEntities(cities);
		cityRepository.deleteAll(citiesEntities);
	}
///////////////////////////////////////////////////////////////////////////////	

	public List<FeatureDTO> getAllFeatures() {
		List<Feature> featuresDatabase = featureRepository.findAll();
		List<FeatureDTO> featuresDTOs = mapper.mapToFeaturesDTOs(featuresDatabase);
		return featuresDTOs;
	}
	
	public List<LandlinePhoneDTO> getAllLandlinePhones() {
		List<LandlinePhone> phonesDatabase = landlinePhoneRepository.findAll();
		List<LandlinePhoneDTO> phonesDTOs = mapper.mapToLandlinePhonesDTOs(phonesDatabase);
		return phonesDTOs;
	}

	public List<FeatureDTO> saveFeatures(List<FeatureDTO> features) {
		if (features == null)
			return null;

		List<Feature> featuresEntities = mapper.mapToFeaturesEntities(features);
		featuresEntities = featureRepository.saveAll(featuresEntities);
		featureRepository.flush();
		features = mapper.mapToFeaturesDTOs(featuresEntities);
		return features;
	}

	public void deleteFeatures(List<FeatureDTO> features) {
		if (features == null)
			return;

		List<Feature> featuresEntities = mapper.mapToFeaturesEntities(features);
		featureRepository.deleteAll(featuresEntities);
	}

	public List<LandlinePhoneDTO> saveLandlinePhones(List<LandlinePhoneDTO> phones) {
		if (phones == null)
			return null;

		List<LandlinePhone> phonesEntities = mapper.mapToLandlinePhonesEntities(phones);
		phonesEntities = landlinePhoneRepository.saveAll(phonesEntities);
		landlinePhoneRepository.flush();
		phones = mapper.mapToLandlinePhonesDTOs(phonesEntities);
		return phones;
	}

	public void deleteLandlinePhones(List<LandlinePhoneDTO> phones) {
		if (phones == null)
			return;

		List<LandlinePhone> phonesEntities = mapper.mapToLandlinePhonesEntities(phones);
		landlinePhoneRepository.deleteAll(phonesEntities);
	}

	

}
