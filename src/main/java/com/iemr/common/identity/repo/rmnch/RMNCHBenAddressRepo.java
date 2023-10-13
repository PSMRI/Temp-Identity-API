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
package com.iemr.common.identity.repo.rmnch;

import java.math.BigInteger;
import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiaryaddress;

@Repository
public interface RMNCHBenAddressRepo extends JpaRepository<RMNCHMBeneficiaryaddress, Long> {
	@Query(" SELECT t FROM RMNCHMBeneficiaryaddress t WHERE t.id = :vanSerialNo AND t.VanID = :vanID")
	public RMNCHMBeneficiaryaddress getByIdAndVanID(@Param("vanSerialNo") BigInteger vanSerialNo,
			@Param("vanID") int vanID);

	@Query(" SELECT t FROM RMNCHMBeneficiaryaddress t WHERE t.villageidPerm = :villageidPerm "
			+ " AND t.VanID NOT IN (1,2,3,4,5,6,7,8,9) ")
	public Page<RMNCHMBeneficiaryaddress> getBenData(@Param("villageidPerm") Integer villageidPerm, Pageable pageable);

	@Query(" SELECT t FROM RMNCHMBeneficiaryaddress t WHERE DATE(t.createdDate) BETWEEN DATE(:fromDate) "
			+ " AND DATE(:toDate) AND t.villageidPerm = :villageidPerm " + " AND t.VanID NOT IN (1,2,3,4,5,6,7,8,9) ")
	public Page<RMNCHMBeneficiaryaddress> getBenDataFilteredWithDateRange(@Param("villageidPerm") Integer villageidPerm,
			@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate, Pageable pageable);

	@Query(" SELECT t FROM RMNCHMBeneficiaryaddress t WHERE t.createdBy = :userName "
			+ " AND t.VanID NOT IN (1,2,3,4,5,6,7,8,9) ")
	public Page<RMNCHMBeneficiaryaddress> getBenDataByAsha(@Param("userName") String userName, Pageable pageable);

	@Query(" SELECT t FROM RMNCHMBeneficiaryaddress t WHERE DATE(t.createdDate) BETWEEN DATE(:fromDate) "
			+ " AND DATE(:toDate) AND t.createdBy = :userName " + " AND t.VanID NOT IN (1,2,3,4,5,6,7,8,9) ")
	public Page<RMNCHMBeneficiaryaddress> getBenDataByAshaFilteredWithDateRange(@Param("userName") String userName,
			@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate, Pageable pageable);

	@Query(nativeQuery = true, value = " select UserName from db_iemr.m_user where  UserID = :ashaId and deleted is false ")
	public String getUserNameForAsha(@Param("ashaId") Integer ashaId);
}
