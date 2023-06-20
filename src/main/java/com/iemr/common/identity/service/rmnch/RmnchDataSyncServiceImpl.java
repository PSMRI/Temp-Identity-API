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
package com.iemr.common.identity.service.rmnch;

import java.math.BigInteger;
import java.sql.Date;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.common.identity.controller.rmnch.RmnchMobileAppController;
import com.iemr.common.identity.data.rmnch.BenHealthIDDetails;
import com.iemr.common.identity.data.rmnch.GetBenRequestHandler;
import com.iemr.common.identity.data.rmnch.NCD_TB_HRP_data;
import com.iemr.common.identity.data.rmnch.RMNCHBeneficiaryDetailsRmnch;
import com.iemr.common.identity.data.rmnch.RMNCHBornBirthDetails;
import com.iemr.common.identity.data.rmnch.RMNCHCBACdetails;
import com.iemr.common.identity.data.rmnch.RMNCHHouseHoldDetails;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiaryAccount;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiaryImage;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiaryaddress;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiarycontact;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiarydetail;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiarymapping;
import com.iemr.common.identity.repo.rmnch.RMNCHBenAccountRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenAddressRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenContactRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenImageRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBeneficiaryDetailsRmnchRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBornBirthDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHCBACDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHHouseHoldDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHMBenMappingRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHMBenRegIdMapRepo;
import com.iemr.common.identity.utils.config.ConfigProperties;
import com.iemr.common.identity.utils.exception.IEMRException;
import com.iemr.common.identity.utils.http.HttpUtils;
import com.iemr.common.identity.utils.mapper.InputMapper;

@Service
@Qualifier("rmnchServiceImpl")
@PropertySource("classpath:application.properties")
public class RmnchDataSyncServiceImpl implements RmnchDataSyncService {

	private Logger logger = LoggerFactory.getLogger(RmnchMobileAppController.class);
	private ConfigProperties properties;
	@Value("${door-to-door-page-size}")
	private String door_to_door_page_size;

	@Autowired
	private RMNCHBeneficiaryDetailsRmnchRepo rMNCHBeneficiaryDetailsRmnchRepo;
	@Autowired
	private RMNCHBornBirthDetailsRepo rMNCHBornBirthDetailsRepo;
	@Autowired
	private RMNCHCBACDetailsRepo rMNCHCBACDetailsRepo;
	@Autowired
	private RMNCHHouseHoldDetailsRepo rMNCHHouseHoldDetailsRepo;

	@Autowired
	private RMNCHBenAddressRepo rMNCHBenAddressRepo;
	@Autowired
	private RMNCHMBenMappingRepo rMNCHMBenMappingRepo;
	@Autowired
	private RMNCHBenDetailsRepo rMNCHBenDetailsRepo;
	@Autowired
	private RMNCHBenAccountRepo rMNCHBenAccountRepo;
	@Autowired
	private RMNCHBenImageRepo rMNCHBenImageRepo;
	@Autowired
	private RMNCHBenContactRepo rMNCHBenContactRepo;
	@Autowired
	private RMNCHMBenRegIdMapRepo rMNCHMBenRegIdMapRepo;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public String syncDataToAmrit(String requestOBJ) throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		ArrayList<Long> beneficiaryDetailsIds = new ArrayList<>();
		ArrayList<Long> bornBirthDeatilsIds = new ArrayList<>();
		ArrayList<Long> cBACDetailsIds = new ArrayList<>();
		ArrayList<Long> houseHoldDetailsIds = new ArrayList<>();

