package com.telego.database.entity;


import java.util.List;

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
public class Cabin {

	@Id
	@Column(name = "CABIN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cabinGenerator")
	@SequenceGenerator(name="cabinGenerator", sequenceName="cabin_sequence" , initialValue=1000, allocationSize=1)
	private Long cabinId;

	@Column(name = "CABIN_NAME")
	private String cabinName;

	@OneToMany(mappedBy = "cabinByCabinId")
	private List<Box> boxesByCabinId;

	@ManyToOne
	@JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
	private City cityByCityId;

	public Long getCabinId() {
		return cabinId;
	}

	public void setCabinId(Long cabinId) {
		this.cabinId = cabinId;
	}

	public String getCabinName() {
		return cabinName;
	}

	public void setCabinName(String cabinName) {
		this.cabinName = cabinName;
	}

	public List<Box> getBoxesByCabinId() {
		return boxesByCabinId;
	}

	public void setBoxesByCabinId(List<Box> boxesByCabinId) {
		this.boxesByCabinId = boxesByCabinId;
	}

	public City getCityByCityId() {
		return cityByCityId;
	}

	public void setCityByCityId(City cityByCityId) {
		this.cityByCityId = cityByCityId;
	}

}
