package com.telego.database.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PHONE_USER", schema = "PHONE", catalog = "")
public class PhoneUser {
    private Long userId;
    private String loginName;
    private String loginPassword;
    private Time creationDate;
    private String fName;
    private String mName;
    private String lName;
    private Long organizationType;
    private String email;
    private String imagePath;
    private String address;
    private String mobilePhone;
    private String organizationName;
    private Long userStatus;
    private Long userType;
    private Collection<LandlinePhone> landlinePhonesByUserId;
    private Collection<Logistics> logisticsByUserId;
    private Collection<Logistics> logisticsByUserId_0;
    private Collection<UserFeature> userFeaturesByUserId;

    @Id
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "LOGIN_NAME")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "LOGIN_PASSWORD")
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Basic
    @Column(name = "CREATION_DATE")
    public Time getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Time creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "F_NAME")
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "M_NAME")
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Basic
    @Column(name = "L_NAME")
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "ORGANIZATION_TYPE")
    public Long getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Long organizationType) {
        this.organizationType = organizationType;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "IMAGE_PATH")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "MOBILE_PHONE")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "ORGANIZATION_NAME")
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Basic
    @Column(name = "USER_STATUS")
    public Long getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Long userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "USER_TYPE")
    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneUser phoneUser = (PhoneUser) o;
        return Objects.equals(userId, phoneUser.userId) &&
                Objects.equals(loginName, phoneUser.loginName) &&
                Objects.equals(loginPassword, phoneUser.loginPassword) &&
                Objects.equals(creationDate, phoneUser.creationDate) &&
                Objects.equals(fName, phoneUser.fName) &&
                Objects.equals(mName, phoneUser.mName) &&
                Objects.equals(lName, phoneUser.lName) &&
                Objects.equals(organizationType, phoneUser.organizationType) &&
                Objects.equals(email, phoneUser.email) &&
                Objects.equals(imagePath, phoneUser.imagePath) &&
                Objects.equals(address, phoneUser.address) &&
                Objects.equals(mobilePhone, phoneUser.mobilePhone) &&
                Objects.equals(organizationName, phoneUser.organizationName) &&
                Objects.equals(userStatus, phoneUser.userStatus) &&
                Objects.equals(userType, phoneUser.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, loginName, loginPassword, creationDate, fName, mName, lName, organizationType, email, imagePath, address, mobilePhone, organizationName, userStatus, userType);
    }

    @OneToMany(mappedBy = "phoneUserByUserId")
    public Collection<LandlinePhone> getLandlinePhonesByUserId() {
        return landlinePhonesByUserId;
    }

    public void setLandlinePhonesByUserId(Collection<LandlinePhone> landlinePhonesByUserId) {
        this.landlinePhonesByUserId = landlinePhonesByUserId;
    }

    @OneToMany(mappedBy = "phoneUserByRequesterUserId")
    public Collection<Logistics> getLogisticsByUserId() {
        return logisticsByUserId;
    }

    public void setLogisticsByUserId(Collection<Logistics> logisticsByUserId) {
        this.logisticsByUserId = logisticsByUserId;
    }

    @OneToMany(mappedBy = "phoneUserByDeliveryToUserId")
    public Collection<Logistics> getLogisticsByUserId_0() {
        return logisticsByUserId_0;
    }

    public void setLogisticsByUserId_0(Collection<Logistics> logisticsByUserId_0) {
        this.logisticsByUserId_0 = logisticsByUserId_0;
    }

    @OneToMany(mappedBy = "phoneUserByUserId")
    public Collection<UserFeature> getUserFeaturesByUserId() {
        return userFeaturesByUserId;
    }

    public void setUserFeaturesByUserId(Collection<UserFeature> userFeaturesByUserId) {
        this.userFeaturesByUserId = userFeaturesByUserId;
    }
}
