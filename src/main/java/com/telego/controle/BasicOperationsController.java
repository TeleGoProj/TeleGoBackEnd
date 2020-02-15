package com.telego.controle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telego.model.CountryDTO;
import com.telego.service.LookupService;

@RestController
@RequestMapping("/api/basics")
public class BasicOperationsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LookupService lookupService;

	@GetMapping()
	public List<CountryDTO> getAllCountries() {
		logger.info("getAllCountries");
		return lookupService.getAllCountries();
	}

}
