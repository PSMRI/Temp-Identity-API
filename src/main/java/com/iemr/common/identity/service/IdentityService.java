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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.QueryTimeoutException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.LongSerializationPolicy;
import com.iemr.common.identity.data.rmnch.RMNCHBeneficiaryDetailsRmnch;
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
import com.iemr.common.identity.domain.V_BenAdvanceSearch;
import com.iemr.common.identity.dto.AbhaAddressDTO;
import com.iemr.common.identity.dto.BenIdImportDTO;
import com.iemr.common.identity.dto.BeneficiariesDTO;
import com.iemr.common.identity.dto.BeneficiariesPartialDTO;
import com.iemr.common.identity.dto.BeneficiaryCreateResp;
import com.iemr.common.identity.dto.IdentityDTO;
import com.iemr.common.identity.dto.IdentityEditDTO;
import com.iemr.common.identity.dto.IdentitySearchDTO;
import com.iemr.common.identity.dto.ReserveIdentityDTO;
import com.iemr.common.identity.exception.MissingMandatoryFieldsException;
import com.iemr.common.identity.mapper.BenIdImportMapper;
import com.iemr.common.identity.mapper.IdentityEditMapper;
import com.iemr.common.identity.mapper.IdentityMapper;
import com.iemr.common.identity.mapper.IdentityPartialMapper;
import com.iemr.common.identity.mapper.IdentitySearchMapper;
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
import com.iemr.common.identity.repo.rmnch.RMNCHBeneficiaryDetailsRmnchRepo;
import com.iemr.common.identity.utils.exception.IEMRException;
import com.iemr.common.identity.utils.mapper.OutputMapper;
import com.iemr.common.identity.utils.response.OutputResponse;

