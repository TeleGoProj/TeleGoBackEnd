package com.telego.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

	@Id
	@Column(name = "COUNTRY_ID")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long countryId;

	@Column(name = "NAME_EN")
	private String nameEn;

	@Column(name = "NAME_AR")
	private String nameAr;

	@Column(name = "CODE")
	private String code;

	@OneToMany(mappedBy = "countryByCountryId")
	private Collection<City> citiesByCountryId;

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

	public Collection<City> getCitiesByCountryId() {
		return citiesByCountryId;
	}

	public void setCitiesByCountryId(Collection<City> citiesByCountryId) {
		this.citiesByCountryId = citiesByCountryId;
	}

}
