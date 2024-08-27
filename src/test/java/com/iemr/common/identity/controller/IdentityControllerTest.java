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
package com.iemr.common.identity.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.iemr.common.identity.domain.Address;
import com.iemr.common.identity.dto.BenFamilyDTO;
import com.iemr.common.identity.dto.BenIdentityDTO;
import com.iemr.common.identity.dto.BenServiceDTO;
import com.iemr.common.identity.dto.BeneficiariesDTO;
import com.iemr.common.identity.dto.IdentityEditDTO;
import com.iemr.common.identity.dto.IdentitySearchDTO;
import com.iemr.common.identity.dto.ReserveIdentityDTO;
import com.iemr.common.identity.dto.SearchSyncDTO;
import com.iemr.common.identity.exception.MissingMandatoryFieldsException;
import com.iemr.common.identity.service.IdentityService;

import jakarta.persistence.NoResultException;
import jakarta.persistence.QueryTimeoutException;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@ExtendWith(MockitoExtension.class)
class IdentityControllerTest {
	@InjectMocks
	IdentityController identityController;
	@Mock
	IdentityService svc;

	@Test
	@Description("Tests successful retrieval of all beneficiaries. (TC_GetBeneficiaries_Success_001)")
	void testGetBeneficiaries() throws NoResultException, QueryTimeoutException, Exception {
		IdentitySearchDTO searchParams = new IdentitySearchDTO();

		BeneficiariesDTO a1 = new BeneficiariesDTO();
		makeBeneficiariesDTO(a1);
		List<BeneficiariesDTO> bdList = Lists.newArrayList();
		a1.setBenId(new BigInteger("1"));
		bdList.add(a1);

		String req = new Gson().toJson(searchParams);
		// when(svc.getBeneficiaries(searchParams)).thenReturn(any()).thenReturn(bdList);
		String resp = identityController.getBeneficiaries(req);
		Assertions.assertNotNull(resp);

	}

