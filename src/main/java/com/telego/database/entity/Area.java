package com.telego.database.entity;

import java.util.Collection;

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
public class Area {

	@Id
	@Column(name = "AREA_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "areaGenerator")
	@SequenceGenerator(name="areaGenerator", sequenceName="area_sequence" , initialValue=1000, allocationSize=1)
	private Long areaId;

	@Column(name = "AREA_NAME_EN")
	private String areaNameEn;

	@Column(name = "AREA_NAME_AR")
	private String areaNameAr;

	@ManyToOne
	@JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
	private City cityByCityId;

	@OneToMany(mappedBy = "areaByAreaId")
	private Collection<Box> boxesByAreaId;

	@OneToMany(mappedBy = "areaByDeliveryToAreaId")
	private Collection<Logistics> logisticsByAreaId;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaNameEn() {
		return areaNameEn;
	}

	public void setAreaNameEn(String areaNameEn) {
		this.areaNameEn = areaNameEn;
	}

	public String getAreaNameAr() {
		return areaNameAr;
	}

	public void setAreaNameAr(String areaNameAr) {
		this.areaNameAr = areaNameAr;
	}

	public City getCityByCityId() {
		return cityByCityId;
	}

	public void setCityByCityId(City cityByCityId) {
		this.cityByCityId = cityByCityId;
	}

	public Collection<Box> getBoxesByAreaId() {
		return boxesByAreaId;
	}

	public void setBoxesByAreaId(Collection<Box> boxesByAreaId) {
		this.boxesByAreaId = boxesByAreaId;
	}

	public Collection<Logistics> getLogisticsByAreaId() {
		return logisticsByAreaId;
	}

	public void setLogisticsByAreaId(Collection<Logistics> logisticsByAreaId) {
		this.logisticsByAreaId = logisticsByAreaId;
	}

}
