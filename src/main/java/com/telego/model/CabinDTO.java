package com.telego.model;

import java.util.Collection;
import java.util.List;

import com.telego.database.entity.Box;
import com.telego.database.entity.City;

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
	private BoxDTO boxesByCabinId;
	private CityDTO cityByCityId;
	
}