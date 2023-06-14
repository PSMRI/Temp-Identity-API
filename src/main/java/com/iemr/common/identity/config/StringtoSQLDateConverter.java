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
