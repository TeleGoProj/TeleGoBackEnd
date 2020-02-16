

package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}