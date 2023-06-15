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
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doReturn;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.QueryTimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.common.identity.domain.Identity;
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


@RunWith(MockitoJUnitRunner.class)
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

		doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(Mockito.mock(IdentitySearchDTO.class));
		assertTrue(benDTOList.size()>0);
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

		doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		
		doReturn(mBeneficiarymapping).when(benMappingRepo).findByBenRegIdOrderByBenMapIdAsc(Mockito.any(BigInteger.class));
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(identitySearchDTO);
		assertTrue(benDTOList.size()>0);
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
		doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		
		List<BeneficiariesDTO> benDTOList=identityService.getBeneficiaries(identitySearchDTO);
		assertTrue(benDTOList.size()>0);
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
		doReturn(benMapList).when(benMappingRepo).findByMBeneficiaryregidmappingOrderByBenMapIdAsc(anyObject());
		doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(Mbeneficiary);

		List<BeneficiariesDTO> bList = identityService.getBeneficiariesByBenId(Mockito.any(BigInteger.class));
		
		assertTrue(bList.size() > 0);
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
		
		doReturn(mappingList).when(benMappingRepo).findByBeneficiaryDetailsByPhoneNumber(anyObject());
		
		BeneficiariesDTO dto = new BeneficiariesDTO();
		dto.setBenId(new BigInteger("301"));
		doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
		List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesByPhoneNum(Mockito.anyString());
		assertTrue(dtoList.size() > 0);
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
		public void getBeneficiariesPartialDeatilsByBenRegIdListTest1()
		{
			List<MBeneficiarymapping> benMapList=Lists.newArrayList();
			MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
			mBeneficiarymapping.setBenRegId(new BigInteger("101"));
			benMapList.add(mBeneficiarymapping);
			doReturn(benMapList).when(benMappingRepo).findAllByBenRegIdOrderByBenMapIdAsc(Mockito.anyListOf(BigInteger.class));
			
			MBeneficiarydetail benDetail=new MBeneficiarydetail();
			benDetail.setBeneficiaryDetailsId(new BigInteger("801"));
			doReturn(benDetail).when(detailRepo).findPartialBeneficiaryDetailByBenRegId(Mockito.any(BigInteger.class));
			BeneficiariesPartialDTO beneficiariesPartialDTO=new BeneficiariesPartialDTO();
			beneficiariesPartialDTO.setBeneficiaryDetailsId(new BigInteger("202"));
			doReturn(beneficiariesPartialDTO).when(partialMapper).MBeneficiarymappingToBeneficiariesPartialDTO(beneficiarymapping);
			
			List<BeneficiariesPartialDTO> dtoList=identityService.getBeneficiariesPartialDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
			assertTrue(dtoList.size()>0);
			
		}
		@Test
		public void getBeneficiariesPartialDeatilsByBenRegIdListTest()
		{
			List<BeneficiariesPartialDTO> dtoList=identityService.getBeneficiariesPartialDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
			assertFalse(dtoList.size()>0);
			
		}
		@Test
		public void reserveIdentity()
		{
			ReserveIdentityDTO reserveIdentityDTO=new ReserveIdentityDTO();
			reserveIdentityDTO.setReserveCount(new Long(100));
			doReturn(new Long(200)).when(benRegIdMappingRepo).countByProviderServiceMapIDAndVehicalNoOrderByBenRegIdAsc(Mockito.anyInt(), Mockito.anyString());
			
			MBeneficiaryregidmapping mBeneficiaryregidmapping=new MBeneficiaryregidmapping();
			doReturn(mBeneficiaryregidmapping).when(benRegIdMappingRepo).findFirstByProviderServiceMapIDAndVehicalNoOrderByBenRegIdAsc(Mockito.anyInt(), Mockito.anyString());
			doReturn(mBeneficiaryregidmapping).when(benRegIdMappingRepo).save(Mockito.any(MBeneficiaryregidmapping.class));

			
			String res=identityService.reserveIdentity(reserveIdentityDTO);
			assertTrue(res.contains("Successfully Completed"));
			
		}
		
		@Test
		public void unReserveIdentity()
		{
			doReturn(new Integer(200)).when(benRegIdMappingRepo).unreserveBeneficiaryIds(Mockito.anyInt(), Mockito.anyString());
			String res=identityService.unReserveIdentity(Mockito.mock(ReserveIdentityDTO.class));
			assertTrue(res.contains("Successfully Completed"));
			
		}

		@Test
		public void editIdentityTest() throws MissingMandatoryFieldsException
		{
			IdentityEditDTO identityEditDTO=new IdentityEditDTO();
			identityEditDTO.setBeneficaryId(new BigInteger("100"));
			MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
			mBeneficiarymapping.setBenMapId(new BigInteger("101"));
			
			doReturn(mBeneficiarymapping).when(benMappingRepo).findByBenRegIdOrderByBenMapIdAsc(Mockito.any(BigInteger.class));
			
			identityEditDTO.setChangeInSelfDetails(true);
			MBeneficiarydetail mBeneficiarydetail=new MBeneficiarydetail();
			mBeneficiarydetail.setBeneficiaryDetailsId(new BigInteger("201"));
			
			mBeneficiarymapping.setMBeneficiarydetail(beneficiarydetail);
			
			doReturn(mBeneficiarydetail).when(editMapper).IdentityEditDTOToMBeneficiarydetail(Mockito.any());

			doReturn(mBeneficiarydetail).when(beneficiarymapping).getMBeneficiarydetail();
			doReturn(new BigInteger("250")).when(beneficiarydetail).getBeneficiaryDetailsId();
			
			List<MBeneficiarydetail> mBeneficiarydetailList=Lists.newArrayList();
			mBeneficiarydetailList.add(mBeneficiarydetail);
			doReturn(mBeneficiarydetailList).when(detailRepo).save(mBeneficiarydetail);
			
			identityEditDTO.setChangeInAddress(true);
			
			List<MBeneficiaryaddress> mBeneficiaryaddressList=Lists.newArrayList();
			MBeneficiaryaddress mBeneficiaryaddress=new MBeneficiaryaddress();
			mBeneficiaryaddress.setBenAddressID(new BigInteger("301"));	
			mBeneficiaryaddressList.add(mBeneficiaryaddress);
			

			doReturn(mBeneficiaryaddress).when(editMapper).IdentityEditDTOToMBeneficiaryaddress(Mockito.any());
			
			
			mBeneficiarymapping.setMBeneficiaryaddress(beneficiaryaddress);
			doReturn(mBeneficiaryaddress).when(beneficiarymapping).getMBeneficiaryaddress();
			doReturn(new BigInteger("901")).when(beneficiaryaddress).getBenAddressID();
			doReturn(mBeneficiaryaddressList).when(addressRepo).save(mBeneficiaryaddress);
			
			identityEditDTO.setChangeInIdentities(true);
			
			List<MBeneficiaryidentity> identityList=Lists.newArrayList();
			MBeneficiaryidentity mBeneficiaryidentity=new MBeneficiaryidentity();
			mBeneficiaryidentity.setBenIdentityId(new BigInteger("786"));
			identityList.add(mBeneficiaryidentity);
			doReturn(identityList).when(editMapper).IdentityEditDTOListToMBeneficiaryidentityList(Mockito.anyListOf(Identity.class));
			doReturn(identityList).when(identityRepo).save(mBeneficiaryidentity);
			
			identityEditDTO.setChangeInContacts(true);
			MBeneficiarycontact contact=new MBeneficiarycontact();
			contact.setBenContactsID(new BigInteger("707"));
			mBeneficiarymapping.setMBeneficiarycontact(contact);
			doReturn(contact).when(beneficiarymapping).getMBeneficiarycontact();
			doReturn(new BigInteger("901")).when(mBeneficiarycontact).getBenContactsID();
			doReturn(contact).when(editMapper).IdentityEdiDTOToMBeneficiarycontact(Mockito.any());
			
			identityEditDTO.setChangeInFamilyDetails(true);
			List<MBeneficiaryfamilymapping> familyMappingList=Lists.newArrayList();
			MBeneficiaryfamilymapping familyMap=new MBeneficiaryfamilymapping();
			familyMap.setBenFamilyMapId(new BigInteger("303"));
			familyMappingList.add(familyMap);
			doReturn(familyMappingList).when(editMapper).IdentityEditDTOListToMBeneficiaryfamilymappingList(Mockito.anyListOf(BenFamilyDTO.class));
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
			
			doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
			
			List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesByBenRegId(Mockito.any(BigInteger.class));
			assertTrue(dtoList.size() > 0);
		}
		
		@Test
		public void getBeneficiariesDeatilsByBenRegIdListTest()
		{
			List<MBeneficiarymapping> benMapIDList =Lists.newArrayList();
			MBeneficiarymapping mBeneficiarymapping=new MBeneficiarymapping();
			mBeneficiarymapping.setBenMapId(new BigInteger("201"));
			benMapIDList.add(mBeneficiarymapping);
			doReturn(benMapIDList).when(benMappingRepo).findAllByBenRegIdOrderByBenMapIdAsc(Mockito.anyListOf(BigInteger.class));
			
			BeneficiariesDTO dto = new BeneficiariesDTO();
			dto.setBenId(new BigInteger("301"));
			doReturn(dto).when(identityMapper).MBeneficiarymappingToBeneficiariesDTO(mBeneficiarymapping);
			List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
			assertTrue(dtoList.size() > 0);
		}
		@Test
		public void getBeneficiariesDeatilsByBenRegIdListNullTest()
		{

			List<BeneficiariesDTO> dtoList=identityService.getBeneficiariesDeatilsByBenRegIdList(Mockito.anyListOf(BigInteger.class));
			assertFalse(dtoList.size() > 0);
		}
}
