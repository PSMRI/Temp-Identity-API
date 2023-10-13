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
package com.iemr.common.identity.controller.familyTagging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.common.identity.service.familyTagging.FamilyTagService;
import com.iemr.common.identity.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/family" })
public class FamilyTaggingController {
	private Logger logger = LoggerFactory.getLogger(FamilyTaggingController.class);
	@Autowired
	private FamilyTagService familyTagService;

	@CrossOrigin()
	@ApiOperation(value = "Create and modify family tagging", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/addTag" }, method = { RequestMethod.POST })
	public String saveFamilyTagging(@RequestBody String comingReq) {
		String s;
		OutputResponse response = new OutputResponse();
		try {
			s = familyTagService.addTag(comingReq);
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in saving family tagging" + e);
			response.setError(5000, "Error in saving family tagging : " + e.getLocalizedMessage());
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Create family", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/createFamily" }, method = { RequestMethod.POST })
	public String createFamily(@RequestBody String comingReq) {
		String s;
		OutputResponse response = new OutputResponse();
		try {
			s = familyTagService.createFamily(comingReq);
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in saving family tagging" + e);
			response.setError(5000, "Error in saving family tagging : " + e.getLocalizedMessage());
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Search family", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/searchFamily" }, method = { RequestMethod.POST })
	public String searchFamily(@RequestBody String comingReq) {
		String s;
		OutputResponse response = new OutputResponse();
		try {
			s = familyTagService.searchFamily(comingReq);
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in searching family" + e);
			response.setError(5000, "Error in searching family : " + e.getLocalizedMessage());
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get family members details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getFamilyDetails" }, method = { RequestMethod.POST })
	public String getFamilyDatails(@RequestBody String comingReq) {
		String s;
		OutputResponse response = new OutputResponse();
		try {
			s = familyTagService.getFamilyDetails(comingReq);
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in searching family members" + e);
			response.setError(5000, "Error in searching family members : " + e.getLocalizedMessage());
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Untag beneficiary from a family", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/untag" }, method = { RequestMethod.POST })
	public String untagFamily(@RequestBody String comingReq) {
		String s;
		OutputResponse response = new OutputResponse();
		try {
			s = familyTagService.doFamilyUntag(comingReq);
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in untagging family" + e);
			response.setError(5000, "Error in untagging family : " + e.getLocalizedMessage());
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Edit beneficiary family details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/editFamilyTagging" }, method = { RequestMethod.POST })
	public String editFamilyDetails(@RequestBody String comingReq) {
		String s;
		OutputResponse response = new OutputResponse();
		try {
			s = familyTagService.editFamilyDetails(comingReq);
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in editing family details : " + e);
			response.setError(5000, "Error in editing family details : " + e.getLocalizedMessage());
		}
		return response.toString();
	}

}
