package com.telego.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FEATURE", schema = "PHONE", catalog = "")
public class UserFeature {

	@Id
	@Column(name = "USER_FEATURE_ID")
	private Long userFeatureId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByUserId;

	@ManyToOne
	@JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID")
	private Feature featureByFeatureId;

	public Long getUserFeatureId() {
		return userFeatureId;
	}

	public void setUserFeatureId(Long userFeatureId) {
		this.userFeatureId = userFeatureId;
	}

	public PhoneUser getPhoneUserByUserId() {
		return phoneUserByUserId;
	}

	public void setPhoneUserByUserId(PhoneUser phoneUserByUserId) {
		this.phoneUserByUserId = phoneUserByUserId;
	}

	public Feature getFeatureByFeatureId() {
		return featureByFeatureId;
	}

	public void setFeatureByFeatureId(Feature featureByFeatureId) {
		this.featureByFeatureId = featureByFeatureId;
	}

}
