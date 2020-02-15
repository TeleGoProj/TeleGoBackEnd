package com.telego.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.telego.database.entity.Country;
import com.telego.model.CountryDTO;

@Service
public class EntityMapper {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public CountryDTO mapToCountryDTO(Country entity) {
		logger.info("mapToCountryDTO - entry:", entity);
		
		if (entity == null)
			return null;

		CountryDTO dto = new CountryDTO();
		dto.setCountryId(entity.getCountryId());
		dto.setNameEn(entity.getNameEn());
		dto.setNameAr(entity.getNameAr());
		dto.setCode(entity.getCode());

		logger.info("mapToCountryDTO - return:", dto);
		return dto;
	}

	public List<CountryDTO> mapToCountriesDTOs(List<Country> countries) {
		logger.info("mapToCountriesDTOs - entry: {}", countries);
		
		if (countries == null)
			return null;

		List<CountryDTO> dtos = countries.stream().map(new Function<Country, CountryDTO>() {
			@Override
			public CountryDTO apply(Country entity) {
				return mapToCountryDTO(entity);
			}
		}).collect(Collectors.toList());

		logger.info("mapToCountriesDTOs - return: {}", dtos);
		return dtos;
	}

}
