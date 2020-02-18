package com.telego.model;

import java.util.List;

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
	
	private List<AreaDTO>areas;
	private List<CabinDTO>cabins;
	private List<CountryDTO>countries;
	
}