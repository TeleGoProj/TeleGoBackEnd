package com.telego.model.response;

import java.util.List;

import com.telego.model.FeatureDTO;
import com.telego.model.PhoneUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ProfileResponse extends Response {

	private PhoneUserDTO user;
}
