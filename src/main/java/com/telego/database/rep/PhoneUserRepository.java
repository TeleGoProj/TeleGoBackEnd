
package com.telego.database.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telego.database.entity.PhoneUser;

@Repository
public interface PhoneUserRepository extends JpaRepository<PhoneUser, Long> {
    
//	@Query("select u from PhoneUser vc join vc.violationFactors vf join vf.incidentAssessmentFactor iaf join iaf.incidentAssessment ia where ia.incidentAssessmentId = ?1 group by vc ")
//	public List<PhoneUser> findByPhoneNumberOrFeatureName(Long phoneNumber,
//			String featureName);
	
	public List<PhoneUser> findByLandlinePhones_PhoneNumberAndUserFeatures_FeatureByFeatureId_Name(Long phoneNumber,
			String featureName);
	
	public List<PhoneUser> findByLandlinePhones_PhoneNumber(Long phoneNumber);
	
	public List<PhoneUser> findByUserFeatures_FeatureByFeatureId_Name(String featureName);
}