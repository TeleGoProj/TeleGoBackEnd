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
public class PhoneUserDTO {
	private Long userId;
	private String loginName;
	private String loginPassword;
	private Time creationDate;
	private String fName;
	private String mName;
	private String lName;
	private Long organizationType;
	private String email;
	private String imagePath;
	private String address;
	private String mobilePhone;
	private String organizationName;
	private Long userStatus;
	private Long userType;
	
	private List<LandlinePhoneDTO> landLinePhones;
	private List<LogisticsDTO> requestedlogistics;
	private List<LogisticsDTO> deliveredLogistics;
}
