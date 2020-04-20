package com.telego.database.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FEATURE", schema = "PHONE", catalog = "")
public class UserFeature {

	@Id
	@Column(name = "USER_FEATURE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userFeaureGenerator")
	@SequenceGenerator(name="userFeaureGenerator", sequenceName="user_feaure_sequence" , initialValue=1000, allocationSize=1)
	private Long userFeatureId;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByUser;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID")
	private Feature featureByFeatureId;

	public Long getUserFeatureId() {
		return userFeatureId;
	}

	public void setUserFeatureId(Long userFeatureId) {
		this.userFeatureId = userFeatureId;
	}

	public PhoneUser getPhoneUserByUser() {
		return phoneUserByUser;
	}
	
	public void setPhoneUserByUser(PhoneUser phoneUserByUser) {
		this.phoneUserByUser = phoneUserByUser;
	}

	public Feature getFeatureByFeatureId() {
		return featureByFeatureId;
	}

	public void setFeatureByFeatureId(Feature featureByFeatureId) {
		this.featureByFeatureId = featureByFeatureId;
	}

}
