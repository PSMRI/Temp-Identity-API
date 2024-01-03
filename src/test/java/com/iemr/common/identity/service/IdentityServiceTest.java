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
package com.iemr.common.identity.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyList;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.iemr.common.identity.data.rmnch.RMNCHCBACdetails;
import com.iemr.common.identity.domain.Address;
import com.iemr.common.identity.domain.Identity;
import com.iemr.common.identity.domain.MBeneficiaryAccount;
import com.iemr.common.identity.domain.MBeneficiaryImage;
import com.iemr.common.identity.domain.MBeneficiaryaddress;
import com.iemr.common.identity.domain.MBeneficiaryconsent;
import com.iemr.common.identity.domain.MBeneficiarycontact;
import com.iemr.common.identity.domain.MBeneficiarydetail;
import com.iemr.common.identity.domain.MBeneficiaryfamilymapping;
import com.iemr.common.identity.domain.MBeneficiaryidentity;
import com.iemr.common.identity.domain.MBeneficiarymapping;
import com.iemr.common.identity.domain.MBeneficiaryregidmapping;
import com.iemr.common.identity.domain.MBeneficiaryservicemapping;
import com.iemr.common.identity.dto.BenFamilyDTO;
import com.iemr.common.identity.dto.BeneficiariesDTO;
import com.iemr.common.identity.dto.BeneficiariesPartialDTO;
import com.iemr.common.identity.dto.BeneficiaryCreateResp;
import com.iemr.common.identity.dto.IdentityDTO;
import com.iemr.common.identity.dto.IdentityEditDTO;
import com.iemr.common.identity.dto.IdentitySearchDTO;
import com.iemr.common.identity.dto.ReserveIdentityDTO;
import com.iemr.common.identity.exception.MissingMandatoryFieldsException;
import com.iemr.common.identity.mapper.IdentityEditMapper;
import com.iemr.common.identity.mapper.IdentityMapper;
import com.iemr.common.identity.mapper.IdentityPartialMapper;
import com.iemr.common.identity.repo.BenAddressRepo;
import com.iemr.common.identity.repo.BenConsentRepo;
import com.iemr.common.identity.repo.BenContactRepo;
import com.iemr.common.identity.repo.BenDataAccessRepo;
import com.iemr.common.identity.repo.BenDetailRepo;
import com.iemr.common.identity.repo.BenFamilyMappingRepo;
import com.iemr.common.identity.repo.BenIdentityRepo;
import com.iemr.common.identity.repo.BenMappingRepo;
import com.iemr.common.identity.repo.BenRegIdMappingRepo;
import com.iemr.common.identity.repo.BenServiceMappingRepo;
import com.iemr.common.identity.repo.MBeneficiaryAccountRepo;
import com.iemr.common.identity.repo.MBeneficiaryImageRepo;
import com.iemr.common.identity.repo.V_BenAdvanceSearchRepo;
import com.iemr.common.identity.utils.exception.IEMRException;
import com.iemr.common.identity.utils.mapper.OutputMapper;

import jakarta.persistence.NoResultException;
import jakarta.persistence.QueryTimeoutException;

@RunWith(SpringJUnit4ClassRunner.class)
public class IdentityServiceTest {

	@InjectMocks
	IdentityService identityService;

	@Mock
	BenRegIdMappingRepo benRegIdMappingRepo;

	@Mock
	BenMappingRepo benMappingRepo;

	@Mock
	IdentityMapper identityMapper;

	@Mock
	BenDetailRepo detailRepo;
	
	@Mock
	BenContactRepo contactRepo;
	
	@Mock
	IdentityEditMapper editMapper; 
	
	@Mock
	BenAddressRepo addressRepo;
	
	@Mock
	MBeneficiarymapping beneficiarymapping;
	
	@Mock
	MBeneficiarydetail beneficiarydetail;
	
	@Mock
	MBeneficiaryaddress beneficiaryaddress;
	
	@Mock
	BenIdentityRepo identityRepo;
	
	@Mock
	MBeneficiaryconsent mBeneficiaryconsent;
	
	@Mock
	BenConsentRepo consentRepo;
	
	@Mock
	MBeneficiarycontact mBeneficiarycontact;
	
	@Mock
	MBeneficiaryregidmapping mBeneficiaryregidmapping;
	
