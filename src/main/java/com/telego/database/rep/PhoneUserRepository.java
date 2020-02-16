

package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.PhoneUser;

@Repository
public interface PhoneUserRepository extends JpaRepository<PhoneUser, Long> {
}