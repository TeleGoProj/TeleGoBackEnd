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
public class City {

	@Id
	@Column(name = "CITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cityGenerator")
	@SequenceGenerator(name="cityGenerator", sequenceName="city_sequence" , initialValue=1000, allocationSize=1)
	private Long cityId;

	@Column(name = "NAME_EN")
	private String nameEn;

	@Column(name = "NAME_AR")
	private String nameAr;

	@Column(name = "CODE")
	private String code;
	
	@Column(name = "PHONE_CODE")
	private String phoneCode;

	@OneToMany(mappedBy = "city", cascade=CascadeType.ALL)
	private List<Area> areas;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
	private Country country;

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

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
}
