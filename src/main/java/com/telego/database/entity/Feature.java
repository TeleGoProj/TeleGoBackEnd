package com.telego.database.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Feature {

	@Id
	@Column(name = "FEATURE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "featureGenerator")
	@SequenceGenerator(name="featureGenerator", sequenceName="feature_sequence" , initialValue=1000, allocationSize=1)
	private Long featureId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "TYPE")
	private String type;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID", nullable = false)
	private Feature featureByFeatureId;

	@OneToOne(mappedBy = "featureByFeatureId", cascade=CascadeType.ALL)
	private Feature featureByFeatureId_0;

	@OneToMany(mappedBy = "featureByFeatureId", cascade=CascadeType.ALL)
	private List<UserFeature> userFeaturesByFeatureId;

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

	public Feature getFeatureByFeatureId() {
		return featureByFeatureId;
	}

	public void setFeatureByFeatureId(Feature featureByFeatureId) {
		this.featureByFeatureId = featureByFeatureId;
	}

	public Feature getFeatureByFeatureId_0() {
		return featureByFeatureId_0;
	}

	public void setFeatureByFeatureId_0(Feature featureByFeatureId_0) {
		this.featureByFeatureId_0 = featureByFeatureId_0;
	}

	public List<UserFeature> getUserFeaturesByFeatureId() {
		return userFeaturesByFeatureId;
	}

	public void setUserFeaturesByFeatureId(List<UserFeature> userFeaturesByFeatureId) {
		this.userFeaturesByFeatureId = userFeaturesByFeatureId;
	}

}
