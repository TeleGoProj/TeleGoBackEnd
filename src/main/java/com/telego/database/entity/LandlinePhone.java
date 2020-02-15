package com.telego.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LANDLINE_PHONE", schema = "PHONE", catalog = "")
public class LandlinePhone {

	@Id
	@Column(name = "LANDLINE_PHONE_ID")
	private Long landlinePhoneId;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByUserId;

	@ManyToOne
	@JoinColumn(name = "BOX_ID", referencedColumnName = "BOX_ID")
	private Box boxByBoxId;

	public Long getLandlinePhoneId() {
		return landlinePhoneId;
	}

	public void setLandlinePhoneId(Long landlinePhoneId) {
		this.landlinePhoneId = landlinePhoneId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneUser getPhoneUserByUserId() {
		return phoneUserByUserId;
	}

	public void setPhoneUserByUserId(PhoneUser phoneUserByUserId) {
		this.phoneUserByUserId = phoneUserByUserId;
	}

	public Box getBoxByBoxId() {
		return boxByBoxId;
	}

	public void setBoxByBoxId(Box boxByBoxId) {
		this.boxByBoxId = boxByBoxId;
	}

}
