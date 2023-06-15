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
package com.iemr.common.identity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.common.identity.controller.IdentityController;

public class Utilities {
	//private static final Logger logger = LoggerFactory.getLogger(Utilities.class);
	
	/**
	 * Gets the json as string.
	 *
	 * @param obj the obj
	 * @return the json as string
	 */
	private Logger logger = LoggerFactory.getLogger(IdentityController.class);
	public String getJsonAsString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}
		
		return sb.toString();
	}

}
