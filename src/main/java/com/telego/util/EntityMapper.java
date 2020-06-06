package com.telego.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.telego.database.entity.Area;
import com.telego.database.entity.Box;
import com.telego.database.entity.Cabin;
import com.telego.database.entity.City;
import com.telego.database.entity.Country;
import com.telego.database.entity.Feature;
import com.telego.database.entity.LandlinePhone;
import com.telego.database.entity.Logistics;
import com.telego.database.entity.PhoneUser;
import com.telego.database.entity.UserFeature;
import com.telego.model.AreaDTO;
import com.telego.model.BoxDTO;
import com.telego.model.CabinDTO;
import com.telego.model.CityDTO;
import com.telego.model.CountryDTO;
import com.telego.model.FeatureDTO;
import com.telego.model.LandlinePhoneDTO;
import com.telego.model.LogisticsDTO;
import com.telego.model.PhoneUserDTO;

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
		dto.setPhoneCode(entity.getPhoneCode());
		dto.setUiStyle(entity.getUiStyle());

		return dto;
	}
	
	public AreaDTO mapToAreaDTO(Area entity) {
		if (entity == null)
			return null;

		AreaDTO dto = new AreaDTO();
		dto.setAreaId(entity.getAreaId());
		dto.setAreaNameEn(entity.getAreaNameEn());
		dto.setAreaNameAr(entity.getAreaNameAr());
		
		City city = entity.getCity();
		CityDTO cityDto = mapToCityDTO(city);
		
		dto.setCity(cityDto);

		return dto;
	}
	
	public BoxDTO mapToBoxDTO(Box entity) {
		if (entity == null)
			return null;

		BoxDTO dto = new BoxDTO();
		dto.setBoxId(entity.getBoxId());
		dto.setBoxName(entity.getBoxName());
		dto.setLongitude(entity.getLongitude());
		dto.setLatitude(entity.getLatitude());
		dto.setStreetName(entity.getStreetName());
		
		Cabin cabin = entity.getCabin();
		CabinDTO cabinDto = mapToCabinDTO(cabin);
		
		dto.setCabin(cabinDto);

		return dto;
	}
	
	public CabinDTO mapToCabinDTO(Cabin entity) {
		if (entity == null)
			return null;

		CabinDTO dto = new CabinDTO();
		dto.setCabinId(entity.getCabinId());
		dto.setCabinName(entity.getCabinName());
		
		Area area = entity.getArea();
		AreaDTO areaDto = mapToAreaDTO(area);
		
		dto.setArea(areaDto);
		
		return dto;
	}
	
	public CityDTO mapToCityDTO(City entity) {
		if (entity == null)
			return null;

		CityDTO dto = new CityDTO();
		dto.setCityId(entity.getCityId());
		dto.setNameEn(entity.getNameEn());
		dto.setNameAr(entity.getNameAr());
		dto.setCode(entity.getCode());
		dto.setPhoneCode(entity.getPhoneCode());
		
		Country country = entity.getCountry();
		CountryDTO countryDto = mapToCountryDTO(country);
		
		dto.setCountry(countryDto);

		return dto;
	}
	
	public FeatureDTO mapToFeatureDTO(Feature entity) {
		if (entity == null)
			return null;

		FeatureDTO dto = new FeatureDTO();
		dto.setFeatureId(entity.getFeatureId());
		dto.setName(entity.getName());
		dto.setValue(entity.getValue());
		dto.setType(entity.getType());
		dto.setUiStyle(entity.getUiStyle());
		dto.setFeatureId(entity.getFeatureId());
		
		return dto;
	}
	
	public LandlinePhoneDTO mapToLandlinePhoneDTO(LandlinePhone entity) {
		if (entity == null)
			return null;

		LandlinePhoneDTO dto = new LandlinePhoneDTO();
		dto.setLandlinePhoneId(entity.getLandlinePhoneId());
		dto.setPhoneNumber(entity.getPhoneNumber());

		BoxDTO boxDTO = mapToBoxDTO(entity.getBox());
		dto.setBox(boxDTO);

		return dto;
	}
	
	public LogisticsDTO mapToLogisticsDTO(Logistics entity) {
		if (entity == null)
			return null;

		LogisticsDTO dto = new LogisticsDTO();
		dto.setLogisticsId(entity.getLogisticsId());
		dto.setDeliveryToStreet(entity.getDeliveryToStreet());
		dto.setRequestDate(entity.getRequestDate());
		dto.setDeliveryComments(entity.getDeliveryComments());
		dto.setGoodsDescription(entity.getGoodsDescription());
		dto.setStatus(entity.getStatus());
		
		return dto;
	}
	
	public PhoneUserDTO mapToPhoneUserDTO(PhoneUser entity) {
		if (entity == null)
			return null;

		PhoneUserDTO dto = new PhoneUserDTO();
		dto.setUserId(entity.getUserId());
		dto.setLoginName(entity.getLoginName());
		dto.setLoginPassword(entity.getLoginPassword());
		dto.setCreationDate(entity.getCreationDate());
		dto.setFirstName(entity.getfName());
		dto.setMiddleName(entity.getmName());
		dto.setLastName(entity.getlName());
		dto.setOrganizationType(entity.getOrganizationType());
		dto.setEmail(entity.getEmail());
		dto.setImage(entity.getImage());
		dto.setAddress(entity.getAddress());
		dto.setMobilePhone(entity.getMobilePhone());
		dto.setOrganizationName(entity.getOrganizationName());
		dto.setUserStatus(entity.getUserStatus());
		dto.setUserType(entity.getUserType());
		dto.setAboutMe(entity.getAboutMe());
		
		LandlinePhoneDTO landLinePhoneDTO = null;
		
		if(entity.getLandlinePhones() != null && !entity.getLandlinePhones().isEmpty())
			landLinePhoneDTO = mapToLandlinePhoneDTO(entity.getLandlinePhones().get(0));
		dto.setLandLinePhone(landLinePhoneDTO);
		
		List<FeatureDTO> userFeatures = getUserFeatures(entity.getUserFeatures());
		dto.setFeatures(userFeatures);

		return dto;
	}
	
	private List<FeatureDTO> getUserFeatures(List<UserFeature> userFeatures){
		List<FeatureDTO> featuresDTOs = new ArrayList<FeatureDTO>();
		if(userFeatures!= null) {
			for(UserFeature userFeatur : userFeatures) {
				Feature feature = userFeatur.getFeatureByFeatureId();
				FeatureDTO featureDTO = mapToFeatureDTO(feature);
				featuresDTOs.add(featureDTO);
			}
		}
		return featuresDTOs;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	public Country mapToCountryEntity(CountryDTO dto) {
		if (dto == null)
			return null;
		
		Country entity = new Country();
		entity.setCountryId(dto.getCountryId());
		entity.setNameEn(dto.getNameEn());
		entity.setNameAr(dto.getNameAr());
		entity.setCode(dto.getCode());
		entity.setPhoneCode(dto.getPhoneCode());
		entity.setUiStyle(dto.getUiStyle());
		
		return entity;
	}
	
	public Area mapToAreaEntity(AreaDTO dto) {
		if (dto == null)
			return null;
		
		Area entity = new Area();
		entity.setAreaId(dto.getAreaId());
		entity.setAreaNameAr(dto.getAreaNameAr());
		entity.setAreaNameEn(dto.getAreaNameEn());
		
		return entity;
	}
	
	public Box mapToBoxEntity(BoxDTO dto) {
		if (dto == null)
			return null;

		Box entity = new Box();
		entity.setBoxId(dto.getBoxId());
		entity.setBoxName(dto.getBoxName());
		entity.setLongitude(dto.getLongitude());
		entity.setLatitude(dto.getLatitude());
		entity.setStreetName(dto.getStreetName());

		return entity;
	}
	
	public Cabin mapToCabinEntity(CabinDTO dto) {
		if (dto == null)
			return null;

		Cabin entity = new Cabin();
		entity.setCabinId(dto.getCabinId());
		entity.setCabinName(dto.getCabinName());
		return entity;
	}
	
	public City mapToCityEntity(CityDTO dto) {
		if (dto == null)
			return null;

		City entity = new City();
		entity.setCityId(dto.getCityId());
		entity.setNameEn(dto.getNameEn());
		entity.setNameAr(dto.getNameAr());
		
		entity.setCountry(mapToCountryEntity(dto.getCountry()));
		return entity;
	}
	
	public Feature mapToFeatureEntity(FeatureDTO dto) {
		if (dto == null)
			return null;

		Feature entity = new Feature();
		entity.setFeatureId(dto.getFeatureId());
		entity.setName(dto.getName());
		entity.setValue(dto.getValue());
		entity.setType(dto.getType());
		entity.setFeatureId(dto.getFeatureId());
		
		return entity;
	}
	
	public LandlinePhone mapToLandlinePhoneEntity(LandlinePhoneDTO dto) {
		if (dto == null)
			return null;

		LandlinePhone entity = new LandlinePhone();
		entity.setLandlinePhoneId(dto.getLandlinePhoneId());
		entity.setPhoneNumber(dto.getPhoneNumber());
		
		BoxDTO boxDTO = dto.getBox();
		Box boxEntity = mapToBoxEntity(boxDTO);
		
		entity.setBox(boxEntity);

		return entity;
	}
	
	public Logistics mapToLogisticsEntity(LogisticsDTO dto) {
		if (dto == null)
			return null;

		Logistics entity = new Logistics();
		entity.setLogisticsId(dto.getLogisticsId());
		entity.setDeliveryToStreet(dto.getDeliveryToStreet());
		entity.setRequestDate(dto.getRequestDate());
		entity.setDeliveryComments(dto.getDeliveryComments());
		entity.setGoodsDescription(dto.getGoodsDescription());
		entity.setStatus(dto.getStatus());
		
		return entity;
	}
	
	public PhoneUser mapToPhoneUserEntity(PhoneUserDTO dto) {
		if (dto == null)
			return null;

		PhoneUser entity = new PhoneUser();
		entity.setUserId(dto.getUserId());
		entity.setLoginName(dto.getLoginName());
		entity.setLoginPassword(dto.getLoginPassword());
		entity.setCreationDate(dto.getCreationDate());
		entity.setfName(dto.getFirstName());
		entity.setmName(dto.getMiddleName());
		entity.setlName(dto.getLastName());
		entity.setOrganizationType(dto.getOrganizationType());
		entity.setEmail(dto.getEmail());
		entity.setImage(dto.getImage());
		entity.setAddress(dto.getAddress());
		entity.setMobilePhone(dto.getMobilePhone());
		entity.setOrganizationName(dto.getOrganizationName());
		entity.setUserStatus(dto.getUserStatus());
		entity.setUserType(dto.getUserType());
		entity.setAboutMe(dto.getAboutMe());
		
		LandlinePhoneDTO phoneDTO = dto.getLandLinePhone();
		LandlinePhone phoneEntity = mapToLandlinePhoneEntity(phoneDTO);
		phoneEntity.setPhoneUser(entity);
		
		if(phoneEntity != null)
			entity.setLandlinePhone(Arrays.asList(phoneEntity));
		
		List<UserFeature> userFeaturesEntities = null;
		List<FeatureDTO> userFeaturesDTOs = dto.getFeatures();
		
		if(userFeaturesDTOs != null) {
			userFeaturesEntities = new ArrayList<UserFeature>();
			
			for(FeatureDTO featureDTO : userFeaturesDTOs) {
				Feature featureEntity = mapToFeatureEntity(featureDTO);
				UserFeature userFeature = new UserFeature();
				userFeature.setFeatureByFeatureId(featureEntity);
				userFeature.setPhoneUserByUser(entity);
				
				userFeaturesEntities.add(userFeature);
			}
		}

		entity.setUserFeatures(userFeaturesEntities);
		
		return entity;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
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
	
	public List<AreaDTO> mapToAreasDTOs(List<Area> areas){
		if (areas == null)
			return null;
		
		List<AreaDTO> dtos = areas.stream().map(new Function<Area, AreaDTO>() {
			@Override
			public AreaDTO apply(Area entity) {
				return mapToAreaDTO(entity);
			}
		}).collect(Collectors.toList());
		
		return dtos;
	}
	
	public List<BoxDTO> mapToBoxesDTOs(List<Box> boxes) {
		if (boxes == null)
			return null;

		List<BoxDTO> dtos = boxes.stream().map(new Function<Box, BoxDTO>() {
			@Override
			public BoxDTO apply(Box entity) {
				return mapToBoxDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}
	
	public List<CabinDTO> mapToCabinsDTOs(List<Cabin> cabins) {
		if (cabins == null)
			return null;

		List<CabinDTO> dtos = cabins.stream().map(new Function<Cabin, CabinDTO>() {
			@Override
			public CabinDTO apply(Cabin entity) {
				return mapToCabinDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}
	
	public List<CityDTO> mapToCitiesDTOs(List<City> cities) {
		if (cities == null)
			return null;

		List<CityDTO> dtos = cities.stream().map(new Function<City, CityDTO>() {
			@Override
			public CityDTO apply(City entity) {
				return mapToCityDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}
	
	public List<FeatureDTO> mapToFeaturesDTOs(List<Feature> features) {
		if (features == null)
			return null;

		List<FeatureDTO> dtos = features.stream().map(new Function<Feature, FeatureDTO>() {
			@Override
			public FeatureDTO apply(Feature entity) {
				return mapToFeatureDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}
	
	public List<LandlinePhoneDTO> mapToLandlinePhonesDTOs(List<LandlinePhone> landlinePhones) {
		if (landlinePhones == null)
			return null;

		List<LandlinePhoneDTO> dtos = landlinePhones.stream().map(new Function<LandlinePhone, LandlinePhoneDTO>() {
			@Override
			public LandlinePhoneDTO apply(LandlinePhone entity) {
				return mapToLandlinePhoneDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}
	
	public List<LogisticsDTO> mapToLogisticsDTOs(List<Logistics> logistics) {
		if (logistics == null)
			return null;

		List<LogisticsDTO> dtos = logistics.stream().map(new Function<Logistics, LogisticsDTO>() {
			@Override
			public LogisticsDTO apply(Logistics entity) {
				return mapToLogisticsDTO(entity);
			}
		}).collect(Collectors.toList());

		return dtos;
	}
	
	public List<PhoneUserDTO> mapToPhoneUsersDTOs(List<PhoneUser> phoneUsers) {
		if (phoneUsers == null)
			return null;

		List<PhoneUserDTO> dtos = phoneUsers.stream().map(new Function<PhoneUser, PhoneUserDTO>() {
			@Override
			public PhoneUserDTO apply(PhoneUser entity) {
				return mapToPhoneUserDTO(entity);
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
	
	public List<Area> mapToAreasEntities(List<AreaDTO> areas) {
		if (areas == null)
			return null;
		
		List<Area> entities = areas.stream().map(new Function<AreaDTO, Area>() {
			@Override
			public Area apply(AreaDTO dto) {
				return mapToAreaEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<Box> mapToBoxesEntities(List<BoxDTO> boxes) {
		if (boxes == null)
			return null;
		
		List<Box> entities = boxes.stream().map(new Function<BoxDTO, Box>() {
			@Override
			public Box apply(BoxDTO dto) {
				return mapToBoxEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<Cabin> mapToCabinsEntities(List<CabinDTO> cabins) {
		if (cabins == null)
			return null;
		
		List<Cabin> entities = cabins.stream().map(new Function<CabinDTO, Cabin>() {
			@Override
			public Cabin apply(CabinDTO dto) {
				return mapToCabinEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<City> mapToCitiesEntities(List<CityDTO> cities) {
		if (cities == null)
			return null;
		
		List<City> entities = cities.stream().map(new Function<CityDTO, City>() {
			@Override
			public City apply(CityDTO dto) {
				return mapToCityEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<Feature> mapToFeaturesEntities(List<FeatureDTO> features) {
		if (features == null)
			return null;
		
		List<Feature> entities = features.stream().map(new Function<FeatureDTO, Feature>() {
			@Override
			public Feature apply(FeatureDTO dto) {
				return mapToFeatureEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<LandlinePhone> mapToLandlinePhonesEntities(List<LandlinePhoneDTO> landlinePhones) {
		if (landlinePhones == null)
			return null;
		
		List<LandlinePhone> entities = landlinePhones.stream().map(new Function<LandlinePhoneDTO, LandlinePhone>() {
			@Override
			public LandlinePhone apply(LandlinePhoneDTO dto) {
				return mapToLandlinePhoneEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<Logistics> mapToLogisticsEntities(List<LogisticsDTO> logistics) {
		if (logistics == null)
			return null;
		
		List<Logistics> entities = logistics.stream().map(new Function<LogisticsDTO, Logistics>() {
			@Override
			public Logistics apply(LogisticsDTO dto) {
				return mapToLogisticsEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

	public List<PhoneUser> mapToPhoneUserEntities(List<PhoneUserDTO> phoneUser) {
		if (phoneUser == null)
			return null;
		
		List<PhoneUser> entities = phoneUser.stream().map(new Function<PhoneUserDTO, PhoneUser>() {
			@Override
			public PhoneUser apply(PhoneUserDTO dto) {
				return mapToPhoneUserEntity(dto);
			}
		}).collect(Collectors.toList());
		
		return entities;
	}
	

}
