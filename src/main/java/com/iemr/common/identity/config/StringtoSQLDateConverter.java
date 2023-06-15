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
package com.iemr.common.identity.config;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringtoSQLDateConverter implements Converter<String, java.sql.Timestamp> {

	private static final Logger logger = LoggerFactory.getLogger(StringtoSQLDateConverter.class);

	@Override
	public Timestamp convert(String arg0) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp timestamp = null;
		try {
			if (arg0 != null) {
				Date parsedDate = dateFormat.parse(arg0);
				if (parsedDate != null) {
					timestamp = new Timestamp(parsedDate.getTime());
				}
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return timestamp;
	}

}
