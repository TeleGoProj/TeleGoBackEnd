package com.telego.database.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Area {
    private Long areaId;
    private String areaNameEn;
    private String areaNameAr;
    private City cityByCityId;
    private Collection<Box> boxesByAreaId;
    private Collection<Logistics> logisticsByAreaId;

    @Id
    @Column(name = "AREA_ID")
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "AREA_NAME_EN")
    public String getAreaNameEn() {
        return areaNameEn;
    }

    public void setAreaNameEn(String areaNameEn) {
        this.areaNameEn = areaNameEn;
    }

    @Basic
    @Column(name = "AREA_NAME_AR")
    public String getAreaNameAr() {
        return areaNameAr;
    }

    public void setAreaNameAr(String areaNameAr) {
        this.areaNameAr = areaNameAr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(areaId, area.areaId) &&
                Objects.equals(areaNameEn, area.areaNameEn) &&
                Objects.equals(areaNameAr, area.areaNameAr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, areaNameEn, areaNameAr);
    }

    @ManyToOne
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @OneToMany(mappedBy = "areaByAreaId")
    public Collection<Box> getBoxesByAreaId() {
        return boxesByAreaId;
    }

    public void setBoxesByAreaId(Collection<Box> boxesByAreaId) {
        this.boxesByAreaId = boxesByAreaId;
    }

    @OneToMany(mappedBy = "areaByDeliveryToAreaId")
    public Collection<Logistics> getLogisticsByAreaId() {
        return logisticsByAreaId;
    }

    public void setLogisticsByAreaId(Collection<Logistics> logisticsByAreaId) {
        this.logisticsByAreaId = logisticsByAreaId;
    }
}
