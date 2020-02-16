
package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telego.database.entity.Cabin;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long> {
}
