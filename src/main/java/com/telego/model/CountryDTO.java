package com.telego.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CountryDTO {

	@EqualsAndHashCode.Include
	private Long countryId;

	private String nameEn;
	private String nameAr;
	private String code;

}
