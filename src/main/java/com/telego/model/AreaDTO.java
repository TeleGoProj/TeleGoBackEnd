package com.telego.model;

import java.util.List;

import com.telego.database.entity.Box;
import com.telego.database.entity.Logistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AreaDTO {
	private Long areaId;
	private String areaNameEn;
	private String areaNameAr;
	private CityDTO cityDTO;
	private List<BoxDTO> boxesByAreaId;
	private List<LogisticsDTO> logisticsByAreaId;
}
