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

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.common.identity.domain.MBeneficiaryImage;

public interface MBeneficiaryImageRepo extends CrudRepository<MBeneficiaryImage, Long> {
	@Query("select t from MBeneficiaryImage t where t.vanSerialNo = :benImageID AND t.vanID = :vanID ")
	MBeneficiaryImage getBenImageByBenImageID(@Param("benImageID") Long benImageID, @Param("vanID") Integer vanID);

	@Transactional
	@Modifying
	@Query(" UPDATE MBeneficiaryImage set vanSerialNo = :BenImageId WHERE BenImageId = :BenImageId")
	int updateVanSerialNo(@Param("BenImageId") Long BenImageId);

	@Query("SELECT benImageId FROM MBeneficiaryImage WHERE vanSerialNo =:vanSerialNo AND vanID =:vanID ")
	Long findIdByVanSerialNoAndVanID(@Param("vanSerialNo") Long vanSerialNo, @Param("vanID") Integer vanID);

	@Query("SELECT a FROM MBeneficiaryImage a WHERE a.vanSerialNo =:vanSerialNo AND a.vanID =:vanID ")
	MBeneficiaryImage getWith_vanSerialNo_vanID(@Param("vanSerialNo") Long vanSerialNo,
			@Param("vanID") Integer vanID);
}
