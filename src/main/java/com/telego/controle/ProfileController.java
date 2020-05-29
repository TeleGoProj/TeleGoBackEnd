package com.telego.controle;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.telego.database.entity.PhoneUser;
import com.telego.model.PhoneUserDTO;
import com.telego.model.request.ProfileRequest;
import com.telego.model.response.ProfileResponse;
import com.telego.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/get-profile/{id}")
	public ProfileResponse getCitiesByCountryId(@PathVariable("id") Long id) {
		return profileService.getPhoneUser(id);	
	}
	
	@PostMapping("/process-profile")
	public ProfileResponse processCountries(@RequestBody ProfileRequest request, String name) {
		return profileService.saveOrUpdatePhoneUser(request);
	}
	
	@PostMapping("/upload-image/{id}")
	public ProfileResponse processCountries(@PathVariable("id") Long id, @RequestParam("imageFile") MultipartFile uploadedImage) {
		return profileService.uploadImage(id, uploadedImage);
	}
}
