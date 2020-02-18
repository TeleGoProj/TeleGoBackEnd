package com.telego.model.request;

import java.util.List;

import com.telego.model.AreaDTO;
import com.telego.model.BoxDTO;
import com.telego.model.CabinDTO;
import com.telego.model.CityDTO;
import com.telego.model.CountryDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.LandlinePhoneDTO;
import com.telego.model.LogisticsDTO;
import com.telego.model.PhoneUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AdminLookupsRequest extends Request{

	private List<CountryDTO> addedCountries;
	private List<CountryDTO> updatedCountries;
	private List<CountryDTO> deletedCountries;
	
	private List<AreaDTO> addedAreas;
	private List<AreaDTO> updatedAreas;
	private List<AreaDTO> deletedAreas;
	
	private List<BoxDTO> addedBoxes;
	private List<BoxDTO> updatedBoxes;
	private List<BoxDTO> deletedBoxes;
	
	private List<CabinDTO> addedCabins;
	private List<CabinDTO> updatedCabins;
	private List<CabinDTO> deletedCabins;
	
	private List<CityDTO> addedCities;
	private List<CityDTO> updatedCities;
	private List<CityDTO> deletedCities;
	
	private List<FeatureDTO> addedFeatures;
	private List<FeatureDTO> updatedFeatures;
	private List<FeatureDTO> deletedFeatures;
	
	private List<LandlinePhoneDTO> addedLandlinePhone;
	private List<LandlinePhoneDTO> updatedLandPhone;
	private List<LandlinePhoneDTO> deletedLandlinePhones;
	
	private List<LogisticsDTO> addedLogistics;
	private List<LogisticsDTO> updatedLogistics;
	private List<LogisticsDTO> deletedLogistics;
	
	private List<PhoneUserDTO> addedPhoneUsers;
	private List<PhoneUserDTO> updatedPhoneUsers;
	private List<PhoneUserDTO> deletedPhoneUsers;
	
}
