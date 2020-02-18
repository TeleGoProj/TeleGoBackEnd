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
public class BoxDTO {
	private Long boxId;
	private String boxName;
	private Float longitude;
	private Float latitude;
	private String streetName;
	
	private List<AreaDTO>areas;
	private List<CabinDTO>cabins;
	private List<LandlinePhoneDTO>landlinePhones;
}