		try {
			if (requestOBJ != null && !requestOBJ.isEmpty()) {
				JsonObject jsnOBJ = new JsonObject();
				JsonParser jsnParser = new JsonParser();
				JsonElement jsnElmnt = jsnParser.parse(requestOBJ);
				jsnOBJ = jsnElmnt.getAsJsonObject();

				// other tables data saving
				// ben details RMNCH extra fields details

				Long benRegID = null;

				if (jsnOBJ != null && jsnOBJ.has("beneficiaryDetails")) {
					RMNCHBeneficiaryDetailsRmnch[] objArr = InputMapper.gson()
							.fromJson(jsnOBJ.get("beneficiaryDetails"), RMNCHBeneficiaryDetailsRmnch[].class);
					List<RMNCHBeneficiaryDetailsRmnch> benDetailsExtraList = Arrays.asList(objArr);

					if (benDetailsExtraList != null && benDetailsExtraList.size() > 0) {
						benRegID = rMNCHMBenRegIdMapRepo.getRegID(benDetailsExtraList.get(0).getBenficieryid());

						if (benRegID != null) {
							for (RMNCHBeneficiaryDetailsRmnch obj : benDetailsExtraList) {
								obj.setBenRegId(benRegID);
								RMNCHBeneficiaryDetailsRmnch temp = rMNCHBeneficiaryDetailsRmnchRepo
										.getByRegID(benRegID);
								if (temp != null) {
									obj.setBeneficiaryDetails_RmnchId(temp.getBeneficiaryDetails_RmnchId());
								}

								if (obj.getRelatedBeneficiaryIds() != null
										&& obj.getRelatedBeneficiaryIds().length > 0) {
									StringBuffer sb = new StringBuffer();
									int pointer = 0;
									for (Long benID : obj.getRelatedBeneficiaryIds()) {
										if (pointer == (obj.getRelatedBeneficiaryIds().length - 1))
											sb.append(benID.toString());
										else
											sb.append(benID.toString()).append(",");
									}
									obj.setRelatedBeneficiaryIdsDB(sb.toString());
								}

							}

							benDetailsExtraList = (ArrayList<RMNCHBeneficiaryDetailsRmnch>) rMNCHBeneficiaryDetailsRmnchRepo
									.save(benDetailsExtraList);

							benDetailsExtraList.forEach((n) -> beneficiaryDetailsIds.add(n.getId()));
						} else
							throw new Exception("invalid/empty beneficiary request data.");

						// born birth details
						if (jsnOBJ != null && jsnOBJ.has("bornBirthDeatils") && benRegID != null) {
							RMNCHBornBirthDetails[] objArr1 = InputMapper.gson()
									.fromJson(jsnOBJ.get("bornBirthDeatils"), RMNCHBornBirthDetails[].class);
							List<RMNCHBornBirthDetails> bornBirthList = Arrays.asList(objArr1);
							for (RMNCHBornBirthDetails obj : bornBirthList) {
								obj.setBenRegId(benRegID);
								RMNCHBornBirthDetails temp = rMNCHBornBirthDetailsRepo.getByRegID(benRegID);
								if (temp != null)
									obj.setBornBirthDeatilsId(temp.getBornBirthDeatilsId());
							}
							bornBirthList = (ArrayList<RMNCHBornBirthDetails>) rMNCHBornBirthDetailsRepo
									.save(bornBirthList);
							// success response
							bornBirthList.forEach((n) -> bornBirthDeatilsIds.add(n.getId()));
						}
						// CBAC details
						if (jsnOBJ != null && jsnOBJ.has("cBACDetails")) {
							RMNCHCBACdetails[] objArr2 = InputMapper.gson().fromJson(jsnOBJ.get("cBACDetails"),
									RMNCHCBACdetails[].class);
							List<RMNCHCBACdetails> cbacList = Arrays.asList(objArr2);

							for (RMNCHCBACdetails obj : cbacList) {
								obj.setBenRegId(benRegID);
								obj.setConfirmed_hrp("Not checked");
								obj.setConfirmed_ncd("Not checked");
								obj.setConfirmed_tb("Not checked");
								obj.setConfirmed_ncd_diseases("Not checked");
								obj.setDiagnosis_status("pending");
								RMNCHCBACdetails temp = rMNCHCBACDetailsRepo.getByRegID(benRegID);
								if (temp != null)
									obj.setCBACDetailsid(temp.getCBACDetailsid());
							}

							cbacList = (ArrayList<RMNCHCBACdetails>) rMNCHCBACDetailsRepo.save(cbacList);
							// success response
							cbacList.forEach((n) -> cBACDetailsIds.add(n.getId()));
						}
						// house hold details
						if (jsnOBJ != null && jsnOBJ.has("houseHoldDetails")) {
							RMNCHHouseHoldDetails[] objArr3 = InputMapper.gson()
									.fromJson(jsnOBJ.get("houseHoldDetails"), RMNCHHouseHoldDetails[].class);
							List<RMNCHHouseHoldDetails> houseHoldList = Arrays.asList(objArr3);

							for (RMNCHHouseHoldDetails obj : houseHoldList) {
								RMNCHHouseHoldDetails temp = rMNCHHouseHoldDetailsRepo
										.getByHouseHoldID(obj.getHouseoldId());
								if (temp != null)
									obj.setHouseHoldDetailsId(temp.getHouseHoldDetailsId());
							}
							houseHoldList = (ArrayList<RMNCHHouseHoldDetails>) rMNCHHouseHoldDetailsRepo
									.save(houseHoldList);
							// success response
							houseHoldList.forEach((n) -> houseHoldDetailsIds.add(n.getId()));
						}
					} else
						throw new Exception("invalid/empty beneficiary request data.");
				} else
					throw new Exception("invalid/empty beneficiary request data.");

			} else
				throw new Exception("invalid/empty sync request data.");
		} catch (

		Exception e) {
			throw new Exception(e.getMessage());
		}
		resultMap.put("beneficiaryDetails", beneficiaryDetailsIds);
		resultMap.put("bornBirthDeatils", bornBirthDeatilsIds);
		resultMap.put("cBACDetails", cBACDetailsIds);
		resultMap.put("houseHoldDetails", houseHoldDetailsIds);

