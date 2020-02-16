

package com.telego.database.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.telego.database.entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}