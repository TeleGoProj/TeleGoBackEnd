package com.telego.database.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Country {

	@Id
	@Column(name = "COUNTRY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "countryGenerator")
	@SequenceGenerator(name="countryGenerator", sequenceName="country_sequence" , initialValue=1000, allocationSize=1)
	private Long countryId;

	@Column(name = "NAME_EN")
	private String nameEn;

	@Column(name = "NAME_AR")
	private String nameAr;

	@Column(name = "CODE")
	private String code;

	@OneToMany(mappedBy = "countryByCountryId")
	private List<City> citiesByCountryId;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
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

	public List<City> getCitiesByCountryId() {
		return citiesByCountryId;
	}

	public void setCitiesByCountryId(List<City> citiesByCountryId) {
		this.citiesByCountryId = citiesByCountryId;
	}

}
