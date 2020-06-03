package com.telego.model;

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
	private BoxDTO box;
}
