package com.telego.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telego.model.CountryDTO;
import com.telego.service.LookupService;

@RestController
@RequestMapping("/api/basics")
public class BasicOperationsController {

	@Autowired
	private LookupService lookupService;

	@GetMapping()
	public List<CountryDTO> getAllCountries() {
		return lookupService.getAllCountries();
	}

}
