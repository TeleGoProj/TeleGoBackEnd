package com.telego.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.telego.database.entity.Country;
import com.telego.database.entity.Area;
import com.telego.model.CountryDTO;
import com.telego.model.AreaDTO;

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
	
	public AreaDTO mapToAreaDTO(Area entity) {
		if (entity == null)
			return null;

		AreaDTO dto = new AreaDTO();
		dto.setAreaId(entity.getAreaId());
		dto.setNameEn(entity.getNameEn());
		dto.setNameAr(entity.getNameAr());
		dto.setCode(entity.getCode());

		return dto;
	}
	
	// TODO mapToAreaDTO;
	// TODO mapToBoxesDTO;
	// TODO mapToCabinsDTO;
	// TODO mapToCitiesDTO;
	// TODO mapToFeaturesDTO;
	// TODO mapToPhonesDTO;
	// TODO mapToLogisticsDTO;
	// TODO mapToPhoneUserDTO;
	
	public Country mapToCountryEntity(CountryDTO dto) {
		if (dto == null)
			return null;
		
		Country entity = new Country();
		entity.setCountryId(dto.getCountryId());
		entity.setNameEn(dto.getNameEn());
		entity.setNameAr(dto.getNameAr());
		entity.setCode(dto.getCode());
		
		return entity;
	}
	
	// TODO mapToAreaEntity;
	// TODO mapToBoxesEntity;
	// TODO mapToCabinsEntity;
	// TODO mapToCitiesEntity;
	// TODO mapToFeaturesEntity;
	// TODO mapToPhonesEntity;
	// TODO mapToLogisticsEntity;
	// TODO mapToPhoneUserEntity;

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
	
	public List<Country> mapToCountriesEntities(List<CountryDTO> countries) {
		if (countries == null)
			return null;
		
		List<Country> entities = countries.stream().map(new Function<CountryDTO, Country>() {
			@Override
			public Country apply(CountryDTO dto) {
				return mapToCountryEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	
	// TODO mapToAreaEntities;
	// TODO mapToBoxesEntities;
	// TODO mapToCabinsEntities;
	// TODO mapToCitiesEntities;
	// TODO mapToFeaturesEntities;
	// TODO mapToPhonesEntities;
	// TODO mapToLogisticsEntities;
	// TODO mapToPhoneUserEntities;

}
