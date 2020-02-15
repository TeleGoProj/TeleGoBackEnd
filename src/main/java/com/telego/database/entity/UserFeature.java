package com.telego.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "USER_FEATURE", schema = "PHONE", catalog = "")
public class UserFeature {
    
    @Id
    @Column(name = "USER_FEATURE_ID")
	@EqualsAndHashCode.Include
	private Long userFeatureId;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByUserId;
    
    @ManyToOne
    @JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID")
	private Feature featureByFeatureId;

}
