package com.telego.model;

import java.sql.Time;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class LogisticsDTO {
	private Long logisticsId;
	private String deliveryToStreet;
	private Time requestDate;
	private Long status;
	private String deliveryComments;
	private String goodsDescription;
	
	private List<PhoneUserDTO>requestedPhoneUsers;
	private List<PhoneUserDTO>deliveredPhoneUsers;
	private List<AreaDTO>areas;	
	
}
