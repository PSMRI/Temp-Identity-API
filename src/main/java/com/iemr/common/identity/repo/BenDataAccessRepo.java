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
package com.iemr.common.identity.repo;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.identity.domain.TBendataaccess;

@Repository
public interface BenDataAccessRepo extends CrudRepository<TBendataaccess, BigInteger>
{
	List<TBendataaccess> findByAccessIdOrderByAccessIdAsc(BigInteger accessId);

	List<TBendataaccess> findByUserAgentIdOrderByAccessIdAsc(Integer userAgentId);

	List<TBendataaccess> findByUserAgentIdAndAccessedOnBetweenOrderByAccessIdAsc(Integer userAgentId,
			Timestamp fromDate, Timestamp toDate);

	// commented as userAgentIpAddr is unknown column
	// List<TBendataaccess> findByUserAgentIpAddr(String userAgentIpAddr);
	// List<TBendataaccess> findByUserAgentIpAddrAndAccessedOnBetween(String userAgentIpAddr, Timestamp fromDate,
	// Timestamp toDate);
	// List<TBendataaccess> findByUserAgentIdAndUserAgentIpAddr(Integer userAgentId, String userAgentIpAddr);
	// List<TBendataaccess> findByUserAgentIdAndUserAgentIpAddrAndAccessedOnBetween(Integer userAgentId, String
	// userAgentIpAddr, Timestamp fromDate, Timestamp toDate);

	List<TBendataaccess> findByUserAgentPSMapIdOrderByAccessIdAsc(Integer userAgentPSMapId);

	List<TBendataaccess> findByUserAgentRoleIdOrderByAccessIdAsc(Integer userAgentRoleId);

	List<TBendataaccess> findByUserAgentServiceIdOrderByAccessIdAsc(Integer userAgentServiceId);
	// List<TBendataaccess> findByUserAgentStateId(Integer userAgentStateId);
	// List<TBendataaccess> findByUserAgentServiceProviderId(Integer userAgentServiceProviderId);

	List<TBendataaccess> findByUserAgentPSMapIdAndAccessedOnBetweenOrderByAccessIdAsc(Integer userAgentPSMapId,
			Timestamp fromDate, Timestamp toDate);

	List<TBendataaccess> findByUserAgentRoleIdAndAccessedOnBetweenOrderByAccessIdAsc(Integer userAgentRoleId,
			Timestamp fromDate, Timestamp toDate);

	List<TBendataaccess> findByUserAgentServiceIdAndAccessedOnBetweenOrderByAccessIdAsc(Integer userAgentServiceId,
			Timestamp fromDate, Timestamp toDate);
	// List<TBendataaccess> findByUserAgentStateIdAndAccessedOnBetween(Integer userAgentStateId, Timestamp fromDate,
	// Timestamp toDate);
	// List<TBendataaccess> findByUserAgentServiceProviderIdAndAccessedOnBetween(Integer userAgentServiceProviderId,
	// Timestamp fromDate, Timestamp toDate);

	Long countByUserAgentIdAndAccessedOnBetweenOrderByAccessIdAsc(Integer userAgentId, Timestamp fromDate, Timestamp toDate);
	// Long countByUserAgentIpAddrAndAccessedOnBetween(String userAgentIpAddr, Timestamp fromDate, Timestamp toDate);
	// Long countByUserAgentIdAndUserAgentIpAddrAndAccessedOnBetween(Integer userAgentId, String userAgentIpAddr,
	// Timestamp fromDate, Timestamp toDate);

	Long countByUserAgentPSMapId(Integer userAgentPSMapId);

	Long countByUserAgentRoleId(Integer userAgentRoleId);

	Long countByUserAgentServiceId(Integer userAgentServiceId);

	// Long countByUserAgentStateId(Integer userAgentStateId);
	// Long countByUserAgentServiceProviderId(Integer userAgentServiceProviderId);
	Long countByUserAgentPSMapIdAndAccessedOnBetween(Integer userAgentPSMapId, Timestamp fromDate, Timestamp toDate);

	Long countByUserAgentRoleIdAndAccessedOnBetween(Integer userAgentRoleId, Timestamp fromDate, Timestamp toDate);

	Long countByUserAgentServiceIdAndAccessedOnBetween(Integer userAgentServiceId, Timestamp fromDate,
			Timestamp toDate);
	// Long countByUserAgentStateIdAndAccessedOnBetween(Integer userAgentStateId, Timestamp fromDate, Timestamp toDate);
	// Long countByUserAgentServiceProviderIdAndAccessedOnBetween(Integer userAgentServiceProviderId, Timestamp
	// fromDate, Timestamp toDate);

	List<TBendataaccess> findByaccessedOnBetweenOrderByAccessIdAsc(Timestamp fromDate, Timestamp toDate);
}
