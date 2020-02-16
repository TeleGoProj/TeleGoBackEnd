

package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.LandlinePhone;

@Repository
public interface LandlinePhoneRepository extends JpaRepository<LandlinePhone, Long> {
}