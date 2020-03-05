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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AdminLookupsRequest extends Request{

	private List<CountryDTO> countries;
	private List<AreaDTO> areas;
	private List<BoxDTO> boxes;
	private List<CabinDTO> cabins;
	private List<CityDTO> cities;
	private List<FeatureDTO> features;
	private List<LandlinePhoneDTO> landlinePhones;
	private List<LogisticsDTO> logistics;
	
}
