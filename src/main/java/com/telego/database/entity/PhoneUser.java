package com.telego.database.entity;

import java.sql.Time;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_USER", schema = "PHONE", catalog = "")
public class PhoneUser {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "phoneUserGenerator")
	@SequenceGenerator(name = "phoneUserGenerator", sequenceName = "phone_user_sequence", initialValue = 1000, allocationSize = 1)
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

	@Lob
	@Column(name = "IMAGE")
	private byte[] image;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LANDLINE_PHONE_ID", referencedColumnName = "LANDLINE_PHONE_ID")
	private LandlinePhone landlinePhone;

	@OneToMany(mappedBy = "phoneUserByRequester", cascade = CascadeType.ALL)
	private Collection<Logistics> logisticsByUserId;

	@OneToMany(mappedBy = "phoneUserByDeliveryToUser", cascade = CascadeType.ALL)
	private Collection<Logistics> logistics;

	@OneToMany(mappedBy = "phoneUserByUser", cascade = CascadeType.ALL)
	private List<UserFeature> userFeatures;

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

	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
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

	public LandlinePhone getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(LandlinePhone landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	public Collection<Logistics> getLogisticsByUserId() {
		return logisticsByUserId;
	}

	public void setLogisticsByUserId(Collection<Logistics> logisticsByUserId) {
		this.logisticsByUserId = logisticsByUserId;
	}

	public Collection<Logistics> getLogistics() {
		return logistics;
	}

	public void setLogistics(Collection<Logistics> logistics) {
		this.logistics = logistics;
	}

	public List<UserFeature> getUserFeatures() {
		return userFeatures;
	}

	public void setUserFeatures(List<UserFeature> userFeatures) {
		this.userFeatures = userFeatures;
	}

}
