package com.telego.model;

import java.util.List;
import java.util.Collection;

import com.telego.database.entity.LandlinePhone;
import com.telego.database.entity.Cabin;
import com.telego.database.entity.Area;

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
	
	private List<AreaDTO>areaByAreaId;
	private List<CabinDTO>cabinByCabinId;
	private List<LandlinePhoneDTO>landlinePhonesByBoxId;
}

