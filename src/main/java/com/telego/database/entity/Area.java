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
public class Area {

	@Id
	@Column(name = "AREA_ID")
	@EqualsAndHashCode.Include
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

}