	private void makeBeneficiariesDTO(BeneficiariesDTO dto) {
		dto.setAbhaDetails(null);
		dto.setAccountNo(null);
		dto.setAgeAtMarriage(null);
		dto.setBankName(null);
		dto.setBenAccountID(null);
		dto.setBeneficiaryAge(null);
		dto.setBeneficiaryDetails(null);
		List<BenFamilyDTO> tags = new ArrayList<>();
		BenFamilyDTO benFamilyDTO = new BenFamilyDTO();
		benFamilyDTO.setAssociatedBenRegId(null);
		benFamilyDTO.setBenFamilyMapId(null);
		benFamilyDTO.setCreatedBy(null);
		benFamilyDTO.setCreatedDate(null);
		benFamilyDTO.setDeleted(null);
		benFamilyDTO.setIsEmergencyContact(true);
		benFamilyDTO.setLastModDate(null);
		benFamilyDTO.setModifiedBy(null);
		benFamilyDTO.setParkingPlaceID(null);
		benFamilyDTO.setRelationshipID(null);
		benFamilyDTO.setRelationshipToSelf(null);
		benFamilyDTO.setVanID(null);

		tags.add(benFamilyDTO);
		dto.setBeneficiaryFamilyTags(tags);
		List<BenIdentityDTO> identity = new ArrayList<>();
		BenIdentityDTO benIdentityDTO = new BenIdentityDTO();
		benIdentityDTO.toString();
		identity.add(benIdentityDTO);
		dto.setBeneficiaryIdentites(identity);

		List<BenServiceDTO> service = new ArrayList<>();
		BenServiceDTO benServiceDTO = new BenServiceDTO();
		benServiceDTO.toString();
		service.add(benServiceDTO);
		dto.setBeneficiaryServiceMap(service);
		dto.setBenId(null);
		dto.setBenMapId(null);
		dto.setBenRegId(null);
		dto.setBranchName(null);
		dto.setContacts(null);
		dto.setCreatedBy(null);
		dto.setCreatedDate(null);
		Address address = new Address();
		address.toString();
		address.equals(address);
		dto.setCurrentAddress(null);
		dto.setDeleted(null);
		dto.setEmail(null);
		dto.setEmergencyAddress(address);
		dto.setEmergencyContactNum(null);
		dto.setEmergencyContactTyp(null);
		dto.setIfscCode(null);
		dto.setIncomeStatus(null);
		dto.setIsHIVPos(null);
		dto.setLastModDate(null);
		dto.setLiteracyStatus(null);
		dto.setMarriageDate(null);
		dto.setModifiedBy(null);
		dto.setMonthlyFamilyIncome(null);
		dto.setMotherName(null);
		dto.setOccupationName(null);
		dto.setOccupationId(null);
		dto.setPermanentAddress(address);
		dto.setPreferredEmailId(null);
		dto.setPreferredPhoneNum(null);
		dto.setPreferredPhoneTyp(null);
		dto.setPreferredSMSPhoneNum(null);
		dto.setPreferredSMSPhoneTyp(null);
		dto.setReligion(null);
		dto.setReligionId(null);
		dto.setSourceOfInformation(null);
		dto.toString();
		BeneficiariesDTO beneficiariesDTO = new BeneficiariesDTO();
		dto.equals(beneficiariesDTO);

	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by beneficiary registration ID. (TC_GetBeneficiariesByBeneficiaryRegId_Success_001)")
	void testGetBeneficiariesByBeneficiaryRegId() {
		String resp = identityController.getBeneficiariesByBeneficiaryRegId("123");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests exception handling within the getBeneficiariesByBeneficiaryRegId method. (TC_GetBeneficiariesByBeneficiaryRegId_Exception_002)")
	void testGetBeneficiariesByBeneficiaryRegIdCatchBlock() throws NoResultException, QueryTimeoutException, Exception {
		when(svc.getBeneficiariesByBenRegId(any())).thenThrow(NoResultException.class);
		String resp = identityController.getBeneficiariesByBeneficiaryRegId("123");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by beneficiary ID. (TC_GetBeneficiariesByBeneficiaryId_Success_001)")
	void testGetBeneficiariesByBeneficiaryId() {
		String resp = identityController.getBeneficiariesByBeneficiaryId("987");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests exception handling within the getBeneficiariesByBeneficiaryId method. (TC_GetBeneficiariesByBeneficiaryId_Exception_002)")
	void testGetBeneficiariesByBeneficiaryIdCatchBlock() throws NoResultException, QueryTimeoutException, Exception {
		when(svc.getBeneficiariesByBenId(any())).thenThrow(NoResultException.class);
		String resp = identityController.getBeneficiariesByBeneficiaryId("987");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by phone number. (TC_GetBeneficiariesByPhoneNum_Success_001)")
	void testGetBeneficiariesByPhoneNum() {
		String resp = identityController.getBeneficiariesByPhoneNum("9988776655");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests exception handling within the getBeneficiariesByPhoneNum method. (TC_GetBeneficiariesByPhoneNum_Exception_002)")
	void testGetBeneficiariesByPhoneNumCatchblock() throws NoResultException, QueryTimeoutException, Exception {
		when(svc.getBeneficiariesByPhoneNum(any())).thenThrow(NoResultException.class);
		String resp = identityController.getBeneficiariesByPhoneNum("9988776655");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by ABHA address. (TC_SearhBeneficiaryByABHAAddress_Success_001)")
	void testSearhBeneficiaryByABHAAddress() {
		String resp = identityController.searhBeneficiaryByABHAAddress("9876");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests exception handling within the searchBeneficiaryByABHAAddress method. (TC_SearhBeneficiaryByABHAAddress_Exception_002)")
	void testSearhBeneficiaryByABHAAddressCatchblock() throws NoResultException, QueryTimeoutException, Exception {
		when(svc.getBeneficiaryByHealthIDAbhaAddress(any())).thenThrow(NoResultException.class);
		String resp = identityController.searhBeneficiaryByABHAAddress("9876");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by ABHA ID. (TC_SearhBeneficiaryByABHAIdNo_Success_001)")
	void testSearhBeneficiaryByABHAIdNo() {
		String resp = identityController.searhBeneficiaryByABHAIdNo("9876");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests exception handling within the searchBeneficiaryByABHAIdNo method. (TC_SearhBeneficiaryByABHAIdNo_Exception_002)")
	void testSearhBeneficiaryByABHAIdNoCatchblock() throws NoResultException, QueryTimeoutException, Exception {
		when(svc.getBeneficiaryByHealthIDNoAbhaIdNo(any())).thenThrow(NoResultException.class);
		String resp = identityController.searhBeneficiaryByABHAIdNo("9876");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by family ID. (TC_SearhBeneficiaryByFamilyId_Success_001)")
	void testSearhBeneficiaryByFamilyId() {
		String resp = identityController.searhBeneficiaryByFamilyId("9876");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests exception handling within the searchBeneficiaryByFamilyId method. (TC_SearhBeneficiaryByFamilyId_Exception_002)")
	void testSearhBeneficiaryByFamilyIdCatchblock() throws NoResultException, QueryTimeoutException, Exception {
		when(svc.searhBeneficiaryByFamilyId(any())).thenThrow(NoResultException.class);
		String resp = identityController.searhBeneficiaryByFamilyId("9876");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of beneficiaries by block ID and last modified date. (TC_SearchBeneficiaryByBlockIdAndLastModDate_Success_001)")
	void testSearchBeneficiaryByBlockIdAndLastModDate() {
		BeneficiariesDTO a1 = new BeneficiariesDTO();
		List<BeneficiariesDTO> bdList = Lists.newArrayList();
		a1.setBenId(new BigInteger("1"));
		bdList.add(a1);
		SearchSyncDTO searchSyncDTO = new SearchSyncDTO();
		String req = new Gson().toJson(searchSyncDTO);
		// when(svc.searchBeneficiaryByBlockIdAndLastModifyDate(any(),
		// any())).thenReturn(bdList);

		String resp = identityController.searchBeneficiaryByVillageIdAndLastModDate(req);

		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests the behavior of the reserveIdentity method when an empty identity object is provided. (TC_ReserveIdentityEmptyIdentity_001)")
	void testReserveIdentityEmptyIdentity() throws ParseException {
		String resp = identityController.reserveIdentity("String");
		String status = getData(resp, "statusMessage");
		Assertions.assertNotEquals("Null/Empty Identity Create Data.", status);
	}

	@Test
	@Description("Tests successful reservation of an identity. (TC_ReserveIdentity_Success_002)")
	void testReserveIdentity() throws ParseException {
		ReserveIdentityDTO reserveIdentityDTO = new ReserveIdentityDTO();
		String req = new Gson().toJson(reserveIdentityDTO);
		String resp = identityController.reserveIdentity(req);
		String status = getData(resp, "statusMessage");
		Assertions.assertEquals("success", status);
	}

	@Test
	@Description("Tests the behavior of the unreserveIdentity method when an empty identity object is provided. (TC_UnreserveIdentityEmptyIdentity_001)")
	void testUnreserveIdentityEmptyIdentity() throws ParseException {
		String resp = identityController.unreserveIdentity("String");
		String status = getData(resp, "statusMessage");
		Assertions.assertNotEquals("Null/Empty Identity Create Data.", status);

	}

	@Test
	@Description("Tests successful unreservation of an identity. (TC_UnreserveIdentity_Success_002)")
	void testUnreserveIdentity() throws ParseException {
		ReserveIdentityDTO reserveIdentityDTO = new ReserveIdentityDTO();
		String req = new Gson().toJson(reserveIdentityDTO);
		String resp = identityController.unreserveIdentity(req);
		String status = getData(resp, "statusMessage");
		Assertions.assertEquals("success", status);
	}

	@Test
	@Description("Tests exception handling within the getFiniteBeneficiaries method when an invalid JSON is provided. (TC_GetFiniteBeneficiariesCatchblockIfInvalidJSON_001)")
	void testGetFiniteBeneficiariesCatchblockIfInvalidJSON() {
		String resp = identityController.getFiniteBeneficiaries("String");
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful retrieval of a finite number of beneficiaries. (TC_GetFiniteBeneficiaries_Success_002)")
	void testGetFiniteBeneficiaries() throws ParseException {
		IdentitySearchDTO identitySearchDTO = new IdentitySearchDTO();
		String req = new Gson().toJson(identitySearchDTO);
		String resp = identityController.getFiniteBeneficiaries(req);
		String status = getData(resp, "statusMessage");
		Assertions.assertEquals("success", status);
	}

	@Test
	@Description("Tests the handling of a NoResultException within the getFiniteBeneficiaries method. (TC_GetFiniteBeneficiariesNoResultException_003)")
	void testGetFiniteBeneficiariesNoResultException() throws NoResultException, QueryTimeoutException, Exception {
		IdentitySearchDTO identitySearchDTO = new IdentitySearchDTO();
		String req = new Gson().toJson(identitySearchDTO);
		when(svc.getBeneficiaries(identitySearchDTO)).thenThrow(NoResultException.class);
		String resp = identityController.getFiniteBeneficiaries(req);
		String status = getData(resp, "statusMessage");
		Assertions.assertEquals("failure", status);
	}

	@Test
	@Description("Tests the handling of a QueryTimeoutException within the getFiniteBeneficiaries method. (TC_GetFiniteBeneficiariesQueryTimeoutException_004)")
	void testGetFiniteBeneficiariesQueryTimeoutException() throws NoResultException, QueryTimeoutException, Exception {
		IdentitySearchDTO identitySearchDTO = new IdentitySearchDTO();
		String req = new Gson().toJson(identitySearchDTO);
		when(svc.getBeneficiaries(identitySearchDTO)).thenThrow(QueryTimeoutException.class);
		String resp = identityController.getFiniteBeneficiaries(req);
		String status = getData(resp, "statusMessage");
		Assertions.assertEquals("failure", status);
	}

	@Test
	@Description("Tests successful retrieval of beneficiary image by beneficiary registration ID. (TC_GetBeneficiaryImageByBenRegID_Success_001)")
	void testGetBeneficiaryImageByBenRegID() {
		String resp = identityController.getBeneficiaryImageByBenRegID("String");
		Assertions.assertNull(resp);
	}

	@Test
	@Description("Tests successful editing of identity information related to education or community details. (TC_EditIdentityEducationOrCommunity_Success_001)")
	void testEditIdentityEducationOrCommunity() throws ParseException {
		IdentityEditDTO identityEditDTO = new IdentityEditDTO();
		String req = new Gson().toJson(identityEditDTO);
		String resp = identityController.editIdentityEducationOrCommunity(req);
		String actualresp = getData(resp, "data");
		Assertions.assertEquals("Updated successfully", actualresp);
	}

	private String getData(String resp, String status) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(resp);
		JSONObject object = (JSONObject) json.get("response");
		String actualresp = object.getAsString(status);
		return actualresp;
	}

	@Test
	@Description("Tests exception handling within the editIdentityEducationOrCommunity method. (TC_EditIdentityEducationOrCommunity_Exception_002)")
	void testEditIdentityEducationOrCommunityCatchblock() throws MissingMandatoryFieldsException, ParseException {
		IdentityEditDTO identityEditDTO = new IdentityEditDTO();
		String req = new Gson().toJson(identityEditDTO);
		doThrow(MissingMandatoryFieldsException.class).when(svc).editIdentityEducationOrCommunity(identityEditDTO);
		svc.editIdentityEducationOrCommunity(any());
		String resp = identityController.editIdentityEducationOrCommunity(req);
		String actualresp = getData(resp, "data");
		Assertions.assertNotEquals("Updated successfully", actualresp);
	}

	@Test
	@Description("Tests the availability of a beneficiary ID on the local server. (TC_CheckAvailablBenIDLocalServer_Success_001)")
	void testCheckAvailablBenIDLocalServer() {
		String resp = identityController.checkAvailablBenIDLocalServer();
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests successful saving of a generated beneficiary ID to the local server. (TC_SaveGeneratedBenIDToLocalServer_Success_001)")
	void testSaveGeneratedBenIDToLocalServer() {
		String resp = identityController.saveGeneratedBenIDToLocalServer(null);
		Assertions.assertNotNull(resp);
	}

	@Test
	@Description("Tests counting beneficiaries based on village ID and last modified date. (TC_countBeneficiaryByVillageIdAndLastModDate_Success_001)")
	public void testcountBeneficiaryByVillageIdAndLastModDate() {
		SearchSyncDTO searchSyncDTO = new SearchSyncDTO();
		searchSyncDTO.setLastModifiedDate(9l);
		String json = new Gson().toJson(searchSyncDTO);
		when(svc.countBeneficiaryByVillageIdAndLastModifyDate(any(), any())).thenReturn(9l);
		String resp = identityController.countBeneficiaryByVillageIdAndLastModDate(json);
		Assertions.assertNotNull(resp);
	}
}
