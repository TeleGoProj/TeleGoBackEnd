package com.telego.database.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Box {

	@Id
	@Column(name = "BOX_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "boxGenerator")
	@SequenceGenerator(name="boxGenerator", sequenceName="box_sequence" , initialValue=1000, allocationSize=1)
	private Long boxId;

	@Column(name = "BOX_NAME")
	private String boxName;

	@Column(name = "LONGITUDE")
	private Float longitude;

	@Column(name = "LATITUDE")
	private Float latitude;

	@Column(name = "STREET_NAME")
	private String streetName;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CABIN_ID", referencedColumnName = "CABIN_ID")
	private Cabin cabinByCabinId;

	
	
	@OneToMany(mappedBy = "boxByBoxId", cascade=CascadeType.ALL)
	private List<LandlinePhone> landlinePhonesByBoxId;

	public Long getBoxId() {
		return boxId;
	}

	public void setBoxId(Long boxId) {
		this.boxId = boxId;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Cabin getCabinByCabinId() {
		return cabinByCabinId;
	}

	public void setCabinByCabinId(Cabin cabinByCabinId) {
		this.cabinByCabinId = cabinByCabinId;
	}

	public List<LandlinePhone> getLandlinePhonesByBoxId() {
		return landlinePhonesByBoxId;
	}

	public void setLandlinePhonesByBoxId(List<LandlinePhone> landlinePhonesByBoxId) {
		this.landlinePhonesByBoxId = landlinePhonesByBoxId;
	}

}
