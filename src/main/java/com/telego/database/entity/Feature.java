package com.telego.database.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Feature {
    private Long featureId;
    private String name;
    private String value;
    private String type;
    private String category;
    private Long parentId;
    private Feature featureByFeatureId;
    private Feature featureByFeatureId_0;
    private Collection<UserFeature> userFeaturesByFeatureId;

    @Id
    @Column(name = "FEATURE_ID")
    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CATEGORY")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "PARENT_ID")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(featureId, feature.featureId) &&
                Objects.equals(name, feature.name) &&
                Objects.equals(value, feature.value) &&
                Objects.equals(type, feature.type) &&
                Objects.equals(category, feature.category) &&
                Objects.equals(parentId, feature.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId, name, value, type, category, parentId);
    }

    @OneToOne
    @JoinColumn(name = "FEATURE_ID", referencedColumnName = "FEATURE_ID", nullable = false)
    public Feature getFeatureByFeatureId() {
        return featureByFeatureId;
    }

    public void setFeatureByFeatureId(Feature featureByFeatureId) {
        this.featureByFeatureId = featureByFeatureId;
    }

    @OneToOne(mappedBy = "featureByFeatureId")
    public Feature getFeatureByFeatureId_0() {
        return featureByFeatureId_0;
    }

    public void setFeatureByFeatureId_0(Feature featureByFeatureId_0) {
        this.featureByFeatureId_0 = featureByFeatureId_0;
    }

    @OneToMany(mappedBy = "featureByFeatureId")
    public Collection<UserFeature> getUserFeaturesByFeatureId() {
        return userFeaturesByFeatureId;
    }

    public void setUserFeaturesByFeatureId(Collection<UserFeature> userFeaturesByFeatureId) {
        this.userFeaturesByFeatureId = userFeaturesByFeatureId;
    }
}
