package com.telego.model;

import java.util.List;

import com.telego.model.PhoneUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class LandlinePhoneDTO {
	private Long landlinePhoneId;
	private Long phoneNumber;
	private PhoneUserDTO phoneUsers;
	
	private List<BoxDTO>boxes;
	
	
}
