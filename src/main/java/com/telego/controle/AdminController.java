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
	
	@PutMapping("/edit-lookups")
	public AdminLookupsResponse saveAdminLookups(@RequestBody AdminLookupsRequest request) {
		return adminService.updateAdminLookupsResponse(request);
	}

}
