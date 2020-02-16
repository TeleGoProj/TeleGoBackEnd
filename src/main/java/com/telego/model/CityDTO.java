package com.telego.model;

import java.util.Collection;
import java.util.List;

import com.telego.database.entity.Area;
import com.telego.database.entity.Cabin;
import com.telego.database.entity.Country;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CityDTO {
	private Long cityId;
	private String nameEn;
	private String nameAr;
	private String code;
	
	private List<AreaDTO>areasByCityId;
	private List<CabinDTO>cabinsByCityId;
	private List<CountryDTO>countryByCountryId;
	
}