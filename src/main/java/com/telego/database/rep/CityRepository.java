

package com.telego.database.rep;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import com.telego.database.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query("SELECT c FROM City c WHERE c.country.countryId =:countryId")
	public List<City> getCitiesByCountryId(Long countryId);

	public City findByphoneCode(String phoneCode);
	
}

    
   
