package com.telego.database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_FEATURE", schema = "PHONE", catalog = "")
public class UserFeature {
    private Long userFeatureId;
    private PhoneUser phoneUserByUserId;
    private Feature featureByFeatureId;

    @Id
    @Column(name = "USER_FEATURE_ID")
    public Long getUserFeatureId() {
        return userFeatureId;
    }

    public void setUserFeatureId(Long userFeatureId) {
        this.userFeatureId = userFeatureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFeature that = (UserFeature) o;
        return Objects.equals(userFeatureId, that.userFeatureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFeatureId);
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    public PhoneUser getPhoneUserByUserId() {
        return phoneUserByUserId;
    }

    public void setPhoneUserByUserId(PhoneUser phoneUserByUserId) {
        this.phoneUserByUserId = phoneUserByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID")
    public Feature getFeatureByFeatureId() {
        return featureByFeatureId;
    }

    public void setFeatureByFeatureId(Feature featureByFeatureId) {
        this.featureByFeatureId = featureByFeatureId;
    }
}
