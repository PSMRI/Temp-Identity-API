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

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.common.identity.domain.MBeneficiarydetail;

import jakarta.transaction.Transactional;

@Repository
public interface BenDetailRepo extends CrudRepository<MBeneficiarydetail, BigInteger>, BenDetailRepoCustom {
	List<MBeneficiarydetail> findByBeneficiaryDetailsIdOrderByBeneficiaryDetailsIdAsc(BigInteger beneficiaryDetailsId);

	List<MBeneficiarydetail> findByCreatedDateBetweenOrderByBeneficiaryDetailsIdAsc(Timestamp fromDate,
			Timestamp toDate);

	List<MBeneficiarydetail> findByFirstNameAndLastNameOrderByBeneficiaryDetailsIdAsc(String fName, String mName);


	@Query("select d from MBeneficiarydetail d " + "where d.mBeneficiarymapping.benRegId = :benRegId")
	MBeneficiarydetail findByBenRegId(BigInteger benRegId);


	@Query("select d from MBeneficiarydetail d where d.firstName = :fName and d.middleName = :mName and "
			+ "d.lastName = :lName Order By d.beneficiaryDetailsId Asc")
	List<MBeneficiarydetail> findByName(String fName, String mName, String lName);

	@Query("select d from MBeneficiarydetail d where d.firstName = :fName and d.middleName = :mName and "
			+ "d.lastName = :lName and d.spouseName = :spouseName Order By d.beneficiaryDetailsId Asc")
	List<MBeneficiarydetail> findByNameAndSpouseName(String fName, String mName, String lName, String spouseName);

	@Query("select d from MBeneficiarydetail d where d.firstName = :fName and d.middleName = :mName and "
			+ "d.lastName = :lName and d.fatherName = :fatherName and d.dob = :dob  Order By d.beneficiaryDetailsId Asc")
	List<MBeneficiarydetail> findByNameAndFatherNameAndDob(String fName, String mName, String lName, String fatherName,
			Timestamp dob);

	@Query("select d from MBeneficiarydetail d where d.firstName = :fName and d.middleName = :mName and "
			+ "d.lastName = :lName and d.dob = :dob Order By d.beneficiaryDetailsId Asc")
	List<MBeneficiarydetail> findByNameAndDob(String fName, String mName, String lName, Timestamp dob);

	@Query("select d from MBeneficiarydetail d where d.firstName = :fName and d.middleName = :mName and "
			+ "d.lastName = :lName and d.spouseName = :spouseName and d.dob = :dob Order By d.beneficiaryDetailsId Asc")
	List<MBeneficiarydetail> findByNameAndSpouseNameAndDob(String fName, String mName, String lName, String spouseName,
			Timestamp dob);

	@Query("select d from MBeneficiarydetail d where d.firstName = :fName and d.middleName = :mName and "
			+ "d.lastName = :lName and d.fatherName = :fatherName Order By d.beneficiaryDetailsId Asc")
	List<MBeneficiarydetail> findByNameAndFatherName(String fName, String mName, String lName, String fatherName);

	@Query("select new MBeneficiarydetail(d.beneficiaryDetailsId, d.firstName, d.lastName, d.middleName, "
			+ "d.fatherName, d.spouseName) "
			+ "from MBeneficiarydetail d where d.mBeneficiarymapping.benRegId = :benRegId")
	MBeneficiarydetail findPartialBeneficiaryDetailByBenRegId(@Param("benRegId") BigInteger benRegId);

	@Query("select new MBeneficiarydetail(d.beneficiaryDetailsId, d.firstName, d.lastName, d.middleName, "
			+ "d.fatherName, d.spouseName) "
			+ "from MBeneficiarydetail d where d.mBeneficiarymapping.benRegId in :benRegIds")
	List<MBeneficiarydetail> findPartialBeneficiaryDetailByBenRegId(@Param("benRegIds") List<BigInteger> benRegId);

	@Transactional
	@Modifying
	@Query("UPDATE MBeneficiarydetail c SET c.communityId = :communityId WHERE c.vanSerialNo = :id AND c.vanID = :vanID  ")
	Integer updateCommunity(@Param("id") BigInteger id, @Param("vanID") Integer vanID,
			@Param("communityId") Integer communityId);

