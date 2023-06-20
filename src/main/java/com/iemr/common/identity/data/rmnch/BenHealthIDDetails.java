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

public class BenHealthIDDetails {

	Integer benHealthID;

	String healthIdNumber;

	private Integer providerServiceMapId;

	private Long beneficiaryRegID;

	private Long beneficiaryID;

	String healthId;

	String authenticationMode;

	public String getAuthenticationMode() {
		return authenticationMode;
	}

	public void setAuthenticationMode(String authenticationMode) {
		this.authenticationMode = authenticationMode;
	}

	public Integer getBenHealthID() {
		return benHealthID;
	}

	public void setBenHealthID(Integer benHealthID) {
		this.benHealthID = benHealthID;
	}

	public String getHealthIdNumber() {
		return healthIdNumber;
	}

	public void setHealthIdNumber(String healthIdNumber) {
		this.healthIdNumber = healthIdNumber;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapId;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapId = providerServiceMapID;
	}

	public Long getBeneficiaryRegId() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegId(Long beneficiaryRegId) {
		this.beneficiaryRegID = beneficiaryRegId;
	}

	public String getHealthId() {
		return healthId;
	}

	public void setHealthId(String healthId) {
		this.healthId = healthId;
	}

	public Long getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

}
