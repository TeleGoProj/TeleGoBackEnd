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
public class AreaDTO extends ModelDTO{
	private Long areaId;
	private String areaNameEn;
	private String areaNameAr;
	
	private CityDTO cityDTO;
	private List<CabinDTO> cabins;
}
