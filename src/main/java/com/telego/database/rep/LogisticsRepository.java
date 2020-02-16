

package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.Logistics;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
}