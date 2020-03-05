package com.telego.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDTO extends ModelDTO {
	private Long featureId;
	private String name;
	private String value;
	private String type;
	private boolean markedAsDeleted;
}
