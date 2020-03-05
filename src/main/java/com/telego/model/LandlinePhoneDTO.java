package com.telego.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LandlinePhoneDTO extends ModelDTO{
	private Long landlinePhoneId;
	private Long phoneNumber;
	private PhoneUserDTO phoneUser;
	private boolean markedAsDeleted;
	
	private List<BoxDTO>boxes;
	
	
}
