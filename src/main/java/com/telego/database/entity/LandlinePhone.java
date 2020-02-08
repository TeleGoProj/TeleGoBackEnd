package com.telego.database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LANDLINE_PHONE", schema = "PHONE", catalog = "")
public class LandlinePhone {
    private Long landlinePhoneId;
    private Long phoneNumber;
    private PhoneUser phoneUserByUserId;
    private Box boxByBoxId;

    @Id
    @Column(name = "LANDLINE_PHONE_ID")
    public Long getLandlinePhoneId() {
        return landlinePhoneId;
    }

    public void setLandlinePhoneId(Long landlinePhoneId) {
        this.landlinePhoneId = landlinePhoneId;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LandlinePhone that = (LandlinePhone) o;
        return Objects.equals(landlinePhoneId, that.landlinePhoneId) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(landlinePhoneId, phoneNumber);
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
    @JoinColumn(name = "BOX_ID", referencedColumnName = "BOX_ID")
    public Box getBoxByBoxId() {
        return boxByBoxId;
    }

    public void setBoxByBoxId(Box boxByBoxId) {
        this.boxByBoxId = boxByBoxId;
    }
}
