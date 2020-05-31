package com.telego.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO extends ModelDTO{

	@EqualsAndHashCode.Include
	private Long countryId;

	private String nameEn;
	private String nameAr;
	private String code;
	private String phoneCode;
	private String uiStyle;
	private boolean markedAsDeleted;
	
	private List<CityDTO> cities;

}
