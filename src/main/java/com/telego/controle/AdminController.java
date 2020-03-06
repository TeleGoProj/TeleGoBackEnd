package com.telego.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telego.model.request.AdminLookupsRequest;
import com.telego.model.response.AdminLookupsResponse;
import com.telego.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/view-lookups")
	public AdminLookupsResponse getAdminLookups() {
		return adminService.getAdminLookupsResponse();
	}

	@PutMapping("/process-countries")
	public AdminLookupsResponse processCountries(@RequestBody AdminLookupsRequest request) {
		return adminService.processCountries(request);
	}

	@PutMapping("/process-cities")
	public AdminLookupsResponse processCities(@RequestBody AdminLookupsRequest request) {
		return adminService.processCities(request);
	}

	@PutMapping("/process-areas")
	public AdminLookupsResponse processAreas(@RequestBody AdminLookupsRequest request) {
		return adminService.processAreas(request);
	}

	@PutMapping("/process-boxes")
	public AdminLookupsResponse processBoxes(@RequestBody AdminLookupsRequest request) {
		return adminService.processBoxes(request);
	}

	@PutMapping("/process-cabins")
	public AdminLookupsResponse processCabins(@RequestBody AdminLookupsRequest request) {
		return adminService.processCabins(request);
	}

	@PutMapping("/process-features")
	public AdminLookupsResponse processFeatures(@RequestBody AdminLookupsRequest request) {
		return adminService.processFeatures(request);
	}

	@PutMapping("/process-landline-phones")
	public AdminLookupsResponse processLandlinePhones(@RequestBody AdminLookupsRequest request) {
		return adminService.processLandlinePhones(request);
	}

}
