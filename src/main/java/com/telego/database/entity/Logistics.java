package com.telego.database.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Logistics {
	
    @Id
    @Column(name = "LOGISTICS_ID")
	@EqualsAndHashCode.Include
    private Long logisticsId;
	
    @Column(name = "DELIVERY_TO_STREET")
    private String deliveryToStreet;
    
    @Column(name = "REQUEST_DATE")
    private Time requestDate;
    
    @Column(name = "STATUS")
    private Long status;
    
    @Column(name = "DELIVERY_COMMENTS")
    private String deliveryComments;
    
    @Column(name = "GOODS_DESCRIPTION")
    private String goodsDescription;
    
    @ManyToOne
    @JoinColumn(name = "REQUESTER_USER_ID", referencedColumnName = "USER_ID")
    private PhoneUser phoneUserByRequesterUserId;
    
    @ManyToOne
    @JoinColumn(name = "DELIVERY_TO_USER_ID", referencedColumnName = "USER_ID")
    private PhoneUser phoneUserByDeliveryToUserId;
    
    @ManyToOne
    @JoinColumn(name = "DELIVERY_TO_AREA_ID", referencedColumnName = "AREA_ID")
    private Area areaByDeliveryToAreaId;

}
