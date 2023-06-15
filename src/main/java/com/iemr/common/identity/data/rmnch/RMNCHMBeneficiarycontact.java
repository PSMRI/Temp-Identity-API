/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.identity.data.rmnch;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Table(name = "i_beneficiarycontacts")
@Data
public class RMNCHMBeneficiarycontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private BigInteger benContactsID;

	@Column(nullable = false, length = 50, updatable = false)
	private String createdBy;

	@Column(name = "CreatedDate", updatable = false)
	private Timestamp createdDate;

	private Boolean deleted = false;

	@Email
	@Column(length = 75)
	private String emailId;

	@Column(length = 25)
	private String emergencyContactNum;

	@Column(length = 15)
	private String emergencyContactTyp;

	private Timestamp lastModDate;

	@Column(length = 50)
	private String modifiedBy;

	@Column(length = 25)
	private String phoneNum1;

	@Column(length = 25)
	private String phoneNum2;

	@Column(length = 25)
	private String phoneNum3;

	@Column(length = 25)
	private String phoneNum4;

	@Column(length = 25)
	private String phoneNum5;

	@Column(length = 15)
	private String phoneTyp1;

	@Column(length = 15)
	private String phoneTyp2;

	@Column(length = 15)
	private String phoneTyp3;

	@Column(length = 15)
	private String phoneTyp4;

	@Column(length = 15)
	private String phoneTyp5;

	@Transient
	private String contact_number;

	@Column(nullable = false, length = 25)
	private String preferredPhoneNum;

	@Column(length = 15)
	private String preferredPhoneTyp;

	@Column(nullable = false, length = 25)
	private String preferredSMSPhoneNum;

	@Column(length = 15)
	private String preferredSMSPhoneTyp;

	@Column(nullable = false, length = 4)
	private String processed = "N";

	private Boolean reserved;

	private Integer reservedById;

	@Column(length = 45)
	private String reservedFor;

	private Timestamp reservedOn;

	@Expose
	@Column(name = "vanID", updatable = false)
	private Integer VanID;

	@Expose
	@Column(name = "parkingPlaceID", updatable = false)
	private Integer parkingPlaceID;

	@Expose
	@Column(name = "VanSerialNo", updatable = false)
	private BigInteger id;
	
	@Expose
	@Column(name = "SyncedBy")
	private String SyncedBy;

	@Expose
	@Column(name = "SyncedDate")
	private Timestamp SyncedDate;
}