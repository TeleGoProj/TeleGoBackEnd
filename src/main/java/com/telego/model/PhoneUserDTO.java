package com.telego.model;

import java.sql.Time;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneUserDTO extends ModelDTO{
	private Long userId;
	private String loginName;
	private String loginPassword;
	private Time creationDate;
	private String fName;
	private String mName;
	private String lName;
	private Long organizationType;
	private String email;
	private byte[] image;
	private String address;
	private String mobilePhone;
	private String organizationName;
	private Long userStatus;
	private Long userType;
	
	private LandlinePhoneDTO landLinePhone;
	private List<LogisticsDTO> requestedlogistics;
	private List<LogisticsDTO> deliveredLogistics;
}
