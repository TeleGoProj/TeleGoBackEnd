package com.telego.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class FeatureDTO {
	private Long featureId;
	private String name;
	private String value;
	private String type;
	private String category;
	private Long parentId;
	
	
}
