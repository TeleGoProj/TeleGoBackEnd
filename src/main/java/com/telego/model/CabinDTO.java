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
public class CabinDTO extends ModelDTO{
	private Long cabinId;
	private String cabinName;
	private boolean markedAsDeleted;
	
	private List<BoxDTO> boxes;
	private AreaDTO area;
	
}