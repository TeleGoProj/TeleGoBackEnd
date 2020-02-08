package com.telego.database.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Box {
    private Long boxId;
    private String boxName;
    private Float longitude;
    private Float latitude;
    private String streetName;
    private Area areaByAreaId;
    private Cabin cabinByCabinId;
    private Collection<LandlinePhone> landlinePhonesByBoxId;

    @Id
    @Column(name = "BOX_ID")
    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    @Basic
    @Column(name = "BOX_NAME")
    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    @Basic
    @Column(name = "LONGITUDE")
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "LATITUDE")
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "STREET_NAME")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(boxId, box.boxId) &&
                Objects.equals(boxName, box.boxName) &&
                Objects.equals(longitude, box.longitude) &&
                Objects.equals(latitude, box.latitude) &&
                Objects.equals(streetName, box.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxId, boxName, longitude, latitude, streetName);
    }

    @ManyToOne
    @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID")
    public Area getAreaByAreaId() {
        return areaByAreaId;
    }

    public void setAreaByAreaId(Area areaByAreaId) {
        this.areaByAreaId = areaByAreaId;
    }

    @ManyToOne
    @JoinColumn(name = "CABIN_ID", referencedColumnName = "CABIN_ID")
    public Cabin getCabinByCabinId() {
        return cabinByCabinId;
    }

    public void setCabinByCabinId(Cabin cabinByCabinId) {
        this.cabinByCabinId = cabinByCabinId;
    }

    @OneToMany(mappedBy = "boxByBoxId")
    public Collection<LandlinePhone> getLandlinePhonesByBoxId() {
        return landlinePhonesByBoxId;
    }

    public void setLandlinePhonesByBoxId(Collection<LandlinePhone> landlinePhonesByBoxId) {
        this.landlinePhonesByBoxId = landlinePhonesByBoxId;
    }
}
