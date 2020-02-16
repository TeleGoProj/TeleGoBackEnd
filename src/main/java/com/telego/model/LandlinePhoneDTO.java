package com.telego.model;

import java.util.List;
import java.util.Collection;

import com.telego.database.entity.Box;

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
	private PhoneUser phoneUserByUserId;
	
	private List<BoxDTO>boxByBoxId;
	
	
}
