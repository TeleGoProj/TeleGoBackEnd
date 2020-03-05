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
public class BoxDTO extends ModelDTO{
	private Long boxId;
	private String boxName;
	private Float longitude;
	private Float latitude;
	private String streetName;
	private boolean markedAsDeleted;
	
	
	private List<CabinDTO>cabins;
	private List<LandlinePhoneDTO>landlinePhones;
}

