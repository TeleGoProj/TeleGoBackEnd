package com.telego.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@Column(name = "CITY_ID")
	private Long cityId;

	@Column(name = "NAME_EN")
	private String nameEn;

	@Column(name = "NAME_AR")
	private String nameAr;

	@Column(name = "CODE")
	private String code;

	@OneToMany(mappedBy = "cityByCityId")
	private Collection<Area> areasByCityId;

	@OneToMany(mappedBy = "cityByCityId")
	private Collection<Cabin> cabinsByCityId;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
	private Country countryByCountryId;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Collection<Area> getAreasByCityId() {
		return areasByCityId;
	}

	public void setAreasByCityId(Collection<Area> areasByCityId) {
		this.areasByCityId = areasByCityId;
	}

	public Collection<Cabin> getCabinsByCityId() {
		return cabinsByCityId;
	}

	public void setCabinsByCityId(Collection<Cabin> cabinsByCityId) {
		this.cabinsByCityId = cabinsByCityId;
	}

	public Country getCountryByCountryId() {
		return countryByCountryId;
	}

	public void setCountryByCountryId(Country countryByCountryId) {
		this.countryByCountryId = countryByCountryId;
	}

}
