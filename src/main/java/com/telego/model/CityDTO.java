package com.telego.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO extends ModelDTO {
	private Long cityId;
	private String nameEn;
	private String nameAr;
	private String code;
	private boolean markedAsDeleted;
	
	private List<AreaDTO>areas;
	private CountryDTO country;
	
}