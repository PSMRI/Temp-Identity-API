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
package com.iemr.common.identity.controller.rmnch;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.identity.service.rmnch.RmnchDataSyncService;
import com.iemr.common.identity.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @apiNote API will be exposed to public domain for RMNCH mobile data sync to
 *          AMRIT platform
 */
@RestController
@RequestMapping(value = "/rmnch", headers = "Authorization")
public class RMNCHMobileAppController {

	private Logger logger = LoggerFactory.getLogger(RMNCHMobileAppController.class);

	@Autowired
	@Qualifier("rmnchServiceImpl")
	RmnchDataSyncService rmnchDataSyncService;

	@RequestMapping(value = "/syncDataToAmrit", method = RequestMethod.POST)
	@ApiOperation(value = "Sync data to AMRIT for already regestered beneficiary with AMRIT beneficiary id ", consumes = "application/json", produces = "application/json")
	public String syncDataToAmrit(@ApiParam(value = "{\r\n" + "  \"beneficiaryDetails\": [\r\n" + "    {\r\n"
			+ "      \"BenRegId\": \"Long\",\r\n" + "      \"Countyid\": \"Integer\",\r\n"
			+ "      \"Processed\": \"String\",\r\n" + "      \"ProviderServiceMapID\": \"Integer\",\r\n"
			+ "      \"VanID\": \"Integer\",\r\n" + "      \"aadhaNo\": \"String\",\r\n"
			+ "      \"aadha_noId\": \"Integer\",\r\n" + "      \"age\": \"Integer\",\r\n"
			+ "      \"age_unit\": \"String\",\r\n" + "      \"age_unitId\": \"Integer\",\r\n"
			+ "      \"bankAccount\": \"String\",\r\n" + "      \"bank_accountId\": \"Integer\",\r\n"
			+ "      \"benficieryid\": \"Long\",\r\n" + "      \"childRegisteredAWCID\": \"Long\",\r\n"
			+ "      \"childRegisteredSchoolID\": \"Integer\",\r\n" + "      \"createdBy\": \"String\",\r\n"
			+ "      \"createdDate\": \"Timestamp\",\r\n" + "      \"currSubDistrictId\": \"Integer\",\r\n"
			+ "      \"facilitySectionID\": \"Integer\",\r\n" + "      \"familyHeadRelation\": \"String\",\r\n"
			+ "      \"familyHeadRelationPosition\": \"Integer\",\r\n" + "      \"guidelineId\": \"String\",\r\n"
			+ "      \"houseoldId\": \"Long\",\r\n" + "      \"id\": \"Long\",\r\n"
			+ "      \"ifscCode\": \"String\",\r\n" + "      \"lastDeliveryConductedID\": \"Integer\",\r\n"
			+ "      \"latitude\": \"Decimal\",\r\n" + "      \"lengthofMenstrualCycleId\": \"Integer\",\r\n"
			+ "      \"literacyId\": \"Integer\",\r\n" + "      \"longitude\": \"Decimal\",\r\n"
			+ "      \"marriageDate\": \"Timestamp\",\r\n" + "      \"menstrualBFDId\": \"Integer\",\r\n"
			+ "      \"menstrualProblemId\": \"Integer\",\r\n" + "      \"menstrualStatusId\": \"Integer\",\r\n"
			+ "      \"mobileOthers\": \"String\",\r\n" + "      \"mobilenoofRelation\": \"String\",\r\n"
			+ "      \"mobilenoofRelationId\": \"Integer\",\r\n" + "      \"nameOfBank\": \"String\",\r\n"
			+ "      \"ncd_priority\": \"Integer\",\r\n" + "      \"need_opcareId\": \"Integer\",\r\n"
			+ "      \"previousLiveBirth\": \"String\",\r\n" + "      \"rchid\": \"String\",\r\n"
			+ "      \"registrationDate\": \"Timestamp\",\r\n" + "      \"registrationType\": \"String\",\r\n"
			+ "      \"regularityofMenstrualCycleId\": \"Integer\",\r\n" + "      \"religionOthers\": \"String\",\r\n"
			+ "      \"reproductiveStatus\": \"String\",\r\n" + "      \"reproductiveStatusId\": \"Integer\",\r\n"
			+ "      \"serverUpdatedStatus\": \"Integer\",\r\n" + "      \"typeofSchoolID\": \"Integer\",\r\n"
			+ "      \"villagename\": \"String\",\r\n" + "      \"whoConductedDeliveryID\": \"Integer\",\r\n"
			+ "      \"hrpStatus\": \"Boolean\",\r\n" + "      \"immunization\": \"Boolean\",\r\n"
			+ "      \"nishchayPregnancyStatus\": \"String\",\r\n"
			+ "      \"nishchayPregnancyStatusPosition\": \"Integer\",\r\n"
			+ "      \"nishchayDeliveryStatus\": \"String\",\r\n"
			+ "      \"nishchayDeliveryStatusPosition\": \"Integer\",\r\n" + "      \"relatedBeneficiaryIds\": [\r\n"
			+ "        \"Long\"\r\n" + "      ],\r\n"
			+ "		\"beneficiaryRegID\":\"Long\",\"firstName\":\"String\",\"lastName\":\"String\",\"\n"
			+ "		\"dob\":\"Timestamp\",\"fatherName\":\"String\",\"spouseName\":\"String\",\"\n"
			+ "		\"govtIdentityNo\":\"String\",\"govtIdentityTypeID\":\"Integer\",\"emergencyRegistration\":\"Boolean\",\"\n"
			+ "		\"maritalstatusId\":\"Short\",\"maritalstatus\":\"String\",\"gender\":\"String\",\"genderId\":\"Integer\",\"i_bendemographics\":{\"educationID\":\"Long\",\"\n"
			+ "		\"beneficiaryRegID\":\"Long\",\"occupationID\":\"Integer\",\"healthCareWorkerID\":\"Short\",\"incomeStatusID\":\"Integer\",\"\n"
			+ "		\"communityID\":\"Integer\",\"preferredLangID\":\"Integer\",\"districtID\":\"Integer\",\"stateID\":\"Integer\",\"\n"
			+ "		\"pinCode\":\"String\",\"blockID\":\"Integer\",\"districtBranchID\":\"Integer\",\"createdBy\":\"String\",\"addressLine1\":\"String\"},\"\n"
			+ "		\"benPhoneMaps\":{\"parentBenRegID\":\"Long\",\"phoneNo\":\"String\",\"phoneTypeID\":\"Integer\",\"benRelationshipID\":\"Integer\",\"\n"
			+ "		\"deleted\":\"Boolean\",\"createdBy\":\"String\"},\"\n"
			+ "    }\r\n" + "  ],\r\n" + "  \"bornBirthDeatils\": [\r\n"
			+ "    {\r\n" + "      \"BenRegId\": \"Long\",\r\n" + "      \"Countyid\": \"Integer\",\r\n"
			+ "      \"Processed\": \"String\",\r\n" + "      \"ProviderServiceMapID\": \"Integer\",\r\n"
			+ "      \"VanID\": \"Integer\",\r\n" + "      \"bcdBatchNo\": \"String\",\r\n"
			+ "      \"benficieryid\": \"Integer\",\r\n" + "      \"birthDefects\": \"String\",\r\n"
			+ "      \"birthDefectsOthers\": \"String\",\r\n" + "      \"birthDefectsid\": \"Integer\",\r\n"
			+ "      \"birthDosage\": \"String\",\r\n" + "      \"birthDosageid\": \"Integer\",\r\n"
			+ "      \"birthPlace\": \"String\",\r\n" + "      \"birthPlaceid\": \"Integer\",\r\n"
			+ "      \"childName\": \"String\",\r\n" + "      \"complecations\": \"String\",\r\n"
			+ "      \"complecationsOther\": \"String\",\r\n" + "      \"complecationsid\": \"Integer\",\r\n"
			+ "      \"conductedDelivery\": \"String\",\r\n" + "      \"conductedDeliveryOther\": \"String\",\r\n"
			+ "      \"conductedDeliveryid\": \"Integer\",\r\n"
			+ "      \"corticosteroidGivenMotherid\": \"Integer\",\r\n" + "      \"createdBy\": \"String\",\r\n"
			+ "      \"createdDate\": \"Timestamp\",\r\n" + "      \"criedImmediately\": \"String\",\r\n"
			+ "      \"criedImmediatelyid\": \"Integer\",\r\n" + "      \"deliveryType\": \"String\",\r\n"
			+ "      \"deliveryTypeOther\": \"String\",\r\n" + "      \"deliveryTypeid\": \"Integer\",\r\n"
			+ "      \"districtid\": \"Integer\",\r\n" + "      \"districtname\": \"String\",\r\n"
			+ "      \"facilityOther\": \"String\",\r\n" + "      \"facilityid\": \"Integer\",\r\n"
			+ "      \"feedingStarted\": \"String\",\r\n" + "      \"feedingStartedid\": \"Integer\",\r\n"
			+ "      \"gestationalAgeid\": \"Integer\",\r\n" + "      \"heightAtBirth\": \"Integer\",\r\n"
			+ "      \"hptdBatchNo\": \"String\",\r\n" + "      \"id\": \"Integer\",\r\n"
			+ "      \"motherBenId\": \"Integer\",\r\n" + "      \"motherName\": \"String\",\r\n"
			+ "      \"motherposition\": \"Integer\",\r\n" + "      \"opvBatchNo\": \"String\",\r\n"
			+ "      \"placeName\": \"String\",\r\n" + "      \"serverUpdatedStatus\": \"Integer\",\r\n"
			+ "      \"stateid\": \"Integer\",\r\n" + "      \"term\": \"String\",\r\n"
			+ "      \"termid\": \"Integer\",\r\n" + "      \"villageid\": \"Integer\",\r\n"
			+ "      \"vitaminkBatchNo\": \"String\",\r\n" + "      \"weightAtBirth\": \"Decimal\"\r\n" + "    }\r\n"
			+ "  ]\r\n" + "}") @RequestBody String requestOBJ) {
		OutputResponse response = new OutputResponse();
		try {
			if (requestOBJ != null) {
				logger.info("request object with timestamp : " + new Timestamp(System.currentTimeMillis()) + " "
						+ requestOBJ);
				String s = rmnchDataSyncService.syncDataToAmrit(requestOBJ);
				response.setResponse(s);
			} else
				response.setError(5000, "Invalid/NULL request obj");
		} catch (Exception e) {
			logger.error("Error in RMNCH mobile data sync : " + e);
			response.setError(5000, "Error in RMNCH mobile data sync : " + e);
		}
		return response.toString();

	}

//	@Deprecated
	@RequestMapping(value = "/getBeneficiaryDataForVillage", method = RequestMethod.POST)
	@ApiOperation(value = "Get beneficiary data for given village ", consumes = "application/json", produces = "application/json")
	public String getBeneficiaryData(
			@ApiParam(value = "{\r\n" + "\"villageID\":\"Integer\",\r\n" + "\"fromDate\":\"DateTime\",\r\n"
					+ "\"toDate\":\"DateTime\",\r\n" + "\"pageNo\":\"Integer\"\r\n"
					+ "}") @RequestBody String requestOBJ,
			@RequestHeader(value = "Authorization") String authorization) {
		OutputResponse response = new OutputResponse();
		try {
			if (requestOBJ != null) {
				logger.info("request object with timestamp : " + new Timestamp(System.currentTimeMillis()) + " "
						+ requestOBJ);
				String s = rmnchDataSyncService.getBenData(requestOBJ, authorization);
				if (s != null)
					response.setResponse(s);
				else
					response.setError(5000, "No record found");
			} else
				response.setError(5000, "Invalid/NULL request obj");
		} catch (Exception e) {
			logger.error("Error in get data : " + e);
			response.setError(5000, "Error in get data : " + e);
		}
		return response.toString();

	}

	@RequestMapping(value = "/getBeneficiaryDataForAsha", method = RequestMethod.POST)
	@ApiOperation(value = "get beneficiary data for given village ", consumes = "application/json", produces = "application/json")
	public String getBeneficiaryDataByAsha(
			@ApiParam(value = "{\r\n" + "\"AshaId\":\"Integer\",\r\n" + "\"fromDate\":\"DateTime\",\r\n"
					+ "\"toDate\":\"DateTime\",\r\n" + "\"pageNo\":\"Integer\"\r\n"
					+ "}") @RequestBody String requestOBJ,
			@RequestHeader(value = "Authorization") String authorization) {
		OutputResponse response = new OutputResponse();
		try {
			if (requestOBJ != null) {
				logger.info("request object with timestamp : " + new Timestamp(System.currentTimeMillis()) + " "
						+ requestOBJ);
				String s = rmnchDataSyncService.getBenDataByAsha(requestOBJ, authorization);
				if (s != null)
					response.setResponse(s);
				else
					response.setError(5000, "No record found");
			} else
				response.setError(5000, "Invalid/NULL request obj");
		} catch (Exception e) {
			logger.error("Error in get data : " + e);
			response.setError(5000, "Error in get data : " + e);
		}
		return response.toString();

	}
}
