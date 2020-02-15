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

public class City {
	
    @Id
    @Column(name = "CITY_ID")
	@EqualsAndHashCode.Include
    private Long cityId;
    
    @Column(name = "NAME_EN")
    private String nameEn;
    
    @Column(name = "NAME_AR")
    private String nameAr;
    
    @Column(name = "CODE")
    private String code;
    
//    @OneToMany(mappedBy = "cityByCityId")
//    private Collection<Area> areasByCityId;
//    
//    @OneToMany(mappedBy = "cityByCityId")
//    private Collection<Cabin> cabinsByCityId;
    
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
    private Country countryByCountryId;

}
