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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.common.identity.domain.MBeneficiarydetail;
import com.iemr.common.identity.dto.IdentitySearchDTO;

public class BenDetailRepoImpl implements BenDetailRepoCustom
{

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	BenRegIdMappingRepo regIdRepo;

	

	@Override
	public List<MBeneficiarydetail> advanceFilterSearch(IdentitySearchDTO searchDTO)
	{

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MBeneficiarydetail> criteriaQuery = criteriaBuilder.createQuery(MBeneficiarydetail.class);
		Root<MBeneficiarydetail> root = criteriaQuery.from(MBeneficiarydetail.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		
		if (searchDTO.getFirstName() != null)
		{

			predicates.add(criteriaBuilder.like(root.<String> get("firstName"), "%" + searchDTO.getFirstName() + "%"));
		}

		
		if (searchDTO.getMiddleName() != null)
		{
			predicates
					.add(criteriaBuilder.like(root.<String> get("middleName"), "%" + searchDTO.getMiddleName() + "%"));
		}

		
		if (searchDTO.getLastName() != null)
		{
			predicates.add(criteriaBuilder.like(root.<String> get("lastName"), "%" + searchDTO.getLastName() + "%"));
		}

		
		if (searchDTO.getAgeId() != null)
		{
			predicates.add(criteriaBuilder.equal(root.get("ageId"), searchDTO.getAgeId()));
		}

		
		if (searchDTO.getAge() != null)
		{
			predicates.add(criteriaBuilder.equal(root.get("age"), searchDTO.getAge()));
		}

		
		if (searchDTO.getGenderId() != null)
		{
			predicates.add(criteriaBuilder.equal(root.get("genderId"), searchDTO.getGenderId()));
		}

		
		if (searchDTO.getGenderName() != null)
		{
			predicates.add(criteriaBuilder.equal(root.get("genderName"), searchDTO.getGenderName()));
		}

		
		if (searchDTO.getSpouseName() != null)
		{
			predicates
					.add(criteriaBuilder.like(root.<String> get("spouseName"), "%" + searchDTO.getSpouseName() + "%"));
		}

		
		if (searchDTO.getFatherName() != null)
		{
			predicates
					.add(criteriaBuilder.like(root.<String> get("fatherName"), "%" + searchDTO.getFatherName() + "%"));
		}

		
		if (searchDTO.getPinCode() != null)
		{
			predicates.add(criteriaBuilder.equal(root.get("pinCode"), searchDTO.getPinCode()));
		}

		

		criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}))
				.orderBy(criteriaBuilder.asc(root.get("benMapId")));
		TypedQuery<MBeneficiarydetail> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