		return new Gson().toJson(resultMap);
	}

	@Override
	public String getBenData(String requestOBJ, String authorisation) throws Exception {
		String outputResponse = null;
		int totalPage = 0;

		try {
			GetBenRequestHandler request = InputMapper.gson().fromJson(requestOBJ, GetBenRequestHandler.class);
			if (request != null && request.getVillageID() != null) {
				List<RMNCHMBeneficiaryaddress> resultSet;
				Integer pageSize = Integer.valueOf(door_to_door_page_size);
				if (request.getPageNo() != null) {
					PageRequest pr = new PageRequest(request.getPageNo(), pageSize);
					if (request.getFromDate() != null && request.getToDate() != null) {
						Page<RMNCHMBeneficiaryaddress> p = rMNCHBenAddressRepo.getBenDataFilteredWithDateRange(
								request.getVillageID(), request.getFromDate(), request.getToDate(), pr);
						resultSet = p.getContent();
						totalPage = p.getTotalPages();
					} else {
						Page<RMNCHMBeneficiaryaddress> p = rMNCHBenAddressRepo.getBenData(request.getVillageID(), pr);
						resultSet = p.getContent();
						totalPage = p.getTotalPages();
					}
					if (resultSet != null && resultSet.size() > 0) {
						outputResponse = getMappingsForAddressIDs(resultSet, totalPage, authorisation);
					}
				} else {
					// page no not invalid
					throw new Exception("Invalid page no");
				}
			} else {
				// missing village details : village ID
				throw new Exception("Invalid/missing village details");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return outputResponse;
	}

	@Override
	public String getBenDataByAsha(String requestOBJ, String authorisation) throws Exception {
		String outputResponse = null;
		int totalPage = 0;

		try {
			GetBenRequestHandler request = InputMapper.gson().fromJson(requestOBJ, GetBenRequestHandler.class);
			if (request != null && request.getAshaId() != null) {
				List<RMNCHMBeneficiaryaddress> resultSet;
				Integer pageSize = Integer.valueOf(door_to_door_page_size);
				if (request.getPageNo() != null) {
					String userName = rMNCHBenAddressRepo.getUserNameForAsha(request.getAshaId());
					if (userName == null || userName.isEmpty())
						throw new Exception("Asha details not found, please contact administrator");

					request.setUserName(userName);

					PageRequest pr = new PageRequest(request.getPageNo(), pageSize);
					if (request.getFromDate() != null && request.getToDate() != null) {
						Page<RMNCHMBeneficiaryaddress> p = rMNCHBenAddressRepo.getBenDataByAshaFilteredWithDateRange(
								request.getUserName(), request.getFromDate(), request.getToDate(), pr);
						resultSet = p.getContent();
						totalPage = p.getTotalPages();
					} else {
						Page<RMNCHMBeneficiaryaddress> p = rMNCHBenAddressRepo.getBenDataByAsha(request.getUserName(),
								pr);
						resultSet = p.getContent();
						totalPage = p.getTotalPages();
					}
					if (resultSet != null && resultSet.size() > 0) {
						outputResponse = getMappingsForAddressIDs(resultSet, totalPage, authorisation);
					}
				} else {
					// page no not invalid
					throw new Exception("Invalid page no");
				}
			} else
				throw new Exception("Invalid/missing village details");

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return outputResponse;
	}

	private String getMappingsForAddressIDs(List<RMNCHMBeneficiaryaddress> addressList, int totalPage,
			String authorisation) {
		RMNCHHouseHoldDetails benHouseHoldRMNCH_ROBJ;
		RMNCHBeneficiaryDetailsRmnch benDetailsRMNCH_OBJ;
		RMNCHBornBirthDetails benBotnBirthRMNCH_ROBJ;
		RMNCHCBACdetails benCABCRMNCH_ROBJ;

		RMNCHMBeneficiarydetail benDetailsOBJ;
		RMNCHMBeneficiaryAccount benAccountOBJ;
		RMNCHMBeneficiaryImage benImageOBJ;
		RMNCHMBeneficiaryaddress benAddressOBJ;
		RMNCHMBeneficiarycontact benContactOBJ;

		Map<String, Object> resultMap;
		ArrayList<Map<String, Object>> resultList = new ArrayList<>();

		for (RMNCHMBeneficiaryaddress a : addressList) {
			// exception by-passing
			try {
				RMNCHMBeneficiarymapping m = rMNCHMBenMappingRepo.getByAddressIDAndVanID(a.getId(), a.getVanID());
				if (m != null) {
					benHouseHoldRMNCH_ROBJ = new RMNCHHouseHoldDetails();
					benDetailsRMNCH_OBJ = new RMNCHBeneficiaryDetailsRmnch();
					benBotnBirthRMNCH_ROBJ = new RMNCHBornBirthDetails();
					benCABCRMNCH_ROBJ = new RMNCHCBACdetails();

					benDetailsOBJ = new RMNCHMBeneficiarydetail();
					benAccountOBJ = new RMNCHMBeneficiaryAccount();
					benImageOBJ = new RMNCHMBeneficiaryImage();
					benAddressOBJ = new RMNCHMBeneficiaryaddress();
					benContactOBJ = new RMNCHMBeneficiarycontact();

					if (m.getBenDetailsId() != null) {
						benDetailsOBJ = rMNCHBenDetailsRepo.getByIdAndVanID(m.getBenDetailsId(), a.getVanID());
					}
					if (m.getBenAccountID() != null) {
						benAccountOBJ = rMNCHBenAccountRepo.getByIdAndVanID(m.getBenAccountID(), a.getVanID());
					}
					if (m.getBenImageId() != null) {
						benImageOBJ = rMNCHBenImageRepo.getByIdAndVanID(m.getBenImageId().longValue(), a.getVanID());
					}
					if (m.getBenAddressId() != null) {
						benAddressOBJ = rMNCHBenAddressRepo.getByIdAndVanID(m.getBenAddressId(), a.getVanID());
					}
					if (m.getBenContactsId() != null) {
						benContactOBJ = rMNCHBenContactRepo.getByIdAndVanID(m.getBenContactsId(), a.getVanID());
					}

					BigInteger benID = null;
					if (m.getBenRegId() != null)
						benID = rMNCHMBenRegIdMapRepo.getBenIdFromRegID(m.getBenRegId().longValue());

					if (m.getBenRegId() != null) {
						benDetailsRMNCH_OBJ = rMNCHBeneficiaryDetailsRmnchRepo
								.getByRegID((m.getBenRegId()).longValue());
						benBotnBirthRMNCH_ROBJ = rMNCHBornBirthDetailsRepo.getByRegID((m.getBenRegId()).longValue());

						benCABCRMNCH_ROBJ = rMNCHCBACDetailsRepo.getByRegID((m.getBenRegId()).longValue());
						// 20-09-2021,start
						NCD_TB_HRP_data res = getHRP_NCD_TB_SuspectedStatus(m.getBenRegId().longValue(), authorisation,
								benDetailsOBJ);
						if (res != null && benCABCRMNCH_ROBJ != null) {
							if (res.getConfirmed_hrp() != null)
								benCABCRMNCH_ROBJ.setConfirmed_hrp(res.getConfirmed_hrp());
							if (res.getConfirmed_ncd() != null)
								benCABCRMNCH_ROBJ.setConfirmed_ncd(res.getConfirmed_ncd());
							if (res.getConfirmed_tb() != null)
								benCABCRMNCH_ROBJ.setConfirmed_tb(res.getConfirmed_tb());
							if (res.getConfirmed_ncd_diseases() != null)
								benCABCRMNCH_ROBJ.setConfirmed_ncd_diseases(res.getConfirmed_ncd_diseases());
							if (res.getDiagnosis_status() != null)
								benCABCRMNCH_ROBJ.setDiagnosis_status(res.getDiagnosis_status());
							benCABCRMNCH_ROBJ = rMNCHCBACDetailsRepo.save(benCABCRMNCH_ROBJ);

						}

						// 20-09-2021,end
						if (benDetailsRMNCH_OBJ != null && benDetailsRMNCH_OBJ.getHouseoldId() != null)
							benHouseHoldRMNCH_ROBJ = rMNCHHouseHoldDetailsRepo
									.getByHouseHoldID(benDetailsRMNCH_OBJ.getHouseoldId());

					}
					if (benDetailsRMNCH_OBJ == null)
						benDetailsRMNCH_OBJ = new RMNCHBeneficiaryDetailsRmnch();

					// new mapping 30-06-2021
					if (benDetailsOBJ.getMotherName() != null)
						benDetailsRMNCH_OBJ.setMotherName(benDetailsOBJ.getMotherName());
					if (benDetailsOBJ.getLiteracyStatus() != null)
						benDetailsRMNCH_OBJ.setLiteracyStatus(benDetailsOBJ.getLiteracyStatus());

					// bank
					if (benAccountOBJ.getNameOfBank() != null)
						benDetailsRMNCH_OBJ.setNameOfBank(benAccountOBJ.getNameOfBank());
					if (benAccountOBJ.getBranchName() != null)
						benDetailsRMNCH_OBJ.setBranchName(benAccountOBJ.getBranchName());
					if (benAccountOBJ.getIfscCode() != null)
						benDetailsRMNCH_OBJ.setIfscCode(benAccountOBJ.getIfscCode());
					if (benAccountOBJ.getBankAccount() != null)
						benDetailsRMNCH_OBJ.setBankAccount(benAccountOBJ.getBankAccount());

					// location
					if (benAddressOBJ.getCountyid() != null)
						benDetailsRMNCH_OBJ.setCountryId(benAddressOBJ.getCountyid());
					if (benAddressOBJ.getPermCountry() != null)
						benDetailsRMNCH_OBJ.setCountryName(benAddressOBJ.getPermCountry());

					if (benAddressOBJ.getStatePerm() != null)
						benDetailsRMNCH_OBJ.setStateId(benAddressOBJ.getStatePerm());
					if (benAddressOBJ.getPermState() != null)
						benDetailsRMNCH_OBJ.setStateName(benAddressOBJ.getPermState());

					if (benAddressOBJ.getDistrictidPerm() != null) {
						benDetailsRMNCH_OBJ.setDistrictid(benAddressOBJ.getDistrictidPerm());

					}
					if (benAddressOBJ.getDistrictnamePerm() != null) {
						benDetailsRMNCH_OBJ.setDistrictname(benAddressOBJ.getDistrictnamePerm());

					}

					if (benAddressOBJ.getPermSubDistrictId() != null)
						benDetailsRMNCH_OBJ.setBlockId(benAddressOBJ.getPermSubDistrictId());
					if (benAddressOBJ.getPermSubDistrict() != null)
						benDetailsRMNCH_OBJ.setBlockName(benAddressOBJ.getPermSubDistrict());

					if (benAddressOBJ.getVillageidPerm() != null)
						benDetailsRMNCH_OBJ.setVillageId(benAddressOBJ.getVillageidPerm());
					if (benAddressOBJ.getVillagenamePerm() != null)
						benDetailsRMNCH_OBJ.setVillageName(benAddressOBJ.getVillagenamePerm());

					if (benAddressOBJ.getPermServicePointId() != null)
						benDetailsRMNCH_OBJ.setServicePointID(benAddressOBJ.getPermServicePointId());
					if (benAddressOBJ.getPermServicePoint() != null)
						benDetailsRMNCH_OBJ.setServicePointName(benAddressOBJ.getPermServicePoint());

					if (benAddressOBJ.getPermZoneID() != null)
						benDetailsRMNCH_OBJ.setZoneID(benAddressOBJ.getPermZoneID());
					if (benAddressOBJ.getPermZone() != null)
						benDetailsRMNCH_OBJ.setZoneName(benAddressOBJ.getPermZone());

					if (benAddressOBJ.getPermAddrLine1() != null)
						benDetailsRMNCH_OBJ.setAddressLine1(benAddressOBJ.getPermAddrLine1());
					if (benAddressOBJ.getPermAddrLine2() != null)
						benDetailsRMNCH_OBJ.setAddressLine2(benAddressOBJ.getPermAddrLine2());
					if (benAddressOBJ.getPermAddrLine3() != null)
						benDetailsRMNCH_OBJ.setAddressLine3(benAddressOBJ.getPermAddrLine3());

					// related benids
					if (benDetailsRMNCH_OBJ.getRelatedBeneficiaryIdsDB() != null) {

						String[] relatedBenIDsString = benDetailsRMNCH_OBJ.getRelatedBeneficiaryIdsDB().split(",");
						Long[] relatedBenIDs = new Long[relatedBenIDsString.length];
						int pointer = 0;
						for (String s : relatedBenIDsString) {
							relatedBenIDs[pointer] = Long.valueOf(s);
							pointer++;
						}

						benDetailsRMNCH_OBJ.setRelatedBeneficiaryIds(relatedBenIDs);
					}

					if (benDetailsOBJ.getCommunity() != null)
						benDetailsRMNCH_OBJ.setCommunity(benDetailsOBJ.getCommunity());
					if (benDetailsOBJ.getCommunityId() != null)
						benDetailsRMNCH_OBJ.setCommunityId(benDetailsOBJ.getCommunityId());
					if (benContactOBJ.getPreferredPhoneNum() != null)
						benDetailsRMNCH_OBJ.setContact_number(benContactOBJ.getPreferredPhoneNum());

					if (benDetailsOBJ.getDob() != null)
						benDetailsRMNCH_OBJ.setDob(benDetailsOBJ.getDob());
					if (benDetailsOBJ.getFatherName() != null)
						benDetailsRMNCH_OBJ.setFatherName(benDetailsOBJ.getFatherName());
					if (benDetailsOBJ.getFirstName() != null)
						benDetailsRMNCH_OBJ.setFirstName(benDetailsOBJ.getFirstName());
					if (benDetailsOBJ.getGender() != null)
						benDetailsRMNCH_OBJ.setGender(benDetailsOBJ.getGender());
					if (benDetailsOBJ.getGenderId() != null)
						benDetailsRMNCH_OBJ.setGenderId(benDetailsOBJ.getGenderId());

					if (benDetailsOBJ.getMaritalstatus() != null)
						benDetailsRMNCH_OBJ.setMaritalstatus(benDetailsOBJ.getMaritalstatus());
					if (benDetailsOBJ.getMaritalstatusId() != null)
						benDetailsRMNCH_OBJ.setMaritalstatusId(benDetailsOBJ.getMaritalstatusId());
					if (benDetailsOBJ.getMarriageDate() != null)
						benDetailsRMNCH_OBJ.setMarriageDate(benDetailsOBJ.getMarriageDate());

					if (benDetailsOBJ.getReligion() != null)
						benDetailsRMNCH_OBJ.setReligion(benDetailsOBJ.getReligion());
					if (benDetailsOBJ.getReligionID() != null)
						benDetailsRMNCH_OBJ.setReligionID(benDetailsOBJ.getReligionID());
					if (benDetailsOBJ.getSpousename() != null)
						benDetailsRMNCH_OBJ.setSpousename(benDetailsOBJ.getSpousename());

					if (benImageOBJ != null && benImageOBJ.getUser_image() != null)
						benDetailsRMNCH_OBJ.setUser_image(benImageOBJ.getUser_image());

					// new fields
					benDetailsRMNCH_OBJ.setRegistrationDate(benDetailsOBJ.getCreatedDate());
					if (benID != null)
						benDetailsRMNCH_OBJ.setBenficieryid(benID.longValue());

					if (benDetailsOBJ.getLastName() != null)
						benDetailsRMNCH_OBJ.setLastName(benDetailsOBJ.getLastName());

					if (benDetailsRMNCH_OBJ.getCreatedBy() == null)
						if (benDetailsOBJ.getCreatedBy() != null)
							benDetailsRMNCH_OBJ.setCreatedBy(benDetailsOBJ.getCreatedBy());

					// age calculation
					String ageDetails = "";
					int age_val = 0;
					String ageUnit = null;
					if (benDetailsOBJ.getDob() != null) {

						Date date = new Date(benDetailsOBJ.getDob().getTime());
						Calendar cal = Calendar.getInstance();

						cal.setTime(date);

						int year = cal.get(Calendar.YEAR);
						int month = cal.get(Calendar.MONTH) + 1;
						int day = cal.get(Calendar.DAY_OF_MONTH);

						java.time.LocalDate todayDate = java.time.LocalDate.now();
						java.time.LocalDate birthdate = java.time.LocalDate.of(year, month, day);
						Period p = Period.between(birthdate, todayDate);

						int d = p.getDays();
						int mo = p.getMonths();
						int y = p.getYears();

						if (y > 0) {
							ageDetails = y + " years - " + mo + " months";
							age_val = y;
							ageUnit = (age_val > 1) ? "Years" : "Year";
						} else {
							if (mo > 0) {
								ageDetails = mo + " months - " + d + " days";
								age_val = mo;
								ageUnit = (age_val > 1) ? "Months" : "Month";
							} else {
								ageDetails = d + " days";
								age_val = d;
								ageUnit = (age_val > 1) ? "Days" : "Day";
							}
						}

					}

					benDetailsRMNCH_OBJ.setAgeFull(ageDetails);
					benDetailsRMNCH_OBJ.setAge(age_val);
					if (ageUnit != null)
						benDetailsRMNCH_OBJ.setAge_unit(ageUnit);

					resultMap = new HashMap<>();
					if (benHouseHoldRMNCH_ROBJ != null)
						resultMap.put("householdDetails", benHouseHoldRMNCH_ROBJ);
					else
						resultMap.put("householdDetails", new HashMap<String, Object>());

					if (benBotnBirthRMNCH_ROBJ != null)
						resultMap.put("bornbirthDeatils", benBotnBirthRMNCH_ROBJ);
					else
						resultMap.put("bornbirthDeatils", new HashMap<String, Object>());

					if (benCABCRMNCH_ROBJ != null)
						resultMap.put("cbacDetails", benCABCRMNCH_ROBJ);
					else
						resultMap.put("cbacDetails", new HashMap<String, Object>());

					resultMap.put("beneficiaryDetails", benDetailsRMNCH_OBJ);

					resultMap.put("houseoldId", benDetailsRMNCH_OBJ.getHouseoldId());
					resultMap.put("benficieryid", benDetailsRMNCH_OBJ.getBenficieryid());
					resultMap.put("BenRegId", m.getBenRegId());

					// adding asha id / created by - user id
					if (benAddressOBJ.getCreatedBy() != null) {
						Integer userID = rMNCHMBenMappingRepo.getUserIDByUserName(benAddressOBJ.getCreatedBy());
						if (userID != null && userID > 0)
							resultMap.put("ashaId", userID);
					}
					// get HealthID of ben
					if (m.getBenRegId() != null) {
						List<String> healthID = fetchHealthIdByBenRegID(m.getBenRegId().longValue(), authorisation);
						if (healthID != null)
							resultMap.put("HealthID", healthID);
					}
					resultMap.put("ProviderServiceMapID", benDetailsRMNCH_OBJ.getProviderServiceMapID());
					resultMap.put("VanID", m.getVanID());

					resultList.add(resultMap);

				} else {
					// mapping not available
				}
			} catch (Exception e) {
				logger.error("error for addressID :" + a.getId() + " and vanID : " + a.getVanID());
			}
		}

		Map<String, Object> response = new HashMap<>();
		response.put("data", resultList);
		response.put("pageSize", Integer.parseInt(door_to_door_page_size));
		response.put("totalPage", totalPage);
		return new Gson().toJson(response);
	}

	public List<String> fetchHealthIdByBenRegID(Long benRegID, String authorization) {
		Map<String, Long> requestMap = new HashMap<String, Long>();
		requestMap.put("beneficiaryRegID", benRegID);
		requestMap.put("beneficiaryID", null);
		JsonParser jsnParser = new JsonParser();
		HttpUtils utils = new HttpUtils();
		List<String> result = null;
		try {
			HashMap<String, Object> header = new HashMap<String, Object>();
			header.put("Authorization", authorization);
			String responseStr = utils.post(ConfigProperties.getPropertyByName("fhir-url") + "/"
					+ ConfigProperties.getPropertyByName("getHealthID"), new Gson().toJson(requestMap), header);
			JsonElement jsnElmnt = jsnParser.parse(responseStr);
			JsonObject jsnOBJ = new JsonObject();
			jsnOBJ = jsnElmnt.getAsJsonObject();
			if (jsnOBJ.get("data") != null && jsnOBJ.get("data").getAsJsonObject().get("BenHealthDetails") != null) {
				result = new ArrayList<String>();
				BenHealthIDDetails[] ben = InputMapper.gson().fromJson(
						new Gson().toJson(jsnOBJ.get("data").getAsJsonObject().get("BenHealthDetails")),
						BenHealthIDDetails[].class);
				for (BenHealthIDDetails value : ben) {
					if (value.getHealthId() != null)
						result.add(value.getHealthId());
				}

			}

		} catch (Exception e) {
			logger.info("Error while fetching ABHA" + e.getMessage());
			return null;
		}

		return result;

	}

	public NCD_TB_HRP_data getHRP_NCD_TB_SuspectedStatus(Long benRegID, String authorization,
			RMNCHMBeneficiarydetail benDetails) throws IEMRException {
		NCD_TB_HRP_data response = null;
		try {

			if (benRegID != null) {
				List<Object[]> obj = rMNCHCBACDetailsRepo.getVisitDetailsbyRegID(benRegID);
				if (obj != null && obj.size() > 0) {
					response = new NCD_TB_HRP_data();
					Long visitCode = (((BigInteger) obj.get(0)[0])).longValue();
					String visitCategory = (String) obj.get(0)[1];
					switch (visitCategory) {
					case "General OPD":
						response = getConfirmedNCD_TB_Common(benRegID, visitCode);
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;
					case "General OPD (QC)":
						response = getConfirmedNCD_TB_Common(benRegID, visitCode);
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;
					case "PNC":
						response = getConfirmedNCD_TB_PNC(benRegID, visitCode);
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;
					case "ANC":
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;
					case "NCD care":
						response = getConfirmedNCD_TB_NCD_CARE(benRegID, visitCode);
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;
					case "NCD screening":
						response = getConfirmedNCD_TB_Common(benRegID, visitCode);
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;
					case "COVID-19 Screening":
						response = getConfirmedNCD_TB_Common(benRegID, visitCode);
						response.setConfirmed_hrp(getConfirmedHRP(benRegID, visitCode, authorization, benDetails));
						break;

					default:
					}
				}

			}
		} catch (Exception e) {
			logger.info("Error while getting confirmed status" + e.getMessage());
			throw new IEMRException("Error while getting confirmed status" + e.getMessage());

		}
		return response;
	}

	public String getConfirmedHRP(Long benRegID, Long visitCode, String authorization,
			RMNCHMBeneficiarydetail benDetails) throws IEMRException {
		String isHRP = "Pending";
		Map<String, Long> requestMap = new HashMap<String, Long>();
		requestMap.put("benRegID", benRegID);
		requestMap.put("visitCode", visitCode);
		JsonParser jsnParser = new JsonParser();
		HttpUtils utils = new HttpUtils();
		try {
			if (benDetails != null && benDetails.getGender() != null
					&& benDetails.getGender().equalsIgnoreCase("female")) {
				HashMap<String, Object> header = new HashMap<String, Object>();
				header.put("Authorization", authorization);
				String responseStr = utils.post(
						ConfigProperties.getPropertyByName("tm-url") + "/"
								+ ConfigProperties.getPropertyByName("get-HRP-Status"),
						new Gson().toJson(requestMap), header);
				JsonElement jsnElmnt = jsnParser.parse(responseStr);
				JsonObject jsnOBJ = new JsonObject();
				jsnOBJ = jsnElmnt.getAsJsonObject();
				if (jsnOBJ.get("data") != null && jsnOBJ.get("data").getAsJsonObject().get("isHRP") != null) {
					if (jsnOBJ.get("data").getAsJsonObject().get("isHRP").getAsBoolean())
						isHRP = "Yes";
					else
						isHRP = "No";
				}

			} else
				isHRP = "No";
		} catch (Exception e) {
			logger.info("Error while getting confirmed HRP status" + e.getMessage());
			throw new IEMRException("Error while getting confirmed HRP status" + e.getMessage());

		}

		return isHRP;

	}

	public NCD_TB_HRP_data getConfirmedNCD_TB_PNC(Long benRegID, Long visitCode) throws IEMRException {
		NCD_TB_HRP_data response = new NCD_TB_HRP_data();
		String dp = null;
		if (visitCode != null && benRegID != null) {
			try {
				List<Object> obj = rMNCHCBACDetailsRepo.getDiagnosisProvidedPNC(benRegID, visitCode);
				if (obj != null && obj.size() > 0 && obj.get(0) != null) {
					dp = obj.get(0).toString();
					if (dp != null) {
						String diagnosis[] = dp.split(Pattern.quote("||"));
						if (diagnosis != null && diagnosis.length > 0) {
							StringBuffer sb = new StringBuffer();
							for (String s : diagnosis) {
								if (s.equalsIgnoreCase("Tuberculosis")) {
									response.setConfirmed_tb("Yes");
									response.setDiagnosis_status("Yes");
								} else {
									if (response.getConfirmed_tb() != null
											&& !response.getConfirmed_tb().equalsIgnoreCase("Yes"))
										response.setConfirmed_tb("No");
									response.setDiagnosis_status("Yes");
								}
								if (s.equalsIgnoreCase("Diabetes mellitus") || s.equalsIgnoreCase("Hypertension")
										|| s.equalsIgnoreCase("Breast cancer")
										|| s.equalsIgnoreCase("Mental health disorder")
										|| s.equalsIgnoreCase("Oral cancer")) {

									response.setConfirmed_ncd("Yes");
									response.setDiagnosis_status("Yes");
									sb.append(s).append(",");

								} else {
									if (response.getConfirmed_ncd() != null
											&& !response.getConfirmed_ncd().equalsIgnoreCase("Yes"))
										response.setConfirmed_ncd("No");
									response.setDiagnosis_status("Yes");

								}

							}
							if (sb.length() > 1)
								response.setConfirmed_ncd_diseases(sb.substring(0, sb.length() - 1));
						}

					}
				}
			} catch (Exception e) {
				logger.info("Error while getting confirmed NCD status" + e.getMessage());
				throw new IEMRException("Error while getting confirmed NCD status" + e.getMessage());

			}
		}
		if (response != null && response.getDiagnosis_status() == null)
			response.setDiagnosis_status("Pending");
		return response;
	}

	public NCD_TB_HRP_data getConfirmedNCD_TB_Common(Long benRegID, Long visitCode) throws IEMRException {
		NCD_TB_HRP_data response = new NCD_TB_HRP_data();
		String dp = null;
		if (visitCode != null && benRegID != null) {
			try {
				List<Object> obj = rMNCHCBACDetailsRepo.getDiagnosisProvidedCommon(benRegID, visitCode);
				if (obj != null && obj.size() > 0 && obj.get(0) != null) {
					dp = obj.get(0).toString();
					if (dp != null) {
						String diagnosis[] = dp.split(Pattern.quote("||"));
						if (diagnosis != null && diagnosis.length > 0) {
							StringBuffer sb = new StringBuffer();
							for (String s : diagnosis) {

								if (s.equalsIgnoreCase("Tuberculosis")) {
									response.setConfirmed_tb("Yes");
									response.setDiagnosis_status("Yes");
								} else {
									if (response.getConfirmed_tb() != null
											&& !response.getConfirmed_tb().equalsIgnoreCase("Yes"))
										response.setConfirmed_tb("No");
									response.setDiagnosis_status("Yes");
								}
								if (s.equalsIgnoreCase("Diabetes mellitus") || s.equalsIgnoreCase("Hypertension")
										|| s.equalsIgnoreCase("Breast cancer")
										|| s.equalsIgnoreCase("Mental health disorder")
										|| s.equalsIgnoreCase("Oral cancer")) {

									response.setConfirmed_ncd("Yes");
									response.setDiagnosis_status("Yes");

									sb.append(s).append(",");

								} else {
									if (response.getConfirmed_ncd() != null
											&& !response.getConfirmed_ncd().equalsIgnoreCase("Yes"))
										response.setConfirmed_ncd("No");
									response.setDiagnosis_status("Yes");
								}

							}
							if (sb.length() > 1)
								response.setConfirmed_ncd_diseases(sb.substring(0, sb.length() - 1));

						}

					}
				}
			} catch (Exception e) {
				logger.info("Error while getting confirmed NCD status" + e.getMessage());
				throw new IEMRException("Error while getting confirmed NCD status" + e.getMessage());

			}
		}
		if (response != null && response.getDiagnosis_status() == null)
			response.setDiagnosis_status("Pending");
		return response;
	}

	public NCD_TB_HRP_data getConfirmedNCD_TB_NCD_CARE(Long benRegID, Long visitCode) throws IEMRException {
		NCD_TB_HRP_data response = new NCD_TB_HRP_data();
		String dp = null;
		if (visitCode != null && benRegID != null) {
			try {
				List<Object> obj = rMNCHCBACDetailsRepo.getDiagnosisProvidedNCD_Care(benRegID, visitCode);
				if (obj != null && obj.size() > 0 && obj.get(0) != null) {
					dp = obj.get(0).toString();
					if (dp != null) {
						String diagnosis[] = dp.split(Pattern.quote("||"));
						if (diagnosis != null && diagnosis.length > 0) {
							StringBuffer sb = new StringBuffer();
							for (String s : diagnosis) {

								if (s.equalsIgnoreCase("Tuberculosis")) {
									response.setConfirmed_tb("Yes");
									response.setDiagnosis_status("Yes");
								} else {
									if (response.getConfirmed_tb() != null
											&& !response.getConfirmed_tb().equalsIgnoreCase("Yes"))
										response.setConfirmed_tb("No");
									response.setDiagnosis_status("Yes");
								}
								if (s.equalsIgnoreCase("Diabetes mellitus") || s.equalsIgnoreCase("Hypertension")
										|| s.equalsIgnoreCase("Breast cancer")
										|| s.equalsIgnoreCase("Mental health disorder")
										|| s.equalsIgnoreCase("Oral cancer")) {

									response.setConfirmed_ncd("Yes");
									response.setDiagnosis_status("Yes");

									sb.append(s).append(",");

								} else {
									if (response.getConfirmed_ncd() != null
											&& !response.getConfirmed_ncd().equalsIgnoreCase("Yes"))
										response.setConfirmed_ncd("No");
									if (!response.getDiagnosis_status().equalsIgnoreCase("Yes"))
										response.setDiagnosis_status("Yes");
								}

							}
							if (sb.length() > 1)
								response.setConfirmed_ncd_diseases(sb.substring(0, sb.length() - 1));

						}

					}
				}
			} catch (Exception e) {
				logger.info("Error while getting confirmed NCD status" + e.getMessage());
				throw new IEMRException("Error while getting confirmed NCD status" + e.getMessage());

			}
		}
		if (response != null && response.getDiagnosis_status() == null)
			response.setDiagnosis_status("Pending");
		return response;
	}

}
