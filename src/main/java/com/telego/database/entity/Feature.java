package com.telego.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Feature {

	@Id
	@Column(name = "FEATURE_ID")
	private Long featureId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "PARENT_ID")
	private Long parentId;

	@OneToOne
	@JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID", nullable = false)
	private Feature featureByFeatureId;

	@OneToOne(mappedBy = "featureByFeatureId")
	private Feature featureByFeatureId_0;

	@OneToMany(mappedBy = "featureByFeatureId")
	private Collection<UserFeature> userFeaturesByFeatureId;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public Collection<UserFeature> getUserFeaturesByFeatureId() {
		return userFeaturesByFeatureId;
	}

	public void setUserFeaturesByFeatureId(Collection<UserFeature> userFeaturesByFeatureId) {
		this.userFeaturesByFeatureId = userFeaturesByFeatureId;
	}

}
