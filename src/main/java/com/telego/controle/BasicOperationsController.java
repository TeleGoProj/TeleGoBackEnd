package com.telego.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telego.database.entity.Country;
import com.telego.database.rep.CountryRepository;

@RestController
@RequestMapping("/api/basics")
public class BasicOperationsController {

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping()
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

}
