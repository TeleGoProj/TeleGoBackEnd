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
public class Cabin {
	
    @Id
    @Column(name = "CABIN_ID")
	@EqualsAndHashCode.Include
    private Long cabinId;
    
    @Column(name = "CABIN_NAME")
    private String cabinName;
    
    @OneToMany(mappedBy = "cabinByCabinId")
    private Collection<Box> boxesByCabinId;
    
    @ManyToOne
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    private City cityByCityId;

}