@Service
public class IdentityService {
	private static final Logger logger = LoggerFactory.getLogger(IdentityService.class);
	// private ExecutorService executor = Executors
	// .newFixedThreadPool(5)/* .newCachedThreadPool() */;

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);

	}

	@Autowired
	private RMNCHBeneficiaryDetailsRmnchRepo rMNCHBeneficiaryDetailsRmnchRepo;

	@Autowired
	IdentityMapper mapper;
	@Autowired
	IdentityEditMapper editMapper;
	@Autowired
	IdentitySearchMapper searchMapper;
	@Autowired
	private IdentityPartialMapper partialMapper;
	@Autowired
	BenAddressRepo addressRepo;
	@Autowired
	BenConsentRepo consentRepo;
	@Autowired
	BenContactRepo contactRepo;
	@Autowired
	BenDataAccessRepo accessRepo;
	@Autowired
	BenDetailRepo detailRepo;
	@Autowired
	BenFamilyMappingRepo familyMapRepo;
	@Autowired
	BenIdentityRepo identityRepo;
	@Autowired
	BenMappingRepo mappingRepo;
	@Autowired
	BenRegIdMappingRepo regIdRepo;
	@Autowired
	BenServiceMappingRepo serviceMapRepo;
	@Autowired
	MBeneficiaryAccountRepo accountRepo;
	@Autowired
	MBeneficiaryImageRepo imageRepo;
	@Autowired
	private BenIdImportMapper benIdImportMapper;
	@Autowired
	private V_BenAdvanceSearchRepo v_BenAdvanceSearchRepo;

	public void getBenAdress() {
		logger.debug("Address count: " + addressRepo.count());
		logger.debug(
				"Address By Address: " + addressRepo.findByBenAddressIDOrderByBenAddressIDAsc(new BigInteger("12")));
		logger.debug("Consent count: " + consentRepo.count());
		logger.debug("Consent By Id: " + consentRepo.findByBenConsentIDOrderByBenConsentIDAsc(new BigInteger("12")));
		logger.debug("Contact count: " + contactRepo.count());
		logger.debug("Contact By Id: " + contactRepo.findByBenContactsIDOrderByBenContactsIDAsc(new BigInteger("12")));
		logger.debug("Data Access count: " + accessRepo.count());
		logger.debug("Data Access By Id: " + accessRepo.findByAccessIdOrderByAccessIdAsc(new BigInteger("12")));
		logger.debug("Detail count: " + detailRepo.count());
		logger.debug("Detail By Address: "
				+ detailRepo.findByBeneficiaryDetailsIdOrderByBeneficiaryDetailsIdAsc(new BigInteger("12")));
		logger.debug("FamilyMap count: " + familyMapRepo.count());
		logger.debug(
				"FamilyMap By Id: " + familyMapRepo.findByBenFamilyMapIdOrderByBenFamilyMapIdAsc(new BigInteger("12")));
		logger.debug("Identity count: " + identityRepo.count());
		logger.debug("Identity By Id: " + identityRepo.findByBenIdentityId(new BigInteger("12")));
		logger.debug("Mapping count: " + mappingRepo.count());
		logger.debug("Mapping By Id: " + mappingRepo.findByBenMapIdOrderByBenMapIdAsc(new BigInteger("12")));
	}

	/**
	 * 
	 * @param searchDTO
	 * @return
	 */
	public List<BeneficiariesDTO> getBeneficiaries(IdentitySearchDTO searchDTO)
			throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();

		/**
		 * if beneficiary Id present
		 */
		if (searchDTO.getBeneficiaryId() != null) {
			logger.info("getting beneficiaries by ID for " + searchDTO.getBeneficiaryId());
			List<BeneficiariesDTO> list1 = this.getBeneficiariesByBenId(searchDTO.getBeneficiaryId());
			return list1;
		}

		/**
		 * if beneficiary Reg Id present
		 */
		if (searchDTO.getBeneficiaryRegId() != null) {
			logger.info("getting beneficiaries by reg ID for " + searchDTO.getBeneficiaryRegId());
			List<BeneficiariesDTO> list2 = this.getBeneficiariesByBenRegId(searchDTO.getBeneficiaryRegId());
			return list2;
		}

		/**
		 * if beneficiary Reg Id present
		 */
		if (searchDTO.getContactNumber() != null) {
			logger.info("getting beneficiaries by contact no for " + searchDTO.getContactNumber());
			List<BeneficiariesDTO> list3 = this.getBeneficiariesByPhoneNum(searchDTO.getContactNumber());
			if (list3.size() > 0 && searchDTO.getIsD2D() != null && searchDTO.getIsD2D() == true) {

				for (int i = 0; i < list3.size(); i++) {
					if (searchDTO.getFirstName() != null) {
						if (list3.get(i) == null || list3.get(i).getBeneficiaryDetails() == null
								|| list3.get(i).getBeneficiaryDetails().getFirstName() == null
								|| !list3.get(i).getBeneficiaryDetails().getFirstName()
										.equalsIgnoreCase(searchDTO.getFirstName())) {
							list3.remove(i);
							i--;

							continue;
						}

					}
					if (searchDTO.getLastName() != null) {
						if (list3.get(i) == null || list3.get(i).getBeneficiaryDetails() == null
								|| list3.get(i).getBeneficiaryDetails().getLastName() == null
								|| !list3.get(i).getBeneficiaryDetails().getLastName()
										.equalsIgnoreCase(searchDTO.getLastName())) {
							list3.remove(i);
							i--;

							continue;
						}
					}

					if (searchDTO.getGenderId() != null) {
						if (list3.get(i) == null || list3.get(i).getBeneficiaryDetails() == null
								|| list3.get(i).getBeneficiaryDetails().getGenderId() == null || !list3.get(i)
										.getBeneficiaryDetails().getGenderId().equals(searchDTO.getGenderId())) {

							list3.remove(i);
							i--;
							continue;
						}
					}
					if (searchDTO.getHouseHoldID() != null) {
						if (list3.get(i) == null || list3.get(i).getBeneficiaryDetails() == null
								|| list3.get(i).getBeneficiaryDetails().getHouseHoldID() == null || !list3.get(i)
										.getBeneficiaryDetails().getHouseHoldID().equals(searchDTO.getHouseHoldID())) {

							list3.remove(i);
							i--;
							continue;
						}
					}

					if (searchDTO.getCurrentAddress().getStateId() != null) {
						if (list3.get(i) == null || list3.get(i).getCurrentAddress() == null
								|| list3.get(i).getCurrentAddress().getStateId() == null
								|| !list3.get(i).getCurrentAddress().getStateId()
										.equals(searchDTO.getCurrentAddress().getStateId())) {

							list3.remove(i);
							i--;
							continue;
						}
					}

					if (searchDTO.getCurrentAddress().getDistrictId() != null) {
						if (list3.get(i) == null || list3.get(i).getCurrentAddress() == null
								|| list3.get(i).getCurrentAddress().getDistrictId() == null
								|| !list3.get(i).getCurrentAddress().getDistrictId()
										.equals(searchDTO.getCurrentAddress().getDistrictId())) {

							list3.remove(i);
							i--;
							continue;
						}
					}

					if (searchDTO.getCurrentAddress().getVillageId() != null) {
						if (list3.get(i) == null || list3.get(i).getCurrentAddress() == null
								|| list3.get(i).getCurrentAddress().getVillageId() == null
								|| !list3.get(i).getCurrentAddress().getVillageId()
										.equals(searchDTO.getCurrentAddress().getVillageId())) {

							list3.remove(i);
							i--;
							continue;
						}
					}

				}
			}
			return list3;
		}

		/**
		 * New logic for advance search, 03-10-2018
		 */
		List<V_BenAdvanceSearch> tmpList = mappingRepo.dynamicFilterSearchNew(searchDTO);
		for (V_BenAdvanceSearch obj : tmpList) {
			list.add(this.getBeneficiariesDTO(this.getBeneficiariesDTONew1(obj)));
			logger.debug("benMapId: " + obj.getBenMapID());
		}
		/**
		 * End
		 */

		return list;
	}

	/**
	 * 
	 * Check which parameters available Get BenMapID based on the parameter/set of
	 * parameters Use BenMapID to retrieve all data for a Beneficiary
	 * 
	 * @param benId
	 * @return
	 */
	public List<BeneficiariesDTO> getBeneficiariesByBenId(BigInteger benId)
			throws NoResultException, QueryTimeoutException, Exception {
		logger.info("IdentityService.getBeneficiariesByBenId - start, beneficiaryID : " + benId);
		List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();

		MBeneficiaryregidmapping regId = regIdRepo.findByBeneficiaryID(benId);

		if (regId != null && regId.getBenRegId() != null) {
			List<Object[]> benMapObjArr = mappingRepo.getBenMappingByRegID(regId.getBenRegId());

			// new logic, 27-08-2018
			if (benMapObjArr != null && benMapObjArr.size() > 0) {
				MBeneficiarymapping benMap = this.getBeneficiariesDTONew(benMapObjArr.get(0));
				list.add(this.getBeneficiariesDTO(benMap));
			}
		}
		logger.info("benMap size " + (list.size() == 0 ? "No Beneficiary Found" : list.size()));
		// end new logic

		logger.info("IdentityService.getBeneficiariesByBenId - end - beneficiaryID : " + benId);

		return list;
	}

	/**
	 * 
	 * @param BenRegId
	 * @return
	 */
	public List<BeneficiariesDTO> getBeneficiariesByBenRegId(BigInteger benRegId)
			throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();
		logger.info("IdentityService.getBeneficiariesByBenRegId - start for benRegId " + benRegId);
		try {
			// new logic, 27-09-2018
			List<Object[]> benMapObjArr = mappingRepo.getBenMappingByRegID(benRegId);

			// new logic, 27-08-2018
			if (benMapObjArr != null && benMapObjArr.size() > 0) {
				MBeneficiarymapping benMap = this.getBeneficiariesDTONew(benMapObjArr.get(0));
				list.add(this.getBeneficiariesDTO(benMap));
			}
			logger.info("benMap size" + (list.size() == 0 ? "No Beneficiary Found" : list.size()));
			// end new logic

			logger.info("IdentityService.getBeneficiariesByBenRegId - end for benRegId " + benRegId);
		} catch (Exception e) {
			logger.error("error in beneficiary search for beneficiary reg id : " + benRegId + " error : "
					+ e.getLocalizedMessage());
		}

		return list;
	}

	/**
	 * 
	 * Check which parameters available Get BenMapID based on the parameter/set of
	 * parameters Use BenMapID to retrieve all data for a Beneficiary
	 * 
	 * @param phoneNum
	 * @return
	 */

	public List<BeneficiariesDTO> getBeneficiariesByPhoneNum(String phoneNum)
			throws NoResultException, QueryTimeoutException, Exception {
		// new logic, 27-09-2018
		List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();
		try {
			List<MBeneficiarycontact> benContact = contactRepo.findByAnyPhoneNum(phoneNum);

			logger.info(benContact.size() + " contacts found for phone number " + phoneNum);

			List<Object[]> benMapObjArr = new ArrayList<>();

			for (MBeneficiarycontact benContactOBJ : benContact) {
				benMapObjArr.addAll(mappingRepo.getBenMappingByBenContactIdListNew(benContactOBJ.getVanSerialNo(),
						benContactOBJ.getVanID()));
			}

			for (Object[] benMapOBJ : benMapObjArr) {
				list.add(this.getBeneficiariesDTO(this.getBeneficiariesDTONew(benMapOBJ)));
			}

		} catch (Exception e) {
			logger.error(
					"error in beneficiary search for phone no : " + phoneNum + " error : " + e.getLocalizedMessage());
		}

		logger.info("IdentityService.getBeneficiariesByPhoneNum - end");
		// end
		return list;
	}

	/***
	 * 
	 * Search beneficiary by healthID / ABHA address
	 * 
	 * @param healthID
	 * @return
	 * @throws NoResultException
	 * @throws QueryTimeoutException
	 * @throws Exception
	 */

	public List<BeneficiariesDTO> getBeneficiaryByHealthID_AbhaAddress(String healthID)
			throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> beneficiaryList = new ArrayList<BeneficiariesDTO>();
		try {
			List<BigInteger> regIDList = v_BenAdvanceSearchRepo.getBenRegIDByHealthID_AbhaAddress(healthID);
			if (regIDList != null && regIDList.size() > 0) {
				for (BigInteger benRegID : regIDList) {
					if (benRegID != null) {
						List<BeneficiariesDTO> searchList = this.getBeneficiariesByBenRegId(benRegID);
						beneficiaryList.addAll(searchList);
					}
				}
			}
		} catch (Exception e) {
			logger.error("error in beneficiary search for health ID / ABHA Address : " + healthID + " error : "
					+ e.getLocalizedMessage());
		}
		return beneficiaryList;
	}

	/***
	 * 
	 * Search beneficiary by healthIDNo / ABHA ID No
	 * 
	 * @param healthIDNo
	 * @return
	 * @throws NoResultException
	 * @throws QueryTimeoutException
	 * @throws Exception
	 */

	public List<BeneficiariesDTO> getBeneficiaryByHealthIDNo_AbhaIdNo(String healthIDNo)
			throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> beneficiaryList = new ArrayList<BeneficiariesDTO>();
		try {
			List<BigInteger> regIDList = v_BenAdvanceSearchRepo.getBenRegIDByHealthIDNo_AbhaIdNo(healthIDNo);
			if (regIDList != null && regIDList.size() > 0) {
				for (BigInteger benRegID : regIDList) {
					if (benRegID != null) {
						List<BeneficiariesDTO> searchList = this.getBeneficiariesByBenRegId(benRegID);
						beneficiaryList.addAll(searchList);
					}
				}
			}
		} catch (Exception e) {
			logger.error("error in beneficiary search for health ID No / ABHA ID No : " + healthIDNo + " error : "
					+ e.getLocalizedMessage());
		}
		return beneficiaryList;
	}

	public List<BeneficiariesDTO> searhBeneficiaryByFamilyId(String familyId)
			throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> beneficiaryList = new ArrayList<BeneficiariesDTO>();
		try {

			// find benmap ids
			List<Object[]> benMapObjArr = new ArrayList<>();
			List<BigInteger> benDetailsVanSerialNoList = new ArrayList<>();
			int vanID = 0;

			List<MBeneficiarydetail> benDetailsList = detailRepo.searchByFamilyId(familyId);

			if (benDetailsList == null || benDetailsList.size() == 0)
				return beneficiaryList;
			else {
				// considering as of now family creation is possible through facility modules
				// only
				vanID = benDetailsList.get(0).getVanID();

				for (MBeneficiarydetail benDetails : benDetailsList) {
					benDetailsVanSerialNoList.add(benDetails.getVanSerialNo());
				}

				benMapObjArr = mappingRepo.getBenMappingByBenDetailsIds(benDetailsVanSerialNoList, vanID);

				for (Object[] benMapOBJ : benMapObjArr) {
					beneficiaryList.add(this.getBeneficiariesDTO(this.getBeneficiariesDTONew(benMapOBJ)));
				}

			}

		} catch (Exception e) {
			logger.error(
					"error in beneficiary search for familyId : " + familyId + " error : " + e.getLocalizedMessage());
		}
		return beneficiaryList;
	}

	public List<BeneficiariesDTO> searhBeneficiaryByGovIdentity(String identity)
			throws NoResultException, QueryTimeoutException, Exception {
		List<BeneficiariesDTO> beneficiaryList = new ArrayList<BeneficiariesDTO>();
		try {

			List<Object[]> benMapObjArr = new ArrayList<>();

			// find identity no
			List<MBeneficiaryidentity> benIdentityList = identityRepo.searchByIdentityNo(identity);

			// find benmap ids
			if (benIdentityList == null || benIdentityList.size() == 0)
				return beneficiaryList;
			else {
				for (MBeneficiaryidentity identityObj : benIdentityList) {
					benMapObjArr.addAll(
							mappingRepo.getBenMappingByVanSerialNo(identityObj.getBenMapId(), identityObj.getVanID()));
				}

				for (Object[] benMapOBJ : benMapObjArr) {
					beneficiaryList.add(this.getBeneficiariesDTO(this.getBeneficiariesDTONew(benMapOBJ)));
				}

			}

		} catch (Exception e) {
			logger.error("error in beneficiary search for gov identity : " + identity + " error : "
					+ e.getLocalizedMessage());
		}
		return beneficiaryList;
	}

	private MBeneficiarymapping getBeneficiariesDTONew(Object[] benMapArr) {
		MBeneficiarymapping benMapOBJ = new MBeneficiarymapping();

		benMapOBJ.setBenMapId(getBigIntegerValueFromObject(benMapArr[0]));
		benMapOBJ.setCreatedBy(String.valueOf(benMapArr[10]));
		benMapOBJ.setCreatedDate((Timestamp) benMapArr[11]);

		if (benMapArr != null && benMapArr.length == 12 && benMapArr[8] != null && benMapArr[9] != null) {

			RMNCHBeneficiaryDetailsRmnch obj = rMNCHBeneficiaryDetailsRmnchRepo
					.getByRegID(((BigInteger) benMapArr[5]).longValue());
			if (obj != null) {
				if (obj.getHouseoldId() != null)
					benMapOBJ.setHouseHoldID(obj.getHouseoldId());
				if (obj.getGuidelineId() != null)
					benMapOBJ.setGuideLineID(obj.getGuidelineId());
				if (obj.getRchid() != null)
					benMapOBJ.setRchID(obj.getRchid());
			}

			benMapOBJ.setMBeneficiaryaddress(addressRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[1]), (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiaryconsent(consentRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[2]), (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiarycontact(contactRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[3]), (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiarydetail(detailRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[4]), (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiaryregidmapping(regIdRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[5]), (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiaryImage(
					imageRepo.getWith_vanSerialNo_vanID((Long) benMapArr[6], (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiaryAccount(accountRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[7]), (Integer) benMapArr[8]));

			// family
//			benMapOBJ.setMBeneficiaryfamilymappings(
//					familyMapRepo.findByBenMapIdOrderByBenFamilyMapIdAsc(getBigIntegerValueFromObject(benMapArr[9])));
			benMapOBJ.setMBeneficiaryfamilymappings(familyMapRepo.findByBenMapIdAndVanIDOrderByBenFamilyMapIdAsc(
					getBigIntegerValueFromObject(benMapArr[9]), (Integer) benMapArr[8]));
//			benMapOBJ
//					.setMBeneficiaryidentities(identityRepo.findByBenMapId(getBigIntegerValueFromObject(benMapArr[9])));
			benMapOBJ.setMBeneficiaryidentities(identityRepo
					.findByBenMapIdAndVanID(getBigIntegerValueFromObject(benMapArr[9]), (Integer) benMapArr[8]));

		}
		return benMapOBJ;
	}

	private MBeneficiarymapping getBeneficiariesDTONewPartial(Object[] benMapArr) {
		MBeneficiarymapping benMapOBJ = new MBeneficiarymapping();

		benMapOBJ.setBenMapId(getBigIntegerValueFromObject(benMapArr[0]));
		benMapOBJ.setCreatedBy(String.valueOf(benMapArr[10]));
		benMapOBJ.setCreatedDate((Timestamp) benMapArr[11]);

		if (benMapArr != null && benMapArr.length == 12 && benMapArr[8] != null && benMapArr[9] != null) {

			benMapOBJ.setMBeneficiarydetail(detailRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[4]), (Integer) benMapArr[8]));
			benMapOBJ.setMBeneficiaryregidmapping(regIdRepo
					.getWith_vanSerialNo_vanID(getBigIntegerValueFromObject(benMapArr[5]), (Integer) benMapArr[8]));
		}
		return benMapOBJ;
	}

	// 03-10-2018
	// get ben mapping object from v_benadvancesearch
	private MBeneficiarymapping getBeneficiariesDTONew1(V_BenAdvanceSearch benAdvanceSearchOBJ) {
		MBeneficiarymapping benMapOBJ = new MBeneficiarymapping();

		// for createdBy & createdDate
		if (benAdvanceSearchOBJ != null) {
			MBeneficiarydetail benDetailsOBJ = detailRepo
					.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenDetailsID(), benAdvanceSearchOBJ.getVanID());

			if (benAdvanceSearchOBJ.getHouseHoldID() != null)
				benMapOBJ.setHouseHoldID(benAdvanceSearchOBJ.getHouseHoldID());
			if (benAdvanceSearchOBJ.getGuideLineID() != null)
				benMapOBJ.setGuideLineID(benAdvanceSearchOBJ.getGuideLineID());
			if (benAdvanceSearchOBJ.getRchID() != null)
				benMapOBJ.setRchID(benAdvanceSearchOBJ.getRchID());

			benMapOBJ.setBenMapId(benAdvanceSearchOBJ.getBenMapID());
			benMapOBJ.setCreatedBy(benDetailsOBJ.getCreatedBy());
			benMapOBJ.setCreatedDate(benDetailsOBJ.getCreatedDate());

			benMapOBJ.setMBeneficiaryaddress(addressRepo
					.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenAddressID(), benAdvanceSearchOBJ.getVanID()));
			benMapOBJ.setMBeneficiaryconsent(consentRepo
					.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenConsentID(), benAdvanceSearchOBJ.getVanID()));
			benMapOBJ.setMBeneficiarycontact(contactRepo
					.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenContactID(), benAdvanceSearchOBJ.getVanID()));
			benMapOBJ.setMBeneficiarydetail(benDetailsOBJ);
			benMapOBJ.setMBeneficiaryregidmapping(regIdRepo.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenRegID(),
					benAdvanceSearchOBJ.getVanID()));
			benMapOBJ.setMBeneficiaryImage(imageRepo.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenImageID(),
					benAdvanceSearchOBJ.getVanID()));
			benMapOBJ.setMBeneficiaryAccount(accountRepo
					.getWith_vanSerialNo_vanID(benAdvanceSearchOBJ.getBenAccountID(), benAdvanceSearchOBJ.getVanID()));

			benMapOBJ.setMBeneficiaryfamilymappings(
					familyMapRepo.findByBenMapIdOrderByBenFamilyMapIdAsc(benAdvanceSearchOBJ.getVanSerialNo()));
			benMapOBJ.setMBeneficiaryidentities(identityRepo.findByBenMapId(benAdvanceSearchOBJ.getVanSerialNo()));
		}

		return benMapOBJ;
	}

	private BigInteger getBigIntegerValueFromObject(Object value) {
		BigInteger ret = null;
		if (value != null) {
			if (value instanceof BigInteger) {
				ret = (BigInteger) value;
			} else if (value instanceof String) {
				ret = new BigInteger((String) value);
			} else if (value instanceof BigDecimal) {
				ret = ((BigDecimal) value).toBigInteger();
			} else if (value instanceof Number) {
				ret = BigInteger.valueOf(((Number) value).longValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigInteger.");
			}
		} else
			throw new ClassCastException("given value is null");
		return ret;
	}

	/**
	 * The following parameters can be changed/edited once created: - First Name -
	 * Middle Name - Last Name - DOB/Age - Address (Current, Permanent, Emergency) -
	 * Contact Numbers/Email Ids - Spouse Name - Preferred Num - Preferred SMS Num -
	 * Email Id - Identity
	 * 
	 * Following changes need Additional Authorization - First Name - Middle Name -
	 * Last Name - Father Name - Spouse Name - Identity
	 *
	 * @param identity
	 * @return
	 * @throws MissingMandatoryFieldsException
	 */
	public void editIdentity(IdentityEditDTO identity) throws MissingMandatoryFieldsException {
		logger.info("IdentityService.editIdentity - start");
		if (identity.getBeneficiaryRegId() == null && null == identity.getBeneficaryId()) {
			throw new MissingMandatoryFieldsException("Either of BeneficiaryID or Beneficiary Reg Id is mandatory.");
		}

		// SUNIL TODO: Logic for the various Edit scenarios goes here

		MBeneficiarymapping benMapping = mappingRepo.findByBenRegIdOrderByBenMapIdAsc(identity.getBeneficiaryRegId());

		// change in self details is implement here and other details here
		logger.debug("identity.getChangeInSelfDetails = " + identity.getChangeInSelfDetails());
		logger.debug("identity.getChangeInOtherDetails = " + identity.getChangeInOtherDetails());
		logger.debug("identity.getChangeInAssociations = " + identity.getChangeInAssociations());
		if (Boolean.TRUE.equals(identity.getChangeInSelfDetails())
				|| Boolean.TRUE.equals(identity.getChangeInOtherDetails())
				|| Boolean.TRUE.equals(identity.getChangeInAssociations())) {

			// MBeneficiarydetail mbDetl =
			// detailRepo.findOne(benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId());
			MBeneficiarydetail mbDetl = editMapper.IdentityEditDTOToMBeneficiarydetail(identity);
			/**
			 * new logic for data sync, 26-09-2018
			 */
			// next commented statement is old one
			// mbDetl.setBeneficiaryDetailsId(benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId());

			// getting correct beneficiaryDetailsId by passing vanSerialNo & vanID
			MBeneficiarydetail benDetails = detailRepo.findBenDetailsByVanSerialNoAndVanID(
					benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId(), benMapping.getVanID());
			// next statement is new one, setting correct beneficiaryDetailsId
			if (benDetails != null) {
				mbDetl.setBeneficiaryDetailsId(benDetails.getBeneficiaryDetailsId());
				if (benDetails.getFamilyId() != null)
					mbDetl.setFamilyId(benDetails.getFamilyId());
				if (benDetails.getHeadOfFamily_RelationID() != null)
					mbDetl.setHeadOfFamily_RelationID(benDetails.getHeadOfFamily_RelationID());
				if (benDetails.getHeadOfFamily_Relation() != null)
					mbDetl.setHeadOfFamily_Relation(benDetails.getHeadOfFamily_Relation());
				if (benDetails.getOther() != null)
					mbDetl.setOther(benDetails.getOther());
			} else
				throw new MissingMandatoryFieldsException("Either of vanSerialNO or vanID is missing.");

			/**
			 * END
			 */

			// old logic
			// mbDetl.setBeneficiaryDetailsId(benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId());
			logger.debug("Beneficiary details to update = " + new OutputMapper().gson().toJson(mbDetl));
			detailRepo.save(mbDetl);
		}

		// edition in current emergency and permanent is implement below
		logger.debug("identity.getChangeInAddress = " + identity.getChangeInAddress());
		if (Boolean.TRUE.equals(identity.getChangeInAddress())) {

			MBeneficiaryaddress mbAddr = editMapper.IdentityEditDTOToMBeneficiaryaddress(identity);

			/**
			 * new logic for data sync, 26-09-2018
			 */
			// next commented statement is old one
			// mbAddr.setBenAddressID(benMapping.getMBeneficiaryaddress().getBenAddressID());

			// getting correct beneficiaryDetailsId by passing vanSerialNo & vanID
			BigInteger benAddressID = addressRepo.findIdByVanSerialNoAndVanID(
					benMapping.getMBeneficiaryaddress().getBenAddressID(), benMapping.getVanID());
			// next statement is new one, setting correct beneficiaryDetailsId
			if (benAddressID != null)
				mbAddr.setBenAddressID(benAddressID);
			else
				throw new MissingMandatoryFieldsException("Either of vanSerialNO or vanID is missing.");

			/**
			 * END
			 */

			// old logic
			// mbAddr.setBenAddressID(benMapping.getMBeneficiaryaddress().getBenAddressID());
			logger.debug("Beneficiary address to update = " + OutputMapper.gson().toJson(mbAddr));
			addressRepo.save(mbAddr);
		}

		// edition in beneficiary contacts is updated here
		logger.debug("identity.getChangeInContacts = " + identity.getChangeInContacts());
		if (Boolean.TRUE.equals(identity.getChangeInContacts())) {

			MBeneficiarycontact benCon = editMapper.IdentityEdiDTOToMBeneficiarycontact(identity);

			/**
			 * new logic for data sync, 26-09-2018
			 */
			// next commented statement is old one
			// benCon.setBenContactsID(benMapping.getMBeneficiarycontact().getBenContactsID());

			// getting correct beneficiaryDetailsId by passing vanSerialNo & vanID
			BigInteger benContactsID = contactRepo.findIdByVanSerialNoAndVanID(
					benMapping.getMBeneficiarycontact().getBenContactsID(), benMapping.getVanID());
			// next statement is new one, setting correct beneficiaryDetailsId
			if (benContactsID != null)
				benCon.setBenContactsID(benContactsID);
			else
				throw new MissingMandatoryFieldsException("Either of vanSerialNO or vanID is missing.");

			/**
			 * END
			 */

			logger.debug("Beneficiary contact to update = " + OutputMapper.gson().toJson(benCon));
			// benCon.setBenContactsID(benMapping.getMBeneficiarycontact().getBenContactsID());
			contactRepo.save(benCon);
		}

		// change in identities are added here
		logger.debug("identity.getChangeInIdentities = " + identity.getChangeInIdentities());
		if (Boolean.TRUE.equals(identity.getChangeInIdentities())) {

			MBeneficiaryidentity beneficiaryidentity;
			List<MBeneficiaryidentity> identities = editMapper
					.IdentityEditDTOListToMBeneficiaryidentityList(identity.getIdentities());
			logger.debug("identities to upsert = " + OutputMapper.gson().toJson(identities));

			// old logic for getting beneficiary identities, 26-09-2018
			// List<MBeneficiaryidentity> idList =
			// identityRepo.findByBenMapId(benMapping.getBenMapId());

			// new logic for getting beneficiary identities, 26-09-2018
			List<MBeneficiaryidentity> idList = identityRepo.findByBenMapId(benMapping.getVanSerialNo());

			logger.debug("existing identies = " + OutputMapper.gson().toJson(idList));
			ListIterator<MBeneficiaryidentity> iterator = identities.listIterator();
			int index = 0;
			while (iterator.hasNext()) {
				beneficiaryidentity = iterator.next();

				// old logic, 26-09-2018
				// beneficiaryidentity.setBenMapId(benMapping.getBenMapId());

				// new logic, 26-09-2018
				beneficiaryidentity.setBenMapId(benMapping.getVanSerialNo());
				logger.debug("Beneficiary identity to update = " + OutputMapper.gson().toJson(beneficiaryidentity));
				if (index < idList.size() && beneficiaryidentity.getBenIdentityId() == null) {
					beneficiaryidentity.setBenIdentityId(idList.get(index).getBenIdentityId());
					// identityRepo.save(beneficiaryidentity);
				}

				// new code to set vanID & parkingPlaceID for new record, 26-09-2018
				if (index >= idList.size() && beneficiaryidentity.getBenIdentityId() == null) {
					beneficiaryidentity.setVanID(benMapping.getVanID());
					beneficiaryidentity.setParkingPlaceID(benMapping.getParkingPlaceID());
				}
				// else
				// {
				/**
				 * add vanID & parkingPlaceID for data sync
				 */
				// if (identity != null && identity.getVanID() != null)
				// beneficiaryidentity.setVanID(identity.getVanID());
				// if (identity != null && identity.getParkingPlaceId() != null)
				// beneficiaryidentity.setParkingPlaceID(identity.getParkingPlaceId());
				/**
				 * END
				 */

				// old logic, 26-09-2018
				// identityRepo.save(beneficiaryidentity);

				// new logic, 26-09-2018
				MBeneficiaryidentity m = identityRepo.save(beneficiaryidentity);

				// new code, update van serial no for new entry, 26-09-2018
				if (index >= idList.size() && beneficiaryidentity.getBenIdentityId() == null) {
					int i8 = identityRepo.updateVanSerialNo(m.getBenIdentityId());
				}

				// }
				index++;
			}
		}

		// change other details are added here *** commented cause all details
		// are
		// available in ben details
		// if(identity.getChangeInOtherDetails()){
		// }

		// family detail changes are performing here
		logger.debug("identity.getChangeInFamilyDetails = " + identity.getChangeInFamilyDetails());
		if (Boolean.TRUE.equals(identity.getChangeInFamilyDetails())) {
			List<MBeneficiaryfamilymapping> fbMaps = editMapper
					.IdentityEditDTOListToMBeneficiaryfamilymappingList(identity.getBenFamilyDTOs());

			logger.debug("family map to upsert = " + OutputMapper.gson().toJson(fbMaps));

			// old logic, 26-09-2018
			// List<MBeneficiaryfamilymapping> fmList = familyMapRepo
			// .findByBenMapIdOrderByBenFamilyMapIdAsc(benMapping.getBenMapId());

			// new logic, 26-09-2018
			List<MBeneficiaryfamilymapping> fmList = familyMapRepo
					.findByBenMapIdOrderByBenFamilyMapIdAsc(benMapping.getVanSerialNo());

			logger.debug("family map stored = " + OutputMapper.gson().toJson(fmList));
			ListIterator<MBeneficiaryfamilymapping> iterator = fbMaps.listIterator();
			MBeneficiaryfamilymapping familymapping;
			int index = 0;
			while (iterator.hasNext()) {

				familymapping = iterator.next();
				// old logic, 26-09-2018
				// familymapping.setBenMapId(benMapping.getBenMapId());

				// new logic, 26-09-2018
				familymapping.setBenMapId(benMapping.getVanSerialNo());

				logger.debug("family mapping to update = " + OutputMapper.gson().toJson(familymapping));
				if (index < fmList.size()) {
					familymapping.setBenFamilyMapId(fmList.get(index).getBenFamilyMapId());
				}

				if (index >= fmList.size() && familymapping.getBenFamilyMapId() == null) {
					familymapping.setVanID(benMapping.getVanID());
					familymapping.setParkingPlaceID(benMapping.getParkingPlaceID());
				}

				// old logic, 26-09-2018
				// familyMapRepo.save(familymapping);

				// new logic, 26-09-2018
				MBeneficiaryfamilymapping m = familyMapRepo.save(familymapping);

				// new code, update van serial no for new entry, 26-09-2018
				if (familymapping.getBenFamilyMapId() == null) {
					int i8 = familyMapRepo.updateVanSerialNo(m.getBenFamilyMapId());
				}

				index++;
			}
		}

		// start
		// Feature used in outreach
		if (Boolean.TRUE.equals(identity.getChangeInBankDetails())) {
			MBeneficiaryAccount beneficiaryAccount = editMapper.identityEditDTOToMBeneficiaryAccount(identity);

			/**
			 * new logic for data sync, 26-09-2018
			 */
			// getting correct beneficiaryDetailsId by passing vanSerialNo & vanID
			BigInteger benAccountID = accountRepo.findIdByVanSerialNoAndVanID(
					benMapping.getMBeneficiaryAccount().getBenAccountID(), benMapping.getVanID());
			// next statement is new one, setting correct beneficiaryDetailsId
			if (benAccountID != null)
				beneficiaryAccount.setBenAccountID(benAccountID);
			else
				throw new MissingMandatoryFieldsException("Either of vanSerialNO or vanID is missing.");

			/**
			 * END
			 */

			logger.debug("Account to upsert = " + OutputMapper.gson().toJson(beneficiaryAccount));
			beneficiaryAccount = accountRepo.save(beneficiaryAccount);
		}

		if (Boolean.TRUE.equals(identity.getChangeInBenImage())) {
			MBeneficiaryImage beneficiaryImage = editMapper.identityEditDTOToMBeneficiaryImage(identity);

			/**
			 * new logic for data sync, 26-09-2018
			 */
			// getting correct beneficiaryDetailsId by passing vanSerialNo & vanID
			Long benImageId = imageRepo.findIdByVanSerialNoAndVanID(benMapping.getMBeneficiaryImage().getBenImageId(),
					benMapping.getVanID());
			// next statement is new one, setting correct beneficiaryDetailsId
			if (benImageId != null)
				beneficiaryImage.setBenImageId(benImageId);
			else
				throw new MissingMandatoryFieldsException("Either of vanSerialNO or vanID is missing.");

			/**
			 * END
			 */

			logger.debug("Image to upsert = " + OutputMapper.gson().toJson(beneficiaryImage));
			imageRepo.save(beneficiaryImage);
		}

		// end

		// change in association will be done here *** commented cause all
		// details are
		// available in ben details
		// if(identity.getChangeInAssociations()) {
		//
		// }

		logger.info("IdentityService.editIdentity - end. id = " + benMapping.getBenMapId());
		// return benMapping;
	}

	/**
	 * @param identity
	 * @return
	 */

	// SynchronousQueue<MBeneficiaryregidmapping> queue = new
	// SynchronousQueue<MBeneficiaryregidmapping>();
	ArrayDeque<MBeneficiaryregidmapping> queue = new ArrayDeque<MBeneficiaryregidmapping>();

	public BeneficiaryCreateResp createIdentity(IdentityDTO identity) throws IEMRException {
		logger.info("IdentityService.createIdentity - start");

		List<MBeneficiaryregidmapping> list = null;
		MBeneficiaryregidmapping regMap = null;
		synchronized (queue) {
			if (queue.isEmpty()) {
				logger.info("fetching 10000 rows");
				list = regIdRepo.findTop10000ByProvisionedAndReserved(false, false);
				logger.info("Adding SynchronousQueue start-- ");
				for (MBeneficiaryregidmapping map : list) {
					queue.add(map);
				}
				logger.info("Adding SynchronousQueue end-- ");
			}
			regMap = queue.removeFirst();
		}
		regMap.setReserved(true);

		regIdRepo.save(regMap);

		regMap.setProvisioned(true);

		/*
		 * synchronized (regIdRepo) { regMap =
		 * regIdRepo.findFirstByProvisionedAndReserved(false, false);
		 * 
		 * if (regMap == null) throw new
		 * IEMRException("Beneficiary IDs are not available! Please allocate the IDs");
		 * 
		 * regMap.setReserved(true);
		 * 
		 * regIdRepo.save(regMap);
		 * 
		 * regMap.setProvisioned(true); }
		 */

		// return regMap;
		// });

		// Future<MBeneficiaryaddress> fAddress = executor.submit(() ->
		// {
		logger.info("IdentityService.createIdentity - saving Address");
		MBeneficiaryaddress mAddr = mapper.identityDTOToMBeneficiaryaddress(identity);
		logger.info("identity.getIsPermAddrSameAsCurrAddr = " + identity.getIsPermAddrSameAsCurrAddr());
		if (Boolean.TRUE.equals(identity.getIsPermAddrSameAsCurrAddr())) {
			logger.debug("identity.getCurrentAddress = " + identity.getCurrentAddress());
			mAddr.setPermanentAddress(identity.getCurrentAddress());
		}

		logger.info("identity.getIsPermAddrSameAsEmerAddr = " + identity.getIsPermAddrSameAsEmerAddr());
		if (Boolean.TRUE.equals(identity.getIsPermAddrSameAsEmerAddr())) {
			logger.debug("identity.getEmergencyAddress = " + identity.getEmergencyAddress());
			mAddr.setPermanentAddress(identity.getEmergencyAddress());
		}

		logger.info("identity.getIsEmerAddrSameAsCurrAddr = " + identity.getIsEmerAddrSameAsCurrAddr());
		if (Boolean.TRUE.equals(identity.getIsEmerAddrSameAsCurrAddr())) {
			logger.debug("identity.getCurrentAddress = " + identity.getCurrentAddress());
			mAddr.setEmergencyAddress(identity.getCurrentAddress());
		}

		logger.info("identity.getIsEmerAddrSameAsPermAddr = " + identity.getIsEmerAddrSameAsPermAddr());
		if (Boolean.TRUE.equals(identity.getIsEmerAddrSameAsPermAddr())) {
			logger.debug("identity.getPermanentAddress = " + identity.getPermanentAddress());
			mAddr.setEmergencyAddress(identity.getPermanentAddress());
		}

		mAddr = addressRepo.save(mAddr);
		logger.info("IdentityService.createIdentity - Address saved - id = " + mAddr.getBenAddressID());

		// Update van serial no for data sync
		int i = addressRepo.updateVanSerialNo(mAddr.getBenAddressID());

		// return mAddr;
		// });

		// Future<MBeneficiaryconsent> fConsent = executor.submit(() ->
		// {
		MBeneficiaryconsent mConsnt = mapper.identityDTOToDefaultMBeneficiaryconsent(identity, true, false);
		logger.info("IdentityService.createIdentity - saving Consent");
		mConsnt = consentRepo.save(mConsnt);
		logger.info("IdentityService.createIdentity - Consent saved - id = " + mConsnt.getBenConsentID());

		// Update van serial no for data sync
		int i1 = consentRepo.updateVanSerialNo(mConsnt.getBenConsentID());

		// return mConsnt;
		// });

		// Future<MBeneficiarycontact> fContact = executor.submit(() ->
		// {
		logger.info("IdentityService.createIdentity - saving Contacts");
		MBeneficiarycontact mContc = mapper.identityDTOToMBeneficiarycontact(identity);
		mContc = contactRepo.save(mContc);
		logger.info("IdentityService.createIdentity - Contacts saved - id = " + mContc.getBenContactsID());

		// Update van serial no for data sync
		int i2 = contactRepo.updateVanSerialNo(mContc.getBenContactsID());

		// return mContc;
		// });

		// Future<MBeneficiarydetail> fDetail = executor.submit(() ->
		// {
		logger.info("IdentityService.createIdentity - saving Details");
		MBeneficiarydetail mDetl = mapper.identityDTOToMBeneficiarydetail(identity);
		mDetl = detailRepo.save(mDetl);
		logger.info("IdentityService.createIdentity - Details saved - id = " + mDetl.getBeneficiaryDetailsId());

		// Update van serial no for data sync
		int i3 = detailRepo.updateVanSerialNo(mDetl.getBeneficiaryDetailsId());

		// return mDetl;
		// });

		// start
		// Feature used in outreach
		// Future<MBeneficiaryAccount> fBankDetails = executor.submit(() ->
		// {
		MBeneficiaryAccount bankOBJ = mapper.identityDTOToMBeneficiaryAccount(identity);
		bankOBJ = accountRepo.save(bankOBJ);
		// Update van serial no for data sync
		int i4 = accountRepo.updateVanSerialNo(bankOBJ.getBenAccountID());

		// return bankOBJ;
		// });

		// Future<MBeneficiaryImage> fBenImage = executor.submit(() ->
		// {
		MBeneficiaryImage benImageOBJ = mapper.identityDTOToMBeneficiaryImage(identity);
		benImageOBJ = imageRepo.save(benImageOBJ);

		// Update van serial no for data sync
		int i5 = imageRepo.updateVanSerialNo(benImageOBJ.getBenImageId());

		// return benImageOBJ;
		// });
		// end

		logger.info("IdentityService.createIdentity - saving Mapping");
		MBeneficiarymapping benMapping = mapper.identityDTOToMBeneficiarymapping(identity);

		// try
		// {
		benMapping.setMBeneficiarycontact(mContc);
		benMapping.setMBeneficiaryaddress(mAddr);
		benMapping.setMBeneficiaryconsent(mConsnt);
		benMapping.setMBeneficiarydetail(mDetl);
		benMapping.setMBeneficiaryregidmapping(regMap);
		benMapping.setMBeneficiaryImage(benImageOBJ);
		benMapping.setMBeneficiaryAccount(bankOBJ);

		regMap.setProviderServiceMapID(identity.getProviderServiceMapId());
		// added columns for data sync
		// 17-09-2018
		if (identity.getVanID() != null)
			regMap.setVanID(identity.getVanID());
		if (identity.getParkingPlaceId() != null)
			regMap.setParkingPlaceID(identity.getParkingPlaceId());
		regMap.setVanSerialNo(regMap.getBenRegId());
		// END

		regIdRepo.save(regMap);
		// } catch (InterruptedException | ExecutionException e)
		// {
		// logger.info("error under catch interrupted exception - benMapping: "
		// + benMapping);
		//
		// e.printStackTrace();
		// if (benMapping.getMBeneficiarycontact() != null)
		// {
		//
		// logger.info("INSIDE IF IT IS THERE ");
		// contactRepo.delete(benMapping.getMBeneficiarycontact().getBenContactsID());
		// }
		// if (benMapping.getMBeneficiaryaddress() != null)
		// {
		//
		// logger.info("INSIDE IF IT IS THERE ");
		// regIdRepo.delete(benMapping.getMBeneficiaryaddress().getBenAddressID());
		// }
		// e.printStackTrace();
		// }

		benMapping = mappingRepo.save(benMapping);
		// Update van serial no for data sync
		int i6 = mappingRepo.updateVanSerialNo(benMapping.getBenMapId());

		final MBeneficiarymapping benMapping2 = benMapping;
		// Future<List<MBeneficiaryfamilymapping>> fFamily = executor.submit(()
		// ->
		// {
		logger.info("IdentityService.createIdentity - saving FamilyMaps");
		List<MBeneficiaryfamilymapping> fIdenList = new ArrayList<MBeneficiaryfamilymapping>();
		List<MBeneficiaryfamilymapping> fList = new ArrayList<MBeneficiaryfamilymapping>();

		// new logic (18-09-2018, Neeraj kumar)
		if (null != identity.getBenFamilyDTOs()) {
			fIdenList = mapper.IdentityDTOListToMBeneficiaryfamilymappingList(identity.getBenFamilyDTOs());
			if (fIdenList != null) {
				for (MBeneficiaryfamilymapping bfMapping : fIdenList) {
					bfMapping.setBenMapId(benMapping2.getBenMapId());

					if (bfMapping.getVanID() == null && identity.getVanID() != null)
						bfMapping.setVanID(identity.getVanID());

					if (bfMapping.getParkingPlaceID() == null && identity.getParkingPlaceId() != null)
						bfMapping.setParkingPlaceID(identity.getParkingPlaceId());

					if (bfMapping.getAssociatedBenRegId() == null) {
						bfMapping.setAssociatedBenRegId(benMapping2.getBenRegId());
					}
				}
				fList = (List<MBeneficiaryfamilymapping>) familyMapRepo.save(fIdenList);
				// Update van serial no for data sync
				if (fList != null && fList.size() > 0) {
					for (MBeneficiaryfamilymapping obj : fList) {
						int i7 = familyMapRepo.updateVanSerialNo(obj.getBenFamilyMapId());
					}
				}
			}

			/**
			 * commenting below code as optimization process, ABOVE code replaced it
			 * 
			 */

			// ListIterator<MBeneficiaryfamilymapping> iterator = fIdenList.listIterator();
			// while (iterator.hasNext()) {
			//
			// MBeneficiaryfamilymapping fMap = iterator.next();
			// fMap.setBenMapId(benMapping2.getBenMapId());
			// if (fMap.getAssociatedBenRegId() == null) {
			// fMap.setAssociatedBenRegId(benMapping2.getBenRegId());
			// }
			// fMap = familyMapRepo.save(fMap);
			// fList.add(fMap);
			// }
			/**
			 * END
			 * 
			 */
		}

		logger.info("IdentityService.createIdentity - FamilyMap saved ");
		// return fList;
		// });

		// Future<List<MBeneficiaryservicemapping>> fService =
		// executor.submit(() ->
		// {
		logger.info("IdentityService.createIdentity - saving Service Map");
		MBeneficiaryservicemapping sMap = mapper.identityDTOToMBeneficiaryservicemapping(identity);
		// sMap.setMBeneficiarymapping(benMapping);
		sMap.setBenMapId(benMapping.getBenMapId());
		sMap = serviceMapRepo.save(sMap);
		logger.info("IdentityService.createIdentity - ServiceMap saved  - id = " + sMap.getBenServiceMapID());

		// Update van serial no for data sync
		int i7 = serviceMapRepo.updateVanSerialNo(sMap.getBenServiceMapID());

		List<MBeneficiaryservicemapping> sList = new ArrayList<MBeneficiaryservicemapping>();
		sList.add(sMap);
		// return sList;
		// });

		// Future<List<MBeneficiaryidentity>> fIdentity = executor.submit(() ->
		// {
		logger.info("IdentityService.createIdentity - saving Identity");
		List<MBeneficiaryidentity> mIdenList2 = new ArrayList<MBeneficiaryidentity>();
		if (null != identity.getIdentities()) {
			List<MBeneficiaryidentity> mIdenList = mapper
					.IdentityDTOListToMBeneficiaryidentityList(identity.getIdentities());
			mIdenList.forEach(mIden -> {
				mIden.setBenMapId(benMapping2.getBenMapId());
				mIden.setCreatedBy(identity.getAgentName());
				mIden.setCreatedDate(identity.getEventTypeDate());

				// set new column(vanID, parkingPlaceID) value for data sync
				if (identity.getVanID() != null)
					mIden.setVanID(identity.getVanID());
				if (identity.getParkingPlaceId() != null)
					mIden.setParkingPlaceID(identity.getParkingPlaceId());

				MBeneficiaryidentity m = identityRepo.save(mIden);

				// Update van serial no for data sync
				int i8 = identityRepo.updateVanSerialNo(m.getBenIdentityId());

				mIdenList2.add(m);
				logger.info("IdentityService.createIdentity - Identity saved  - id = " + m.getBenIdentityId());
			});
		}

		// commented on 28-09-2018
		// benMapping.setMBeneficiaryfamilymappings(fList);
		// benMapping.setMBeneficiaryservicemappings(sList);
		// benMapping.setMBeneficiaryidentities(mIdenList2);
		//
		//
		// benMapping = mappingRepo.save(benMapping);
		// end

		logger.info("IdentityService.createIdentity - end. id = " + benMapping.getBenMapId());
		return partialMapper.MBeneficiarymappingToBeneficiaryCreateResp(benMapping);
	}

	public String getReservedIdList() {

		return "success";
	}

	/**
	 * 
	 * @param reserveIdentityDTO
	 * @return
	 */
	public String reserveIdentity(ReserveIdentityDTO reserveIdentityDTO) {

		Long availableCount = regIdRepo.countByProviderServiceMapIDAndVehicalNoOrderByBenRegIdAsc(
				reserveIdentityDTO.getProviderServiceMapID(), reserveIdentityDTO.getVehicalNo());

		if (reserveIdentityDTO.getReserveCount() < availableCount) {

			MBeneficiaryregidmapping beneficiaryregidmapping;
			Long countToBeAllocate = reserveIdentityDTO.getReserveCount() - availableCount;
			countToBeAllocate++;
			for (int index = 0; index < countToBeAllocate; index++) {

				beneficiaryregidmapping = regIdRepo.findFirstByProviderServiceMapIDAndVehicalNoOrderByBenRegIdAsc(null,
						null);
				beneficiaryregidmapping.setProviderServiceMapID(reserveIdentityDTO.getProviderServiceMapID());
				beneficiaryregidmapping.setVehicalNo(reserveIdentityDTO.getVehicalNo());
				regIdRepo.save(beneficiaryregidmapping);
			}
		}

		return "Successfully Completed";
	}

	public String unReserveIdentity(ReserveIdentityDTO unReserve) {

		regIdRepo.unreserveBeneficiaryIds(unReserve.getProviderServiceMapID(), unReserve.getVehicalNo());
		return "Successfully Completed";
	}

	/**
	 * Get partial details of beneficiaries (first name middle name and last name)
	 * list on benId's list
	 * 
	 * @param BenRegIds
	 * @return {@link List} Beneficiaries
	 */
	// public List<BeneficiariesPartialDTO>
	// getBeneficiariesPartialDeatilsByBenRegIdList(List<BigInteger> BenRegIds)
	// {
	//
	// logger.info("IdentityService.getBeneficiariesPartialDeatilsByBenRegId -
	// end");
	// List<BeneficiariesPartialDTO> list = new
	// ArrayList<BeneficiariesPartialDTO>();
	// List<MBeneficiaryregidmapping> benMapIDList =
	// (List<MBeneficiaryregidmapping>) regIdRepo.findAll(BenRegIds);
	// ListIterator<MBeneficiaryregidmapping> benMapListIter =
	// benMapIDList.listIterator();
	//
	// MBeneficiarydetail beneficiarydetail;
	// MBeneficiarymapping benMap;
	// while (benMapListIter.hasNext())
	// {
	//
	// MBeneficiaryregidmapping regId = benMapListIter.next();
	// beneficiarydetail =
	// detailRepo.findPartialBeneficiaryDetailByBenRegId(regId.getBenRegId());
	// benMap = new MBeneficiarymapping();
	// benMap.setMBeneficiarydetail(beneficiarydetail);
	// benMap.setMBeneficiaryregidmapping(regId);
	// list.add(partialMapper.MBeneficiarymappingToBeneficiariesPartialDTO(benMap));
	// }
	//
	// logger.info("IdetityService.getBeneficiariesPartialDeatilsByBenRegId -
	// end");
	//
	// return list;
	// }

	public List<BeneficiariesPartialDTO> getBeneficiariesPartialDeatilsByBenRegIdList(List<BigInteger> BenRegIds) {

		logger.info("IdentityService.getBeneficiariesPartialDeatilsByBenRegId - end");
		List<BeneficiariesPartialDTO> list = new ArrayList<BeneficiariesPartialDTO>();
		// old logic
		// List<MBeneficiarymapping> benMapIDList = (List<MBeneficiarymapping>)
		// mappingRepo
		// .findAllByBenRegIdOrderByBenMapIdAsc(BenRegIds);
		// // List<Future<?>> futures = new ArrayList<Future<?>>();
		// for (MBeneficiarymapping benMap : benMapIDList) {
		// list.add(partialMapper.MBeneficiarymappingToBeneficiariesPartialDTO(benMap));
		// }
		// end

		// new logic, 19-12-2018
		List<Object[]> benMapObjArr = new ArrayList<>();
		if (BenRegIds != null && BenRegIds.size() > 0) {
			benMapObjArr = mappingRepo.getBenMappingByRegIDList(BenRegIds);
			if (benMapObjArr != null && benMapObjArr.size() > 0) {
				for (Object[] objArr : benMapObjArr) {
					MBeneficiarymapping benMap = this.getBeneficiariesDTONewPartial(objArr);
//					logger.info("benMap " + benMap);

					list.add(partialMapper.MBeneficiarymappingToBeneficiariesPartialDTO(benMap));
				}
			}
			logger.info("benMap size" + (list.size() == 0 ? "No Beneficiary Found" : list.size()));

		}
		// end
		logger.info("IdetityService.getBeneficiariesPartialDeatilsByBenRegId - end");

		return list;
	}

	/**
	 * Get partial details of beneficiaries (first name middle name and last name)
	 * list on benId's list
	 * 
	 * @param BenRegIds
	 * @return {@link List} Beneficiaries
	 */
	// public List<BeneficiariesDTO>
	// getBeneficiariesDeatilsByBenRegIdList(List<BigInteger> BenRegIds)
	// {
	//
	// logger.info("IdentityService.getBeneficiariesPartialDeatilsByBenRegId -
	// end");
	// List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();
	// List<MBeneficiaryregidmapping> benMapIDList =
	// (List<MBeneficiaryregidmapping>) regIdRepo.findAll(BenRegIds);
	// List<MBeneficiarymapping> benMapList = new
	// ArrayList<MBeneficiarymapping>();
	//
	// benMapIDList.forEach(benIdMap ->
	// {
	//
	// MBeneficiarymapping benMap =
	// mappingRepo.findByBenRegIdOrderByBenMapIdAsc(benIdMap.getBenRegId());
	// benMapList.add(benMap);
	// });
	//
	// List<Future<?>> futures = new ArrayList<Future<?>>();
	// benMapList.forEach(benMap ->
	// {
	// Future<?> future = executor.submit(() ->
	// {
	//
	// list.add(this.getBeneficiariesDTO(benMap));
	// logger.info("benMapId: " + benMap.getBenMapId() + " :: BenId: "
	// + benMap.getMBeneficiaryregidmapping().getBeneficiaryID());
	// });
	// futures.add(future);
	// });
	//
	// try
	// {
	// for (Future<?> future : futures)
	// {
	// future.get();
	// }
	// } catch (InterruptedException | ExecutionException e)
	// {
	// e.printStackTrace();
	// }
	//
	// logger.info("IdetityService.getBeneficiariesPartialDeatilsByBenRegId -
	// end");
	//
	// return list;
	// }
	public List<BeneficiariesDTO> getBeneficiariesDeatilsByBenRegIdList(List<BigInteger> BenRegIds) {

		logger.info("IdentityService.getBeneficiariesDeatilsByBenRegIdList - end");
		List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();
		// old logic
		// List<MBeneficiarymapping> benMapIDList = (List<MBeneficiarymapping>)
		// mappingRepo
		// .findAllByBenRegIdOrderByBenMapIdAsc(BenRegIds);
		//
		// for (MBeneficiarymapping benMap : benMapIDList) {
		// list.add(getBeneficiariesDTO(benMap));
		// }
		// end

		// new logic, 19-12-2018
		List<Object[]> benMapObjArr = new ArrayList<>();
		if (BenRegIds != null && BenRegIds.size() > 0) {
			benMapObjArr = mappingRepo.getBenMappingByRegIDList(BenRegIds);
			if (benMapObjArr != null && benMapObjArr.size() > 0) {
				for (Object[] objArr : benMapObjArr) {
					MBeneficiarymapping benMap = this.getBeneficiariesDTONew(objArr);
//					logger.info("benMap " + benMap);

					list.add(this.getBeneficiariesDTO(benMap));
				}
			}
			logger.info("benMap size" + (list.size() == 0 ? "No Beneficiary Found" : list.size()));

		}
		// end

		logger.info("IdetityService.getBeneficiariesPartialDeatilsByBenRegId - end");

		return list;
	}

	/**
	 * 
	 * @param benMap
	 * @return
	 */
	// private synchronized BeneficiariesDTO
	// getBeneficiariesDTO(MBeneficiarymapping benMap)
	private BeneficiariesDTO getBeneficiariesDTO(MBeneficiarymapping benMap) {

		BeneficiariesDTO bdto = mapper.MBeneficiarymappingToBeneficiariesDTO(benMap);
		bdto.setBeneficiaryFamilyTags(
				mapper.mapToMBeneficiaryfamilymappingWithBenFamilyDTOList(benMap.getMBeneficiaryfamilymappings()));
		bdto.setBeneficiaryIdentites(
				mapper.mBeneficiaryidentityListToBenIdentityDTOList(benMap.getMBeneficiaryidentities()));

		// System.out.println("ABHA start....");
		List<Object[]> abhaList = v_BenAdvanceSearchRepo.getBenAbhaDetailsByBenRegID(bdto.getBenRegId());
		if (abhaList != null && abhaList.size() > 0) {
			List<AbhaAddressDTO> abhaDTOList = new ArrayList<>();
			AbhaAddressDTO abhaDTO;
			for (Object[] objArr : abhaList) {
				abhaDTO = new AbhaAddressDTO();
				abhaDTO.setBeneficiaryRegID(bdto.getBenRegId());
				if (objArr[1] != null)
					abhaDTO.setHealthID(objArr[1].toString());
				if (objArr[2] != null)
					abhaDTO.setHealthIDNumber(objArr[2].toString());
				if (objArr[3] != null)
					abhaDTO.setAuthenticationMode(objArr[3].toString());
				if (objArr[4] != null)
					abhaDTO.setCreatedDate((Timestamp) objArr[4]);

				abhaDTOList.add(abhaDTO);

			}
			bdto.setAbhaDetails(abhaDTOList);
		}
		// System.out.println("ABHA end....");
		return bdto;
	}

	/**
	 * finite search
	 * 
	 * @param identityDTO
	 * @return
	 */
	public List<BeneficiariesDTO> getBeneficiaries(IdentityDTO identityDTO) {
		List<BeneficiariesDTO> list = new ArrayList<BeneficiariesDTO>();

		List<MBeneficiarymapping> benMapList = mappingRepo.finiteSearch(identityDTO);
		// List<Future<?>> futures = new ArrayList<Future<?>>();
		// benMapList.forEach(benMap ->
		// {
		// Future<?> future = executor.submit(() ->
		// {
		for (MBeneficiarymapping benMap : benMapList) {
			list.add(this.getBeneficiariesDTO(benMap));
			logger.info("benMapId: " + benMap.getBenMapId() + " :: BenId: "
					+ benMap.getMBeneficiaryregidmapping().getBeneficiaryID());
		}
		// });
		// futures.add(future);
		// });

		// try
		// {
		// for (Future<?> future : futures)
		// {
		// future.get();
		// }
		// } catch (InterruptedException | ExecutionException e)
		// {
		// e.printStackTrace();
		// }

		return list;
	}

	/***
	 * 
	 * @return beneficiary image for beneficiary Reg ID.
	 */
	public String getBeneficiaryImage(String requestOBJ) {
		OutputResponse response = new OutputResponse();
		try {
			Map<String, Object> benImageMap = new HashMap<String, Object>();
			// String benImage = null;
			if (requestOBJ != null) {
				JsonObject obj = new JsonObject();
				JsonParser jsnParser = new JsonParser();
				JsonElement jsnElmnt = jsnParser.parse(requestOBJ);
				obj = jsnElmnt.getAsJsonObject();

				// JSONObject obj = new JSONObject(requestOBJ);
				if (obj != null && obj.has("beneficiaryRegID") && obj.get("beneficiaryRegID") != null) {
					MBeneficiarymapping benMap = mappingRepo
							.getBenImageIdByBenRegID(obj.get("beneficiaryRegID").getAsBigInteger());

					if (benMap != null && benMap.getBenImageId() != null && benMap.getVanID() != null) {
						MBeneficiaryImage benImageOBJ = imageRepo.getBenImageByBenImageID(benMap.getBenImageId(),
								benMap.getVanID());
						benImageMap.put("benImage", benImageOBJ.getBenImage());
						benImageMap.put("createdDate", benImageOBJ.getCreatedDate());
						response.setResponse(
								new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).create()
										.toJson(benImageMap));
					} else {
						response.setResponse("Image not available");
					}
				} else {
					response.setError(5000, "Invalid request");
				}
			}
		} catch (Exception e) {
			logger.error("Error while beneficiary image fetching" + e);
			response.setError(e);
		}

		return response.toString();
	}

	public void editIdentityEducationOrCommunity(IdentityEditDTO identity) throws MissingMandatoryFieldsException {
		// TODO Auto-generated method stub
		logger.info("IdentityService.editIdentityEducationorCommunity - start");
		if (identity.getBeneficiaryRegId() == null && null == identity.getBeneficaryId()) {
			throw new MissingMandatoryFieldsException("Either of BeneficiaryID or Beneficiary Reg Id is mandatory.");
		}

		// SUNIL TODO: Logic for the various Edit scenarios goes here
		// old logic : 13-11-2018
		// MBeneficiarymapping benMapping =
		// mappingRepo.findByBenRegIdOrderByBenMapIdAsc(identity.getBeneficiaryRegId());
		// MBeneficiarydetail mbDetl =
		// editMapper.IdentityEditDTOToMBeneficiarydetail(identity);
		// logger.debug("Beneficiary details to update = " + new
		// OutputMapper().gson().toJson(mbDetl));
		// mbDetl.setBeneficiaryDetailsId(benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId());
		// if (benMapping != null && benMapping.getMBeneficiarydetail() != null
		// && benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId() != null) {
		// if (identity.getCommunityId() != null) {
		// detailRepo.updateCommunity(benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId(),
		// identity.getCommunityId());
		// }
		// if (identity.getEducationId() != null) {
		// detailRepo.updateEducation(benMapping.getMBeneficiarydetail().getBeneficiaryDetailsId(),
		// identity.getEducationId());
		// }
		// }

		// new logic : 13-11-2018
		MBeneficiarymapping benMapping = mappingRepo.findByBenRegIdOrderByBenMapIdAsc(identity.getBeneficiaryRegId());
		if (benMapping != null && benMapping.getBenDetailsId() != null && benMapping.getVanID() != null) {
			if (identity.getCommunityId() != null) {
				detailRepo.updateCommunity(benMapping.getBenDetailsId(), benMapping.getVanID(),
						identity.getCommunityId());
			}
			if (identity.getEducationId() != null) {
				detailRepo.updateEducation(benMapping.getBenDetailsId(), benMapping.getVanID(),
						identity.getEducationId());
			}
		}

	}

	public int importBenIdToLocalServer(List<BenIdImportDTO> benIdImportDTOList) {
		if (benIdImportDTOList.size() > 0) {
			ArrayList<MBeneficiaryregidmapping> mBeneficiaryregidmappingList = benIdImportMapper
					.benIdImportDTOToMBeneficiaryregidmappings(benIdImportDTOList);

			jdbcTemplate = getJdbcTemplate();
			List<Object[]> dataList = new ArrayList<>();
			Object[] objArr;
			String query = " INSERT INTO db_identity.m_beneficiaryregidmapping(BenRegId, BeneficiaryID, "
					+ " Provisioned, CreatedDate, CreatedBy, Reserved) VALUES (?,?,?,?,?,?) ";

			for (MBeneficiaryregidmapping obj : mBeneficiaryregidmappingList) {
				objArr = new Object[6];

				objArr[0] = obj.getBenRegId();
				objArr[1] = obj.getBeneficiaryID();
				objArr[2] = false;
				objArr[3] = obj.getCreatedDate();
				objArr[4] = obj.getCreatedBy();
				objArr[5] = false;

				dataList.add(objArr);
//				obj.setProvisioned(false);
//				obj.setReserved(false);
				System.out.println("regid :" + obj.getBenRegId() + " - benid :" + obj.getBeneficiaryID());
			}

			int[] i = jdbcTemplate.batchUpdate(query, dataList);

//			ArrayList<MBeneficiaryregidmapping> rs = (ArrayList<MBeneficiaryregidmapping>) regIdRepo
//					.save(mBeneficiaryregidmappingList);
			return i.length;
		} else
			return 0;

	}

	public Long checkBenIDAvailabilityLocal() {
		return regIdRepo.countByProvisioned(false);

	}
}
