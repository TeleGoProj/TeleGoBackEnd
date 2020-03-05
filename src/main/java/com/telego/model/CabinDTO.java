package com.telego.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabinDTO extends ModelDTO{
	private Long cabinId;
	private String cabinName;
	private BoxDTO boxes;
	private boolean markedAsDeleted;
	private CityDTO city;
	
}