package com.telego.database.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cabin {
    private Long cabinId;
    private String cabinName;
    private Collection<Box> boxesByCabinId;
    private City cityByCityId;

    @Id
    @Column(name = "CABIN_ID")
    public Long getCabinId() {
        return cabinId;
    }

    public void setCabinId(Long cabinId) {
        this.cabinId = cabinId;
    }

    @Basic
    @Column(name = "CABIN_NAME")
    public String getCabinName() {
        return cabinName;
    }

    public void setCabinName(String cabinName) {
        this.cabinName = cabinName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cabin cabin = (Cabin) o;
        return Objects.equals(cabinId, cabin.cabinId) &&
                Objects.equals(cabinName, cabin.cabinName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cabinId, cabinName);
    }

    @OneToMany(mappedBy = "cabinByCabinId")
    public Collection<Box> getBoxesByCabinId() {
        return boxesByCabinId;
    }

    public void setBoxesByCabinId(Collection<Box> boxesByCabinId) {
        this.boxesByCabinId = boxesByCabinId;
    }

    @ManyToOne
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
