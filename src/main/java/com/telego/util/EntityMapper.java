package com.telego.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.telego.database.entity.Country;
import com.telego.model.CountryDTO;

@Service
public class EntityMapper {
	
	public CountryDTO mapToCountryDTO(Country entity) {
		if (entity == null)
			return null;

		CountryDTO dto = new CountryDTO();
		dto.setCountryId(entity.getCountryId());
		dto.setNameEn(entity.getNameEn());
		dto.setNameAr(entity.getNameAr());
		dto.setCode(entity.getCode());

		return dto;
	}

	public List<CountryDTO> mapToCountriesDTOs(List<Country> countries) {
		if (countries == null)
			return null;

		List<CountryDTO> dtos = countries.stream().map(new Function<Country, CountryDTO>() {
			@Override
			public CountryDTO apply(Country entity) {
				return mapToCountryDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}

}
