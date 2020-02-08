package com.telego.database.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Logistics {
    private Long logisticsId;
    private String deliveryToStreet;
    private Time requestDate;
    private Long status;
    private String deliveryComments;
    private String goodsDescription;
    private PhoneUser phoneUserByRequesterUserId;
    private PhoneUser phoneUserByDeliveryToUserId;
    private Area areaByDeliveryToAreaId;

    @Id
    @Column(name = "LOGISTICS_ID")
    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    @Basic
    @Column(name = "DELIVERY_TO_STREET")
    public String getDeliveryToStreet() {
        return deliveryToStreet;
    }

    public void setDeliveryToStreet(String deliveryToStreet) {
        this.deliveryToStreet = deliveryToStreet;
    }

    @Basic
    @Column(name = "REQUEST_DATE")
    public Time getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Time requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "STATUS")
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Basic
    @Column(name = "DELIVERY_COMMENTS")
    public String getDeliveryComments() {
        return deliveryComments;
    }

    public void setDeliveryComments(String deliveryComments) {
        this.deliveryComments = deliveryComments;
    }

    @Basic
    @Column(name = "GOODS_DESCRIPTION")
    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logistics logistics = (Logistics) o;
        return Objects.equals(logisticsId, logistics.logisticsId) &&
                Objects.equals(deliveryToStreet, logistics.deliveryToStreet) &&
                Objects.equals(requestDate, logistics.requestDate) &&
                Objects.equals(status, logistics.status) &&
                Objects.equals(deliveryComments, logistics.deliveryComments) &&
                Objects.equals(goodsDescription, logistics.goodsDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logisticsId, deliveryToStreet, requestDate, status, deliveryComments, goodsDescription);
    }

    @ManyToOne
    @JoinColumn(name = "REQUESTER_USER_ID", referencedColumnName = "USER_ID")
    public PhoneUser getPhoneUserByRequesterUserId() {
        return phoneUserByRequesterUserId;
    }

    public void setPhoneUserByRequesterUserId(PhoneUser phoneUserByRequesterUserId) {
        this.phoneUserByRequesterUserId = phoneUserByRequesterUserId;
    }

    @ManyToOne
    @JoinColumn(name = "DELIVERY_TO_USER_ID", referencedColumnName = "USER_ID")
    public PhoneUser getPhoneUserByDeliveryToUserId() {
        return phoneUserByDeliveryToUserId;
    }

    public void setPhoneUserByDeliveryToUserId(PhoneUser phoneUserByDeliveryToUserId) {
        this.phoneUserByDeliveryToUserId = phoneUserByDeliveryToUserId;
    }

    @ManyToOne
    @JoinColumn(name = "DELIVERY_TO_AREA_ID", referencedColumnName = "AREA_ID")
    public Area getAreaByDeliveryToAreaId() {
        return areaByDeliveryToAreaId;
    }

    public void setAreaByDeliveryToAreaId(Area areaByDeliveryToAreaId) {
        this.areaByDeliveryToAreaId = areaByDeliveryToAreaId;
    }
}
