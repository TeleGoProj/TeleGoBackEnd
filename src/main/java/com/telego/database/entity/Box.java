package com.telego.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

public class Box {

	@Id
	@Column(name = "BOX_ID")
	@EqualsAndHashCode.Include
	private Long boxId;

	@Column(name = "BOX_NAME")
	private String boxName;

	@Column(name = "LONGITUDE")
	private Float longitude;

	@Column(name = "LATITUDE")
	private Float latitude;

	@Column(name = "STREET_NAME")
	private String streetName;

	@ManyToOne
	@JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID")
	private Area areaByAreaId;

	@ManyToOne
	@JoinColumn(name = "CABIN_ID", referencedColumnName = "CABIN_ID")
	private Cabin cabinByCabinId;

	@OneToMany(mappedBy = "boxByBoxId")
	private Collection<LandlinePhone> landlinePhonesByBoxId;

}
