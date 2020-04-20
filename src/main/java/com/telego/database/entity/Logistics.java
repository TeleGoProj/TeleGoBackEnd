package com.telego.database.entity;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Logistics {

	@Id
	@Column(name = "LOGISTICS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "logisticteGenerator")
	@SequenceGenerator(name = "logisticteGenerator", sequenceName = "logistict_sequence", initialValue = 1000, allocationSize = 1)
	private Long logisticsId;

	@Column(name = "DELIVERY_TO_STREET")
	private String deliveryToStreet;

	@Column(name = "REQUEST_DATE")
	private Time requestDate;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "DELIVERY_COMMENTS")
	private String deliveryComments;

	@Column(name = "GOODS_DESCRIPTION")
	private String goodsDescription;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REQUESTER_USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByRequester;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_TO_USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByDeliveryToUser;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_TO_AREA_ID", referencedColumnName = "AREA_ID")
	private Area areaByDeliveryTo;

	public Long getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(Long logisticsId) {
		this.logisticsId = logisticsId;
	}

	public String getDeliveryToStreet() {
		return deliveryToStreet;
	}

	public void setDeliveryToStreet(String deliveryToStreet) {
		this.deliveryToStreet = deliveryToStreet;
	}

	public Time getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Time requestDate) {
		this.requestDate = requestDate;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getDeliveryComments() {
		return deliveryComments;
	}

	public void setDeliveryComments(String deliveryComments) {
		this.deliveryComments = deliveryComments;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public PhoneUser getPhoneUserByRequester() {
		return phoneUserByRequester;
	}

	public void setPhoneUserByRequester(PhoneUser phoneUserByRequester) {
		this.phoneUserByRequester = phoneUserByRequester;
	}

	public PhoneUser getPhoneUserByDeliveryToUser() {
		return phoneUserByDeliveryToUser;
	}

	public void setPhoneUserByDeliveryToUser(PhoneUser phoneUserByDeliveryToUser) {
		this.phoneUserByDeliveryToUser = phoneUserByDeliveryToUser;
	}

	public Area getAreaByDeliveryTo() {
		return areaByDeliveryTo;
	}

	public void setAreaByDeliveryTo(Area areaByDeliveryTo) {
		this.areaByDeliveryTo = areaByDeliveryTo;
	}

}
