package com.telego.database.entity;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "PHONE_USER", schema = "PHONE", catalog = "")
public class PhoneUser {
    
    @Id
    @Column(name = "USER_ID")
	@EqualsAndHashCode.Include
	private Long userId;
    
    @Column(name = "LOGIN_NAME")
	private String loginName;
    
    @Column(name = "LOGIN_PASSWORD")
	private String loginPassword;
    
    @Column(name = "CREATION_DATE")
	private Time creationDate;
    
    @Column(name = "F_NAME")
	private String fName;
    
    @Column(name = "M_NAME")
	private String mName;
    
    @Column(name = "L_NAME")
	private String lName;
    
    @Column(name = "ORGANIZATION_TYPE")
	private Long organizationType;
    
    @Column(name = "EMAIL")
	private String email;
    
    @Column(name = "IMAGE_PATH")
	private String imagePath;
    
    @Column(name = "ADDRESS")
	private String address;
    
    @Column(name = "MOBILE_PHONE")
	private String mobilePhone;
    
    @Column(name = "ORGANIZATION_NAME")
	private String organizationName;
    
    @Column(name = "USER_STATUS")
	private Long userStatus;
    
    @Column(name = "USER_TYPE")
	private Long userType;
    
    @OneToMany(mappedBy = "phoneUserByUserId")
	private Collection<LandlinePhone> landlinePhonesByUserId;
    
    @OneToMany(mappedBy = "phoneUserByRequesterUserId")
	private Collection<Logistics> logisticsByUserId;
    
    @OneToMany(mappedBy = "phoneUserByDeliveryToUserId")
	private Collection<Logistics> logisticsByUserId_0;
    
    @OneToMany(mappedBy = "phoneUserByUserId")
	private Collection<UserFeature> userFeaturesByUserId;

}
