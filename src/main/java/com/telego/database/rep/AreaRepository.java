
package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}