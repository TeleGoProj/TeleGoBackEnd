package com.telego.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Country {

	@Id
	@Column(name = "COUNTRY_ID")
	@EqualsAndHashCode.Include
	private Long countryId;

	@Column(name = "NAME_EN")
	private String nameEn;

	@Column(name = "NAME_AR")
	private String nameAr;

	@Column(name = "CODE")
	private String code;

	@OneToMany(mappedBy = "countryByCountryId")
	private Collection<City> citiesByCountryId;

}
