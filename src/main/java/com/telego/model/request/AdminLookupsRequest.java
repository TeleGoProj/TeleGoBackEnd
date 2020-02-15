package com.telego.model.request;

import java.util.List;

import com.telego.model.CountryDTO;

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
	
	// TODO addedAreas;
	// TODO updatedAreas;
	// TODO deletedAreas;
	
	
	// TODO addedBoxes;
	// TODO updatedBoxes;
	// TODO deletedBoxes;
	
	
	// TODO addedCabin;
	// TODO updatedCabin;
	// TODO deletedCabin;
	
	
	// TODO addedCities;
	// TODO updatedCities;
	// TODO deletedCities;
	
	
	// TODO addedCountries;
	// TODO updatedCountries;
	// TODO deletedCountries;
	
	
	// TODO addedFeatures;
	// TODO updatedFeatures;
	// TODO deletedFeatures;
	
	
	// TODO addedLinePhones;
	// TODO updatedPhones;
	// TODO deletedLinePhones;
	
	
	// TODO addedLogistics;
	// TODO updatedLogistics;
	// TODO deletedLogistics;
	
	
	// TODO addedFeatures;
	// TODO updatedFeatures;
	// TODO deletedFeatures;
	
	
	// TODO addedPhoneUsers;
	// TODO updatedPhoneUsers;
	// TODO deletedPhoneUsers;
}
