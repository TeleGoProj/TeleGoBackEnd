package com.telego.model.response;

import java.util.List;

import com.telego.model.AreaDTO;
import com.telego.model.CountryDTO;
import com.telego.model.BoxDTO;
import com.telego.model.CabinDTO;
import com.telego.model.CityDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.LandlinePhoneDTO;
import com.telego.model.LogisticsDTO;
import com.telego.model.PhoneUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.telego.model.status.STATUS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdminLookupsResponse extends Response {

	private STATUS status;

	private List<CountryDTO> lookupsCountries;
	private List<AreaDTO> lookupsAreas;
	private List<BoxDTO> lookupsBoxes;
	private List<CabinDTO> lookupsCabins;
	private List<CityDTO> lookupsCities;
	private List<FeatureDTO> lookupsFeatures;
	private List<LandlinePhoneDTO> lookupsLandlinePhones;
	private List<LogisticsDTO> lookupslogistics;
	private List<PhoneUserDTO> lookupsPhoneUsers;
	
	// TODO lookupsAreas - Done;
	// TODO lookupsBoxes - Done;
	// TODO lookupsCabin - Done;
	// TODO lookupsCity - Done;
	// TODO lookupsCountries - Done;
	// TODO lookupsFeatures - Done;
	// TODO landLinePhones - Done;
	// TODO logistics - Done;
	// TODO lookupsFeatures - Done;
	// TODO phoneUsers - Done;

}
