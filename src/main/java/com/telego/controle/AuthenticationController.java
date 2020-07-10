package com.telego.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telego.service.ProfileService;


@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private ProfileService profileService;

	
	
	@GetMapping("/login/{username}/{password}")
		public Long authenticate(String username , String password) {
			return profileService.authenticate(username, password);
		}
	}

