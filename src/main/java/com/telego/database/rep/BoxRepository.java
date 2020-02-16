
package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telego.database.entity.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
}

