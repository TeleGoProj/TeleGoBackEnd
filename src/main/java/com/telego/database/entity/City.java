package com.telego.database.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class City {
    private Long cityId;
    private String nameEn;
    private String nameAr;
    private String code;
    private Collection<Area> areasByCityId;
    private Collection<Cabin> cabinsByCityId;
    private Country countryByCountryId;

    @Id
    @Column(name = "CITY_ID")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "NAME_EN")
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Basic
    @Column(name = "NAME_AR")
    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityId, city.cityId) &&
                Objects.equals(nameEn, city.nameEn) &&
                Objects.equals(nameAr, city.nameAr) &&
                Objects.equals(code, city.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, nameEn, nameAr, code);
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Area> getAreasByCityId() {
        return areasByCityId;
    }

    public void setAreasByCityId(Collection<Area> areasByCityId) {
        this.areasByCityId = areasByCityId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Cabin> getCabinsByCityId() {
        return cabinsByCityId;
    }

    public void setCabinsByCityId(Collection<Cabin> cabinsByCityId) {
        this.cabinsByCityId = cabinsByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
