
package com.telego.database.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.Area;
import com.telego.database.entity.City;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
	
	@Query("SELECT c FROM Area c WHERE c.city.cityId =:cityId")
	public List<Area> getAreasByCityId(Long cityId);
	
	
}