	@Transactional
	@Modifying
	@Query("UPDATE MBeneficiarydetail c SET c.educationId = :educationId WHERE c.vanSerialNo = :id AND c.vanID = :vanID ")
	Integer updateEducation(@Param("id") BigInteger id, @Param("vanID") Integer vanID,
			@Param("educationId") Integer educationId);

	@Transactional
	@Modifying
	@Query(" UPDATE MBeneficiarydetail set vanSerialNo = :beneficiaryDetailsId WHERE beneficiaryDetailsId = :beneficiaryDetailsId")
	int updateVanSerialNo(@Param("beneficiaryDetailsId") BigInteger beneficiaryDetailsId);

	@Query("SELECT beneficiaryDetailsId FROM MBeneficiarydetail WHERE vanSerialNo =:vanSerialNo AND vanID =:vanID ")
	BigInteger findIdByVanSerialNoAndVanID(@Param("vanSerialNo") BigInteger vanSerialNo, @Param("vanID") Integer vanID);

	@Query("SELECT t FROM MBeneficiarydetail t WHERE t.vanSerialNo =:vanSerialNo AND t.vanID =:vanID ")
	MBeneficiarydetail findBenDetailsByVanSerialNoAndVanID(@Param("vanSerialNo") BigInteger vanSerialNo,
			@Param("vanID") Integer vanID);

	@Query("SELECT a FROM MBeneficiarydetail a WHERE a.vanSerialNo =:vanSerialNo AND a.vanID =:vanID ")
	MBeneficiarydetail getWith_vanSerialNo_vanID(@Param("vanSerialNo") BigInteger vanSerialNo,
			@Param("vanID") Integer vanID);

	@Query("SELECT a FROM MBeneficiarydetail a WHERE a.familyId =:familyId")
	List<MBeneficiarydetail> getFamilyDetails(@Param("familyId") String familyId);

	@Transactional
	@Modifying
	@Query("UPDATE MBeneficiarydetail c SET c.familyId = :familyId,c.headOfFamily_RelationID =:headofFamily_RelationID, "
			+ " c.headOfFamily_Relation =:headofFamily_Relation,c.other =:other "
			+ " WHERE c.vanSerialNo =:vanSerialNo AND c.vanID =:vanID ")
	Integer updateFamilyDetails(@Param("familyId") String familyId,
			@Param("headofFamily_RelationID") Integer headofFamilyRelationID,
			@Param("headofFamily_Relation") String headofFamilyRelation, @Param("other") String other,
			@Param("vanSerialNo") BigInteger vanSerialNo, @Param("vanID") Integer vanID);

	@Transactional
	@Modifying
	@Query("UPDATE MBeneficiarydetail c SET c.headOfFamily_RelationID =:headofFamily_RelationID, "
			+ " c.headOfFamily_Relation =:headofFamily_Relation,c.other =:other "
			+ " WHERE c.vanSerialNo =:vanSerialNo AND c.vanID =:vanID AND c.familyId=:familyId ")
	Integer editFamilyDetails(@Param("headofFamily_RelationID") Integer headofFamilyRelationID,
			@Param("headofFamily_Relation") String headofFamilyRelation, @Param("other") String other,
			@Param("vanSerialNo") BigInteger vanSerialNo, @Param("vanID") Integer vanID,
			@Param("familyId") String familyId);

	@Transactional
	@Modifying
	@Query("UPDATE MBeneficiarydetail c SET c.familyId = null,c.headOfFamily_RelationID = null,c.other = null, "
			+ " c.headOfFamily_Relation = null,c.modifiedBy = :modifiedBy "
			+ " WHERE c.vanSerialNo =:vanSerialNo AND c.vanID =:vanID ")
	int untagFamily(@Param("modifiedBy") String modifiedBy, @Param("vanSerialNo") BigInteger vanSerialNo,
			@Param("vanID") Integer vanID);

	@Query("SELECT b FROM MBeneficiarydetail b WHERE b.familyId =:familyid  ")
	List<MBeneficiarydetail> searchByFamilyId(@Param("familyid") String familyid);

}
