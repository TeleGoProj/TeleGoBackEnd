package com.telego.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "LANDLINE_PHONE", schema = "PHONE", catalog = "")
public class LandlinePhone {

	@Id
	@Column(name = "LANDLINE_PHONE_ID")
	@EqualsAndHashCode.Include
	private Long landlinePhoneId;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private PhoneUser phoneUserByUserId;

	@ManyToOne
	@JoinColumn(name = "BOX_ID", referencedColumnName = "BOX_ID")
	private Box boxByBoxId;

}
