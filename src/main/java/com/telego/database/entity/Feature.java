package com.telego.database.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Feature {
	
    @Id
    @Column(name = "FEATURE_ID")
	@EqualsAndHashCode.Include
    private Long featureId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "VALUE")
    private String value;
    
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "CATEGORY")
    private String category;
    
    @Column(name = "PARENT_ID")
    private Long parentId;
    
    @OneToOne
    @JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID", nullable = false)
    private Feature featureByFeatureId;
    
    @OneToOne(mappedBy = "featureByFeatureId")
    private Feature featureByFeatureId_0;
    
    @OneToMany(mappedBy = "featureByFeatureId")
    private Collection<UserFeature> userFeaturesByFeatureId;

}
