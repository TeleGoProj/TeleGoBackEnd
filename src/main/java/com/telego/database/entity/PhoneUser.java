package com.telego.database.entity;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_USER", schema = "PHONE", catalog = "")
public class PhoneUser {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "phoneUserGenerator")
	@SequenceGenerator(name="phoneUserGenerator", sequenceName="phone_user_sequence" , initialValue=1000, allocationSize=1)
	private Long userId;

	@Column(name = "LOGIN_NAME")
	private String loginName;

	@Column(name = "LOGIN_PASSWORD")
	private String loginPassword;

	@Column(name = "CREATION_DATE")
	private Time creationDate;

	@Column(name = "F_NAME")
	private String fName;

	@Column(name = "M_NAME")
	private String mName;

	@Column(name = "L_NAME")
	private String lName;

	@Column(name = "ORGANIZATION_TYPE")
	private Long organizationType;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IMAGE_PATH")
	private String imagePath;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "MOBILE_PHONE")
	private String mobilePhone;

	@Column(name = "ORGANIZATION_NAME")
	private String organizationName;

	@Column(name = "USER_STATUS")
	private Long userStatus;

	@Column(name = "USER_TYPE")
	private Long userType;

	@OneToMany(mappedBy = "phoneUserByUserId", cascade=CascadeType.ALL)
	private Collection<LandlinePhone> landlinePhonesByUserId;

	@OneToMany(mappedBy = "phoneUserByRequesterUserId", cascade=CascadeType.ALL)
	private Collection<Logistics> logisticsByUserId;

	@OneToMany(mappedBy = "phoneUserByDeliveryToUserId", cascade=CascadeType.ALL)
	private Collection<Logistics> logisticsByUserId_0;

	@OneToMany(mappedBy = "phoneUserByUserId", cascade=CascadeType.ALL)
	private Collection<UserFeature> userFeaturesByUserId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Time getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Time creationDate) {
		this.creationDate = creationDate;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Long getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(Long organizationType) {
		this.organizationType = organizationType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Long getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Long userStatus) {
		this.userStatus = userStatus;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public Collection<LandlinePhone> getLandlinePhonesByUserId() {
		return landlinePhonesByUserId;
	}

	public void setLandlinePhonesByUserId(Collection<LandlinePhone> landlinePhonesByUserId) {
		this.landlinePhonesByUserId = landlinePhonesByUserId;
	}

	public Collection<Logistics> getLogisticsByUserId() {
		return logisticsByUserId;
	}

	public void setLogisticsByUserId(Collection<Logistics> logisticsByUserId) {
		this.logisticsByUserId = logisticsByUserId;
	}

	public Collection<Logistics> getLogisticsByUserId_0() {
		return logisticsByUserId_0;
	}

	public void setLogisticsByUserId_0(Collection<Logistics> logisticsByUserId_0) {
		this.logisticsByUserId_0 = logisticsByUserId_0;
	}

	public Collection<UserFeature> getUserFeaturesByUserId() {
		return userFeaturesByUserId;
	}

	public void setUserFeaturesByUserId(Collection<UserFeature> userFeaturesByUserId) {
		this.userFeaturesByUserId = userFeaturesByUserId;
	}

}
