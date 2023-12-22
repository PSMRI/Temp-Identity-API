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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.math.BigInteger;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.common.identity.dto.BeneficiariesDTO;
import com.iemr.common.identity.dto.BeneficiariesPartialDTO;
import com.iemr.common.identity.dto.BeneficiaryCreateResp;
import com.iemr.common.identity.dto.IdentitySearchDTO;
import com.iemr.common.identity.mapper.IdentityMapper;
import com.iemr.common.identity.repo.BenAddressRepo;
import com.iemr.common.identity.repo.BenMappingRepo;
import com.iemr.common.identity.service.IdentityService;
import com.iemr.common.identity.utils.exception.IEMRException;

import jakarta.persistence.NoResultException;
import jakarta.persistence.QueryTimeoutException;

@RunWith(MockitoJUnitRunner.class)
public class IdentityControllerTest {

	@InjectMocks
	IdentityController identityController;

	@Mock
	IdentityService identityService;

	@Mock
	BenMappingRepo benMappingRepo;

	@Mock
	IdentityMapper identityMapper;

	@Mock
	BenAddressRepo addressRepo;

	@Mock
	IdentitySearchDTO identitySearchDTO;

	@Test
	public void getBeneficiariesTest() {
		BeneficiariesDTO a1 = new BeneficiariesDTO();
		List<BeneficiariesDTO> bdList = Lists.newArrayList();
		a1.setBenId(new BigInteger("1"));
		bdList.add(a1);
		try {
			doReturn(bdList).when(identityService).getBeneficiaries(Mockito.any(IdentitySearchDTO.class));
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = identityController.getBeneficiaries(Mockito.anyString());
		assertTrue(res.contains("\\\"benId\\\":1"));
	}

	@Test
	public void getBeneficiariesTest1() {
		BeneficiariesDTO a1 = new BeneficiariesDTO();
		List<BeneficiariesDTO> bdList = Lists.newArrayList();
		a1.setBenId(new BigInteger("1"));
		bdList.add(a1);
		try {
			doReturn(bdList).when(identityService).getBeneficiaries(Mockito.any(IdentitySearchDTO.class));
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = identityController.getBeneficiaries("");
		assertTrue(res.contains("\\\"benId\\\":1"));
	}

	@Test
	public void getBeneficiariesByBeneficiaryRegIdTest() {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		BeneficiariesDTO beneficiariesDTO = new BeneficiariesDTO();
		beneficiariesDTO.setBenId(new BigInteger("101"));
		list.add(beneficiariesDTO);
		try {
			doReturn(list).when(identityService).getBeneficiariesByBenRegId(Mockito.any(BigInteger.class));
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = identityController.getBeneficiariesByBeneficiaryRegId("10101");
		assertTrue(response.contains("\\\"benId\\\":101"));
	}

	@Test
	public void getBeneficiariesByBeneficiaryRegIdJsonNullTest() {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		try {
			doReturn(list).when(identityService).getBeneficiariesByBenRegId(Mockito.any(BigInteger.class));
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = identityController.getBeneficiariesByBeneficiaryRegId("");
		assertFalse(response.contains("\\\"benId\\\":101"));
	}

	@Test
	public void getBeneficiariesByBeneficiaryIdTest() {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		BeneficiariesDTO beneficiariesDTO = new BeneficiariesDTO();
		beneficiariesDTO.setBenId(new BigInteger("201"));
		list.add(beneficiariesDTO);
		try {
			doReturn(list).when(identityService).getBeneficiariesByBenId(Mockito.any(BigInteger.class));
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = identityController.getBeneficiariesByBeneficiaryId("20202");
		assertTrue(response.contains("\\\"benId\\\":201"));
	}

	@Test
	public void getBeneficiariesByBeneficiaryIdJsonNullTest() {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		try {
			doReturn(list).when(identityService).getBeneficiariesByBenId(Mockito.any(BigInteger.class));
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = identityController.getBeneficiariesByBeneficiaryId("");
		assertFalse(response.contains("\\\"benId\\\":201"));
	}

	@Test
	public void getBeneficiariesByPhoneNumTest() throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		BeneficiariesDTO beneficiariesDTO = new BeneficiariesDTO();
		beneficiariesDTO.setBenId(new BigInteger("301"));
		list.add(beneficiariesDTO);
		doReturn(list).when(identityService).getBeneficiariesByPhoneNum(Mockito.anyString());
		String response = identityController.getBeneficiariesByPhoneNum("30303");
		assertTrue(response.contains("\\\"benId\\\":301"));
	}

	@Test
	public void getBeneficiariesByPhoneNumJsonNullTest() throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		doReturn(list).when(identityService).getBeneficiariesByPhoneNum(Mockito.anyString());
		String response = identityController.getBeneficiariesByPhoneNum("");
		assertFalse(response.contains("\\\"benId\\\":301"));
	}

	@Test
	public void editIdentityJsonNullTest() {
		String response = identityController.editIdentity("");
		assertFalse(response.contains("Updated successfully"));
	}

	@Test
	public void editIdentityTest() {
		String response = identityController.editIdentity("{}");
		assertTrue(response.contains("Updated successfully"));
	}

	@Test
	public void reserveIdentityTest() {

		String res = identityController.reserveIdentity("{}");
		assertTrue(res.contains("\"statusMessage\":\"success\""));
	}

	@Test
	public void reserveIdentityNullTest() {

		String res = identityController.reserveIdentity("");
		assertFalse(res.contains("\\\"statusMessage\\\":\\\"success\\\""));
	}

	@Test
	public void unreserveIdentityTest() {
		String res = identityController.unreserveIdentity("{}");
		assertTrue(res.contains("\"statusMessage\":\"success\""));

	}

	@Test
	public void unreserveIdentityNullTest() {
		String res = identityController.unreserveIdentity("");
		assertFalse(res.contains("\\\"statusMessage\\\":\\\"success\\\""));

	}

	@Test
	public void createIdentityTest() throws IEMRException {
		BeneficiaryCreateResp beneficiaryCreateResp = new BeneficiaryCreateResp();
		beneficiaryCreateResp.setBenId(new BigInteger("501"));
		doReturn(beneficiaryCreateResp).when(identityService).createIdentity(Mockito.any());
		String response = identityController.createIdentity("{}");
		assertTrue(response.contains("\\\"benId\\\":501"));

	}

	@Test
	public void createIdentityJsonNullTest() {
		String response = identityController.createIdentity("");
		assertFalse(response.contains("\\\"benId\\\":501"));

	}

	@Test
	public void getBeneficiariesByBenRegIdsTest() {
		List<BeneficiariesDTO> list = Lists.newArrayList();
		BeneficiariesDTO beneficiariesDTO = new BeneficiariesDTO();
		beneficiariesDTO.setBenId(new BigInteger("601"));
		list.add(beneficiariesDTO);
		doReturn(list).when(identityService).getBeneficiariesDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
		String response = identityController.getBeneficiariesByBenRegIds("[601]");
		assertTrue(response.contains("\\\"benId\\\":601"));
	}

	@Test
	public void getBeneficiariesByBenRegIdsJsonNullTest() {
		String response = identityController.getBeneficiariesByBenRegIds("");
		assertFalse(response.contains("\\\"benId\\\":601"));
	}

	@Test
	public void getPartialBeneficiariesByBenRegIdsTest() {
		List<BeneficiariesPartialDTO> partialList = Lists.newArrayList();
		BeneficiariesPartialDTO partialDTO = new BeneficiariesPartialDTO();
		partialDTO.setBeneficiaryDetailsId(new BigInteger("101"));
		partialList.add(partialDTO);
		doReturn(partialList).when(identityService)
				.getBeneficiariesPartialDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
		String response = identityController.getPartialBeneficiariesByBenRegIds("[505]");
		assertTrue(response.contains("\\\"beneficiaryDetailsId\\\":101"));
	}

	@Test
	public void getPartialBeneficiariesByBenRegIdsJsonNullTest() {
		String response = identityController.getPartialBeneficiariesByBenRegIds("");
		assertFalse(response.contains("\\\"beneficiaryDetailsId\\\":101"));
	}

	@Test
	public void getFiniteBeneficiariesTest1() throws NoResultException, QueryTimeoutException, Exception {
		BeneficiariesDTO a1 = new BeneficiariesDTO();
		List<BeneficiariesDTO> bdList = Lists.newArrayList();
		a1.setBenId(new BigInteger("1"));
		bdList.add(a1);
		doReturn(bdList).when(identityService).getBeneficiaries(Mockito.any(IdentitySearchDTO.class));
		String res = identityController.getFiniteBeneficiaries(Mockito.anyString());
		assertTrue(res.contains("\\\"benId\\\":1"));
	}
}
