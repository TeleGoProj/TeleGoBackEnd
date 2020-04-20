package com.telego.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Feature {

	@Id
	@Column(name = "FEATURE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "featureGenerator")
	@SequenceGenerator(name = "featureGenerator", sequenceName = "feature_sequence", initialValue = 1000, allocationSize = 1)
	private Long featureId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "TYPE")
	private String type;

	public Long getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