	@Mock
	MBeneficiaryfamilymapping fMap;
	
	@Mock
	BenFamilyMappingRepo familyMapRepo;
	
	@Mock
	MBeneficiaryservicemapping mBeneficiaryservicemapping;
	
	@Mock
	BenServiceMappingRepo serviceMapRepo;
	
	@Mock
	MBeneficiaryidentity mBeneficiaryidentity;
	
	@Mock
	IdentityPartialMapper partialMapper;
	
	@Mock
	BenDataAccessRepo accessRepo;
	@Mock
	MBeneficiaryAccountRepo accountRepo;
	@Mock
	MBeneficiaryImageRepo imageRepo;
	@Mock
	BenMappingRepo mappingRepo;
	@Mock
	private V_BenAdvanceSearchRepo v_BenAdvanceSearchRepo;
	

	@Test
	public void getBenAdressTest()
	{
		identityService.getBenAdress();
	}
	
	
	@Test
	public void getBeneficiariesTest() throws NoResultException, QueryTimeoutException, Exception
	{

		
		List<MBeneficiarymapping> list=Lists.newArrayList();
		
		MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
		mBeneficiarymapping.setBenMapId(new BigInteger("201"));
		MBeneficiaryregidmapping mBeneficiaryregidmapping=new MBeneficiaryregidmapping();
		mBeneficiaryregidmapping.setBeneficiaryID(new BigInteger("303"));
		mBeneficiarymapping.setMBeneficiaryregidmapping(mBeneficiaryregidmapping);
		
		List<MBeneficiaryfamilymapping> familyList=Lists.newArrayList();
		MBeneficiaryfamilymapping familyMapping=new MBeneficiaryfamilymapping();
		familyMapping.setBenFamilyMapId(new BigInteger("808"));
		familyList.add(familyMapping);
		mBeneficiarymapping.setMBeneficiaryfamilymappings(familyList);
		
		List<MBeneficiaryidentity> identitylist=Lists.newArrayList();
		MBeneficiaryidentity identity=new MBeneficiaryidentity();
		identity.setBenIdentityId(new BigInteger("909"));
		identitylist.add(identity);
		mBeneficiarymapping.setMBeneficiaryidentities(identitylist);
		
		list.add(mBeneficiarymapping);
		doReturn(list).when(benMappingRepo).dynamicFilterSearch(Mockito.any());
		
		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));

		doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(Mockito.mock(IdentitySearchDTO.class));
		//assertTrue(benDTOList.size()>0);
	}

	
	@Test
	public void getBeneficiariesBenIDNullTest() throws NoResultException, QueryTimeoutException, Exception
	{
		IdentitySearchDTO identitySearchDTO=new IdentitySearchDTO();
		identitySearchDTO.setBeneficiaryId(new BigInteger("101"));
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(identitySearchDTO);
		assertFalse(benDTOList.size()>0);
	}

	@Test
	public void getBeneficiariesBenRegIDTest() throws NoResultException, QueryTimeoutException, Exception
	{
		IdentitySearchDTO identitySearchDTO=new IdentitySearchDTO();
		identitySearchDTO.setBeneficiaryRegId(new BigInteger("201"));
		
		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));
		MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
		List<MBeneficiaryfamilymapping> familyList=Lists.newArrayList();
		MBeneficiaryfamilymapping familyMapping=new MBeneficiaryfamilymapping();
		familyMapping.setBenFamilyMapId(new BigInteger("808"));
		familyList.add(familyMapping);
		mBeneficiarymapping.setMBeneficiaryfamilymappings(familyList);
		
		List<MBeneficiaryidentity> identitylist=Lists.newArrayList();
		MBeneficiaryidentity identity=new MBeneficiaryidentity();
		identity.setBenIdentityId(new BigInteger("909"));
		identitylist.add(identity);
		mBeneficiarymapping.setMBeneficiaryidentities(identitylist);

		doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		
		doReturn(mBeneficiarymapping).when(benMappingRepo).findByBenRegIdOrderByBenMapIdAsc(Mockito.any(BigInteger.class));
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(identitySearchDTO);
		//assertTrue(benDTOList.size()>0);
	}

	@Test
	public void getBeneficiariesBenConTest() throws NoResultException, QueryTimeoutException, Exception
	{
		IdentitySearchDTO identitySearchDTO=new IdentitySearchDTO();
		identitySearchDTO.setContactNumber("605");
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(identitySearchDTO);
		assertFalse(benDTOList.size()>0);
	}
	@Test
	public void getBeneficiariesBenConTest1() throws NoResultException, QueryTimeoutException, Exception
	{
		IdentitySearchDTO identitySearchDTO=new IdentitySearchDTO();
		identitySearchDTO.setContactNumber("605");
		
		MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
		List<MBeneficiarymapping> mappingList=Lists.newArrayList();
		mBeneficiarymapping.setBenMapId(new BigInteger("505"));
		mappingList.add(mBeneficiarymapping);
		doReturn(mappingList).when(benMappingRepo).findByBeneficiaryDetailsByPhoneNumber(Mockito.anyString());
		
		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));
		doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(identitySearchDTO);
		//assertTrue(benDTOList.size()>0);
	}
	

	
	@Test
	public void getBeneficiariesByBenIdTest() throws NoResultException, QueryTimeoutException, Exception {
		List<MBeneficiarymapping> benMapList = Lists.newArrayList();
		MBeneficiarymapping Mbeneficiary = new MBeneficiarymapping();
		Mbeneficiary.setBenMapId(new BigInteger("101"));
		MBeneficiaryregidmapping mapping = new MBeneficiaryregidmapping();
		mapping.setBeneficiaryID(new BigInteger("201"));
		Mbeneficiary.setMBeneficiaryregidmapping(mapping);
		benMapList.add(Mbeneficiary);

		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));

		doReturn(mapping).when(benRegIdMappingRepo).findByBeneficiaryID(Mockito.any(BigInteger.class));
		//doReturn(benMapList).when(benMappingRepo).findByMBeneficiaryregidmappingOrderByBenMapIdAsc(anyObject());
		doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(Mbeneficiary);

		List<BeneficiariesDTO> bList = identityService.getBeneficiariesByBenId(Mockito.any(BigInteger.class));
		
		//assertTrue(bList.size() > 0);
	}
	@Test
	public void getBeneficiariesByBenIdTest1() throws NoResultException, QueryTimeoutException, Exception {
		List<MBeneficiarymapping> benMapList = Lists.newArrayList();
		MBeneficiarymapping Mbeneficiary = new MBeneficiarymapping();
		Mbeneficiary.setBenMapId(new BigInteger("101"));
		MBeneficiaryregidmapping mapping = new MBeneficiaryregidmapping();
		mapping.setBeneficiaryID(new BigInteger("201"));
		Mbeneficiary.setMBeneficiaryregidmapping(mapping);
		benMapList.add(Mbeneficiary);

		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));

		doReturn(mapping).when(benRegIdMappingRepo).findByBeneficiaryID(Mockito.any(BigInteger.class));


		List<BeneficiariesDTO> bList = identityService.getBeneficiariesByBenId(Mockito.any(BigInteger.class));
		
		assertFalse(bList.size() > 0);
	}
	
	@Test
	public void getBeneficiariesByPhoneNumTest() throws NoResultException, QueryTimeoutException, Exception
	{

		
		
		MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
		mBeneficiarymapping.setBenMapId(new BigInteger("201"));
		List<MBeneficiarymapping> mappingList=Lists.newArrayList();
		mappingList.add(mBeneficiarymapping);
		
		//doReturn(mappingList).when(benMappingRepo).findByBeneficiaryDetailsByPhoneNumber(anyObject());
		
		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));
		doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesByPhoneNum(Mockito.anyString());
		//assertTrue(dtoList.size() > 0);
	}
	@Test
	public void getBeneficiariesByPhoneNumTest1() throws NoResultException, QueryTimeoutException, Exception
	{
		List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesByPhoneNum(Mockito.anyString());
		assertFalse(dtoList.size() > 0);
	}	

		/*@Test
		public void createIdentityTest() 
		{
			IdentityDTO identityDTO=new IdentityDTO();
			identityDTO.setIsPermAddrSameAsCurrAddr(true);
			identityDTO.setIsPermAddrSameAsEmerAddr(true);
			identityDTO.setIsEmerAddrSameAsCurrAddr(true);
			identityDTO.setIsEmerAddrSameAsPermAddr(true);
			
			MBeneficiaryaddress benaddress=new MBeneficiaryaddress();
			benaddress.setBenAddressID(new BigInteger("101"));
			
			doReturn(beneficiaryaddress).when(identityMapper).identityDTOToMBeneficiaryaddress(Mockito.any());
			doReturn(benaddress).when(addressRepo).save(beneficiaryaddress);
			
			MBeneficiaryconsent benconsent=new MBeneficiaryconsent();
			benconsent.setBenConsentID(new BigInteger("201"));
			
			doReturn(mBeneficiaryconsent).when(identityMapper).identityDTOToDefaultMBeneficiaryconsent(Mockito.any(),Mockito.anyBoolean(),Mockito.anyBoolean());
			doReturn(benconsent).when(consentRepo).save(mBeneficiaryconsent);

			MBeneficiarycontact bencontact=new MBeneficiarycontact();
			bencontact.setBenContactsID(new BigInteger("301"));
			
			doReturn(mBeneficiarycontact).when(identityMapper).identityDTOToMBeneficiarycontact(Mockito.any());
			doReturn(bencontact).when(contactRepo).save(mBeneficiarycontact);
			
			MBeneficiarydetail bendetail=new MBeneficiarydetail();
			bendetail.setBeneficiaryDetailsId(new BigInteger("401"));

			doReturn(beneficiarydetail).when(identityMapper).identityDTOToMBeneficiarydetail(Mockito.any());
			doReturn(bendetail).when(detailRepo).save(beneficiarydetail);

			MBeneficiaryregidmapping Benregidmapping=new MBeneficiaryregidmapping();
			doReturn(Benregidmapping).when(benRegIdMappingRepo).findFirstByProvisionedAndReserved(Mockito.anyBoolean(),Mockito.anyBoolean());
			
			MBeneficiarymapping benMapping=new MBeneficiarymapping();
			benMapping.setBenMapId(new BigInteger("701"));
			
			doReturn(beneficiarymapping).when(identityMapper).identityDTOToMBeneficiarymapping(Mockito.any());
			doReturn(benMapping).when(benMappingRepo).save(beneficiarymapping);
			
			when(benMappingRepo.save(beneficiarymapping)).then(AdditionalAnswers.returnsFirstArg());
			
			MBeneficiaryfamilymapping familymapping=new MBeneficiaryfamilymapping();
			familymapping.setBenFamilyMapId(new BigInteger("501"));
			List<MBeneficiaryfamilymapping> fmappingList=Lists.newArrayList();
			fmappingList.add(familymapping);
			doReturn(fmappingList).when(identityMapper).IdentityDTOListToMBeneficiaryfamilymappingList(Mockito.any());
			doReturn(familymapping).when(familyMapRepo).save(fMap);
			
			MBeneficiaryservicemapping servicemapping=new MBeneficiaryservicemapping();
			servicemapping.setBenServiceMapID(new BigInteger("801"));
			doReturn(mBeneficiaryservicemapping).when(identityMapper).identityDTOToMBeneficiaryservicemapping(Mockito.any());
			doReturn(servicemapping).when(serviceMapRepo).save(mBeneficiaryservicemapping);
			
			List<MBeneficiaryidentity> mIdenList=Lists.newArrayList();
			MBeneficiaryidentity mBeneficiaryidentity=new MBeneficiaryidentity();
			mBeneficiaryidentity.setBenIdentityId(new BigInteger("601"));
			mIdenList.add(mBeneficiaryidentity);
			
			List<Identity> identityList=Lists.newArrayList();
			Identity identity=new Identity();
			identity.setIdentityNo("identity"); 
			identityList.add(identity);
			identityDTO.setIdentities(identityList);

			
			doReturn(mIdenList).when(identityMapper).IdentityDTOListToMBeneficiaryidentityList(Mockito.anyListOf(Identity.class));
			doReturn(mBeneficiaryidentity).when(identityRepo).save(mBeneficiaryidentity);
			

			BeneficiaryCreateResp beneficiaryCreateResp=new BeneficiaryCreateResp();
			beneficiaryCreateResp.setBenId(new BigInteger("102"));
			beneficiaryCreateResp.setBenRegId(new BigInteger("105"));
			doReturn(beneficiaryCreateResp).when(partialMapper).MBeneficiarymappingToBeneficiaryCreateResp(Mockito.any());
			
			BeneficiaryCreateResp createRes;
			try {
				createRes = identityService.createIdentity(identityDTO);
				assertTrue(createRes.getBenId().toString().contains("102"));
				assertTrue(createRes.getBenRegId().toString().contains("105"));
			} catch (IEMRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		*/
		
		@Test

		public void getBeneficiariesPartialDeatilsByBenRegIdListTest1() {
			List<BigInteger> BenRegIds = new ArrayList<>();
			BenRegIds.add(BigInteger.valueOf(987));
			List<Object[]> list = new ArrayList<>();
			Object[] elements = new Object[12];
			elements[0] = 987;
			elements[1] = "";
			elements[2] = "";
			elements[3] = "";
			elements[4] = 45;
			elements[5] = 55;
			elements[6] = "";
			elements[7] = "";
			elements[8] = 123;
			elements[9] = "";
			elements[10] = "";
			elements[11] = Timestamp.valueOf("2011-10-02 18:48:05.123");
			list.add(elements);
			when(detailRepo.getWith_vanSerialNo_vanID(any(), any())).thenReturn(beneficiarydetail);
			when(benRegIdMappingRepo.getWithVanSerialNoVanID(any(), any())).thenReturn(mBeneficiaryregidmapping);
			when(mappingRepo.getBenMappingByRegIDList(BenRegIds)).thenReturn(list);
			List<BeneficiariesPartialDTO> dtoList = identityService
					.getBeneficiariesPartialDeatilsByBenRegIdList(BenRegIds);
			Assert.assertTrue(dtoList.size() > 0);

		}
		@Test
		public void getBeneficiariesPartialDeatilsByBenRegIdListTest()
		{
			//List<BeneficiariesPartialDTO> dtoList=identityService.getBeneficiariesPartialDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
			//assertFalse(dtoList.size()>0);
			
		}
		@Test
		public void reserveIdentity()
		{
			ReserveIdentityDTO reserveIdentityDTO=new ReserveIdentityDTO();
			reserveIdentityDTO.setReserveCount(Long.valueOf(4));
			when(benRegIdMappingRepo.countByProviderServiceMapIDAndVehicalNoOrderByBenRegIdAsc(reserveIdentityDTO.getProviderServiceMapID(), reserveIdentityDTO.getVehicalNo())).thenReturn(Long.valueOf(5));
			
			MBeneficiaryregidmapping mBeneficiaryregidmapping=new MBeneficiaryregidmapping();
			doReturn(mBeneficiaryregidmapping).when(benRegIdMappingRepo).findFirstByProviderServiceMapIDAndVehicalNoOrderByBenRegIdAsc(Mockito.anyInt(), Mockito.anyString());
			doReturn(mBeneficiaryregidmapping).when(benRegIdMappingRepo).save(Mockito.any(MBeneficiaryregidmapping.class));

			
			String res=identityService.reserveIdentity(reserveIdentityDTO);
			//assertTrue(res.contains("Successfully Completed"));
			
		}
		
		@Test
		public void unReserveIdentity()
		{
			doReturn(new Integer(200)).when(benRegIdMappingRepo).unreserveBeneficiaryIds(Mockito.anyInt(), Mockito.anyString());
			String res=identityService.unReserveIdentity(Mockito.mock(ReserveIdentityDTO.class));
			//assertTrue(res.contains("Successfully Completed"));
			
		}

		@Test
		public void editIdentityTest() throws MissingMandatoryFieldsException
		{
			IdentityEditDTO identityEditDTO=new IdentityEditDTO();
			identityEditDTO.setBeneficaryId(new BigInteger("100"));
			identityEditDTO.setBeneficiaryRegId(new BigInteger("200"));
			identityEditDTO.setChangeInSelfDetails(true);
			identityEditDTO.setChangeInOtherDetails(true);
			identityEditDTO.setChangeInAssociations(true);
			identityEditDTO.setChangeInAddress(true);
			identityEditDTO.setChangeInAddress(true);
			identityEditDTO.setChangeInContacts(true);
			identityEditDTO.setChangeInIdentities(true);
			identityEditDTO.setChangeInFamilyDetails(true);	
			identityEditDTO.setChangeInBankDetails(true);
			identityEditDTO.setChangeInBenImage(true);
			MBeneficiarymapping benMapping = new MBeneficiarymapping();
			benMapping.setMBeneficiarydetail(beneficiarydetail);
			benMapping.setMBeneficiaryaddress(beneficiaryaddress);
			benMapping.setMBeneficiarycontact(mBeneficiarycontact);
			MBeneficiaryImage img=new MBeneficiaryImage();
			benMapping.setMBeneficiaryImage(img);
			MBeneficiaryAccount mBeneficiaryAccount = new MBeneficiaryAccount();
			benMapping.setMBeneficiaryAccount(mBeneficiaryAccount);;
			MBeneficiarydetail mbDetl = new MBeneficiarydetail();
			mbDetl.setFamilyId("123");			
			mbDetl.setHeadOfFamily_RelationID(456);
			mbDetl.setHeadOfFamily_Relation("");
			mbDetl.setOther("other");
			mbDetl.setEmergencyRegistration(true);
			
			MBeneficiaryaddress mbAddr = new MBeneficiaryaddress();
			MBeneficiarycontact benCon = new MBeneficiarycontact();
			MBeneficiaryidentity mbenIdentity = new MBeneficiaryidentity();
			mbenIdentity.setBenIdentityId(BigInteger.valueOf(987));
			List<MBeneficiaryidentity> identities = new ArrayList<>();
			identities.add(mbenIdentity);
			List<MBeneficiaryidentity> idList = new ArrayList<>();
			MBeneficiaryfamilymapping mbenFamilyMapping = new MBeneficiaryfamilymapping();
			mbenFamilyMapping.setBenFamilyMapId(BigInteger.valueOf(9));
			List<MBeneficiaryfamilymapping> fbMaps = new ArrayList<>();
			fbMaps.add(mbenFamilyMapping);
			List<MBeneficiaryfamilymapping> fmList = new ArrayList<>();
			fmList.add(mbenFamilyMapping);
			
			MBeneficiaryAccount beneficiaryAccount = new MBeneficiaryAccount();
			when(editMapper.identityEditDTOToMBeneficiaryImage(any(IdentityEditDTO.class))).thenReturn(img);
			when(imageRepo.findIdByVanSerialNoAndVanID(any(),any())).thenReturn(Long.valueOf(987));
			when(accountRepo.save(any())).thenReturn(beneficiaryAccount);
			when(editMapper.identityEditDTOToMBeneficiaryAccount(any(IdentityEditDTO.class))).thenReturn(beneficiaryAccount);
			
			when(accountRepo.findIdByVanSerialNoAndVanID(any(), any())).thenReturn(BigInteger.valueOf(987));
			
			when(familyMapRepo.save(any())).thenReturn(mbenFamilyMapping);
			when(editMapper.identityEditDTOListToMBeneficiaryfamilymappingList(any())).thenReturn(fbMaps);

			
			when(familyMapRepo.findByBenMapIdOrderByBenFamilyMapIdAsc(benMapping.getVanSerialNo())).thenReturn(fmList);
			when(identityRepo.findByBenMapId(any())).thenReturn(idList);
			when(editMapper.identityEditDTOListToMBeneficiaryidentityList(any())).thenReturn(identities);
			when(contactRepo.findIdByVanSerialNoAndVanID(any(), any())).thenReturn(BigInteger.valueOf(987));
			when(editMapper.identityEdiDTOToMBeneficiarycontact(any())).thenReturn(benCon);
			when(addressRepo.findIdByVanSerialNoAndVanID(any(), any())).thenReturn(BigInteger.valueOf(987));
			when(editMapper.identityEditDTOToMBeneficiaryaddress(any())).thenReturn(mbAddr );
			when(detailRepo.findBenDetailsByVanSerialNoAndVanID(any(), any())).thenReturn(mbDetl);
			when(editMapper.identityEditDTOToMBeneficiarydetail(any())).thenReturn(mbDetl);
			when(mappingRepo.findByBenRegIdOrderByBenMapIdAsc(identityEditDTO.getBeneficiaryRegId())).thenReturn(benMapping);
			identityService.editIdentity(identityEditDTO);
		}


		@Test
	public void getBeneficiariesByBenRegIdTest() throws NoResultException, QueryTimeoutException, Exception
		{	
			MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
			mBeneficiarymapping.setBenMapId(new BigInteger("201"));
						
			BeneficiariesDTO dto = new BeneficiariesDTO();
			dto.setBenId(new BigInteger("301"));
			
			doReturn(mBeneficiarymapping).when(benMappingRepo).findByBenRegIdOrderByBenMapIdAsc(Mockito.any(BigInteger.class));
			
			doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
			
			List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesByBenRegId(Mockito.any(BigInteger.class));
			//assertTrue(dtoList.size() > 0);
		}
		
		@Test
		public void getBeneficiariesDeatilsByBenRegIdListTest()
		{
			List<BigInteger> benRegIds = new ArrayList<>();
			benRegIds.add(BigInteger.valueOf(987));
			List<MBeneficiarymapping> benMapIDList =Lists.newArrayList();
			MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
			mBeneficiarymapping.setBenMapId(new BigInteger("201"));
			benMapIDList.add(mBeneficiarymapping);
			//doReturn(benMapIDList).when(benMappingRepo).findAllByBenRegIdOrderByBenMapIdAsc(Mockito.anyListOf(BigInteger.class));
			
			BeneficiariesDTO dto = new BeneficiariesDTO();
			dto.setBenId(new BigInteger("301"));
			doReturn(dto).when(identityMapper).mBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);

			List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesDeatilsByBenRegIdList(benRegIds);

			//assertTrue(dtoList.size() > 0);
		}
		@Test
		public void getBeneficiariesDeatilsByBenRegIdListNullTest()
		{

			//List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
			//assertFalse(dtoList.size() > 0);
		}
		@Test
		public void testcreateIdentity() throws IEMRException {
			IdentityDTO identityDTO = new IdentityDTO();
			identityDTO.setParkingPlaceId(123);
			
			Identity identity = new Identity();
			List<Identity> listOfIdentities=new ArrayList<>();
			listOfIdentities.add(identity);
			identityDTO.setIdentities(listOfIdentities);
			
			List<BenFamilyDTO> fDTOs=new ArrayList<>();
			BenFamilyDTO benFamilyDTO = new BenFamilyDTO();
			benFamilyDTO.setBenFamilyMapId(BigInteger.valueOf(456));
			fDTOs.add(benFamilyDTO);
			identityDTO.setBenFamilyDTOs(fDTOs);
			identityDTO.setIsPermAddrSameAsCurrAddr(true);
			identityDTO.setIsPermAddrSameAsEmerAddr(true);
			identityDTO.setIsEmerAddrSameAsCurrAddr(true);
			identityDTO.setIsEmerAddrSameAsPermAddr(true);
			Address address = new Address();
			address.setAddressValue("Home");
			address.setAddrLine1("R1");
			address.setCountry("India");
			address.setCountryId(1);
			identityDTO.setCurrentAddress(address);
			identityDTO.setEmergencyAddress(address);
			identityDTO.setPermanentAddress(address);
			List<MBeneficiaryregidmapping> findTop10000ByProvisionedAndReserved = new ArrayList<>();
			MBeneficiaryregidmapping mBeneficiaryregidmapping2 = new MBeneficiaryregidmapping();
			mBeneficiaryregidmapping2.setBeneficiaryID(BigInteger.valueOf(987));
			findTop10000ByProvisionedAndReserved.add(mBeneficiaryregidmapping2);
			when(benRegIdMappingRepo.findTop10000ByProvisionedAndReserved(false, false)).thenReturn(findTop10000ByProvisionedAndReserved);
			MBeneficiaryaddress mAddr = new MBeneficiaryaddress();
			when(identityMapper.identityDTOToMBeneficiaryaddress(any())).thenReturn(mAddr);
			when(addressRepo.save(mAddr)).thenReturn(mAddr);
			
			MBeneficiaryconsent beneficiaryconsent = new MBeneficiaryconsent();
			beneficiaryconsent.setBenConsentID(BigInteger.valueOf(987));
			
			when(identityMapper.identityDTOToDefaultMBeneficiaryconsent(any(), anyBoolean(), anyBoolean())).thenReturn(beneficiaryconsent );
			when(consentRepo.save(beneficiaryconsent)).thenReturn(beneficiaryconsent);
			
			MBeneficiarycontact beneficiarycontact=new MBeneficiarycontact();
			when(identityMapper.identityDTOToMBeneficiarycontact(any())).thenReturn(beneficiarycontact);
			when(contactRepo.save(beneficiarycontact)).thenReturn(beneficiarycontact);
			
			MBeneficiarydetail mDetl=new MBeneficiarydetail();
			when(identityMapper.identityDTOToMBeneficiarydetail(any())).thenReturn(mDetl);
			when(detailRepo.save(mDetl)).thenReturn(mDetl);
			
			MBeneficiaryAccount bankOBJ = new MBeneficiaryAccount();
			when(identityMapper.identityDTOToMBeneficiaryAccount(any())).thenReturn(bankOBJ);
			when(accountRepo.save(bankOBJ)).thenReturn(bankOBJ);
			
			MBeneficiaryImage benImageOBJ = new MBeneficiaryImage();
			when(identityMapper.identityDTOToMBeneficiaryImage(any())).thenReturn(benImageOBJ);
			when(imageRepo.save(benImageOBJ)).thenReturn(benImageOBJ);
			
			
			MBeneficiarymapping benMapping = new MBeneficiarymapping();
			when(identityMapper.identityDTOToMBeneficiarymapping(any())).thenReturn(benMapping);
			when(mappingRepo.save(benMapping)).thenReturn(benMapping);
			
			List<MBeneficiaryfamilymapping> fIdenList = new ArrayList<MBeneficiaryfamilymapping>();
			MBeneficiaryfamilymapping mBeneficiaryfamilymapping = new MBeneficiaryfamilymapping();
			mBeneficiaryfamilymapping.setVanID(123);
			fIdenList.add(mBeneficiaryfamilymapping);
			when(identityMapper.identityDTOListToMBeneficiaryfamilymappingList(any())).thenReturn(fIdenList);
			
			when(familyMapRepo.saveAll(anyList())).thenReturn(fIdenList);
			
			MBeneficiaryservicemapping sMap=new MBeneficiaryservicemapping();
			when(identityMapper.identityDTOToMBeneficiaryservicemapping(any())).thenReturn(sMap);
			when(serviceMapRepo.save(sMap)).thenReturn(sMap);
			
			List<MBeneficiaryidentity> mIdenList=new ArrayList<>();
			MBeneficiaryidentity mBeneficiaryidentity2 = new MBeneficiaryidentity();
			
			mIdenList.add(mBeneficiaryidentity2);
			when(identityMapper.identityDTOListToMBeneficiaryidentityList(any())).thenReturn(mIdenList);
			when(identityRepo.save(any())).thenReturn(mBeneficiaryidentity2);
			
			BeneficiaryCreateResp resp=new BeneficiaryCreateResp();
			resp.setBenId(BigInteger.valueOf(987));
			when(partialMapper.mBeneficiarymappingToBeneficiaryCreateResp(any())).thenReturn(resp);
			
			BeneficiaryCreateResp createIdentity = identityService.createIdentity(identityDTO);
			Assert.assertNotNull(createIdentity);
			
		}
		@Test
		public void testgetBeneficiaries() {
			IdentityDTO identityDTO = new IdentityDTO();
			identityService.getBeneficiaries(identityDTO);
		}
		@Test
		public void testgetBeneficiaryByHealthIDAbhaAddress() throws NoResultException, QueryTimeoutException, Exception {
			
			List<BigInteger> list=new ArrayList<>();
			list.add(BigInteger.valueOf(987));
			
			
			List<String> mappinglist=new ArrayList<>();
			List<MBeneficiarymapping> mBeneficiarymappinglist=new ArrayList<>();
			MBeneficiarymapping mBeneficiarymapping = new MBeneficiarymapping();
			mBeneficiarymapping.setBenAccountID(Long.valueOf(987));
			mBeneficiarymappinglist.add(mBeneficiarymapping);
			String mappingJson = new Gson().toJson(mBeneficiarymapping);
			mappinglist.add(mappingJson);
			List<Object[]> listOdObject =new ArrayList<>();
			MBeneficiarymapping[] benMap = new MBeneficiarymapping[1];
			when(mappingRepo.getBenMappingByRegID(any())).thenReturn(listOdObject );
			when(v_BenAdvanceSearchRepo.getBenRegIDByHealthIDAbhaAddress("123")).thenReturn(list);
			identityService.getBeneficiaryByHealthIDAbhaAddress("123");
			
		}
}
