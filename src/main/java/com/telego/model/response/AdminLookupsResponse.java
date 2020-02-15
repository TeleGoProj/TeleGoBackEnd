package com.telego.model.response;

import java.util.List;

import com.telego.model.AreaDTO;
import com.telego.model.CountryDTO;

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
	// TODO lookupsAreas;
	// TODO lookupsBoxes;
	// TODO lookupsCabin;
	// TODO lookupsCity;
	// TODO lookupsCountries;
	// TODO lookupsFeatures;
	// TODO landLinePhones;
	// TODO logistics;
	// TODO lookupsFeatures;
	// TODO phoneUsers;

}
