package com.telego.database.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telego.database.entity.PhoneUser;
import com.telego.database.entity.UserFeature;

@Repository
public interface UserFeatureRepository extends JpaRepository<UserFeature, Long>{

	Long deleteByPhoneUserByUser(PhoneUser phoneUserByUser);
}
