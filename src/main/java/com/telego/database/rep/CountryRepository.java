package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telego.database.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
