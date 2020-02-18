package com.telego.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CabinDTO {
	private Long cabinId;
	private String cabinName;
	private BoxDTO boxes;
	private CityDTO cities;
	
}