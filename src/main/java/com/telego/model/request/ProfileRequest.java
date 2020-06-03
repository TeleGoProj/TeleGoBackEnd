package com.telego.model.request;

import com.telego.model.CountryDTO;
import com.telego.model.PhoneUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ProfileRequest extends Request{
	private PhoneUserDTO user;
	private CountryDTO phoneCountry;
	private String cityPhoneCode;
}
