package com.iemr.common.identity.service.familyTagging;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.iemr.common.identity.data.familyTagging.BenFamilyMapping;
import com.iemr.common.identity.domain.MBeneficiarydetail;
import com.iemr.common.identity.domain.MBeneficiarymapping;
import com.iemr.common.identity.exception.IEMRException;
import com.iemr.common.identity.repo.BenDetailRepo;
import com.iemr.common.identity.repo.BenMappingRepo;
import com.iemr.common.identity.repo.familyTag.FamilyTagRepo;

import junit.framework.TestCase;
@ExtendWith(MockitoExtension.class)

class FamilyTagServiceImplTest {
	
	@InjectMocks
	private FamilyTagServiceImpl familyTagServiceImpl;
	
	@Mock
	private BenMappingRepo benMappingRepo;
	@Mock
	private BenDetailRepo benDetailRepo;
	@Mock
	private FamilyTagRepo familyTagRepo;

	@Test
	void testAddTag() throws IEMRException {
		BenFamilyMapping requestObj = new BenFamilyMapping();
		requestObj.setBeneficiaryRegId(Long.valueOf("1234456"));
		requestObj.setIsHeadOfTheFamily(true);
		String request = new Gson().toJson(requestObj);
	
		MBeneficiarymapping mapping = new MBeneficiarymapping();
		mapping.setBenMapId(BigInteger.valueOf(123));
		mapping.setBenDetailsId(BigInteger.valueOf(456));
		mapping.setVanID(98);
		when(benMappingRepo
		.getBenDetailsId(BigInteger.valueOf(requestObj.getBeneficiaryRegId()))).thenReturn(mapping);
		benDetailRepo.updateFamilyDetails(requestObj.getFamilyId(),
				requestObj.getHeadofFamily_RelationID(), requestObj.getHeadofFamily_Relation(),
				requestObj.getOther(), mapping.getBenDetailsId(), requestObj.getVanID());
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf("1234456"));
		benFamilyMapping.setNoOfmembers(4);
		when(familyTagRepo.searchFamilyByFamilyId(requestObj.getFamilyId())).thenReturn(benFamilyMapping );
		String resp = familyTagServiceImpl.addTag(request);
		Assert.assertNotNull(resp);
	}

	@Test
	void testDoFamilyUntag() throws IEMRException, JSONException {
		JSONObject benFamilymap = new JSONObject();
		benFamilymap.put("benFamilyTagId", Long.valueOf(123));
		benFamilymap.put("beneficiaryRegId", Long.valueOf(456));
		benFamilymap.put("familyId", 789);
		benFamilymap.put("isHeadOfTheFamily", true);
		JSONArray pets = new JSONArray();
		pets.put(benFamilymap);
		JSONObject person = new JSONObject();
		person.put("memberList", pets);
		String string = person.toString();
		MBeneficiarymapping mBeneficiarymapping = new MBeneficiarymapping();
		when(benMappingRepo.getBenDetailsId(BigInteger.valueOf(456))).thenReturn(mBeneficiarymapping);
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setNoOfmembers(4);
		when(familyTagRepo.searchFamilyByFamilyId("789")).thenReturn(benFamilyMapping);
		String resp = familyTagServiceImpl.doFamilyUntag(string);
		Assert.assertNotNull(resp);
	}

	@Test
	void testEditFamilyDetailsCatchblock() throws IEMRException {
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.editFamilyDetails(null));
	}
	
	@Test
	void testEditFamilyDetails() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId("123");
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf(123));
		String json = new Gson().toJson(benFamilyMapping);
		when(familyTagRepo.searchFamilyByFamilyId(benFamilyMapping.getFamilyId())).thenReturn(benFamilyMapping);
		MBeneficiarymapping mBeneficieryMapping = new MBeneficiarymapping();
		mBeneficieryMapping.setBenDetailsId(BigInteger.valueOf(986));
		mBeneficieryMapping.setVanID(123);
		when(benMappingRepo.getBenDetailsId(BigInteger.valueOf(benFamilyMapping.getBeneficiaryRegId()))).thenReturn(mBeneficieryMapping);
		
		String editFamilyDetails = familyTagServiceImpl.editFamilyDetails(json);
		Assert.assertNotNull(editFamilyDetails);
	}
	@Test
	void testEditFamilyDetails_If_BenFamilyMapping_Null() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId("123");
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf(123));
		String json = new Gson().toJson(benFamilyMapping);
		when(familyTagRepo.searchFamilyByFamilyId(benFamilyMapping.getFamilyId())).thenReturn(null);
		
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.editFamilyDetails(json));
	}
	@Test
	void testEditFamilyDetailsIfMBeneficiarymappingNull() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId("123");
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf(123));
		String json = new Gson().toJson(benFamilyMapping);
		when(familyTagRepo.searchFamilyByFamilyId(benFamilyMapping.getFamilyId())).thenReturn(benFamilyMapping);
		MBeneficiarymapping mBeneficieryMapping = new MBeneficiarymapping();
		mBeneficieryMapping.setBenDetailsId(BigInteger.valueOf(986));
		mBeneficieryMapping.setVanID(123);
		when(benMappingRepo.getBenDetailsId(BigInteger.valueOf(benFamilyMapping.getBeneficiaryRegId()))).thenReturn(null);
		
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.editFamilyDetails(json));
	}

	@Test
	void testSearchFamilyCatchblock() throws IEMRException {
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.searchFamily(null));
	}

	@Test
	void testSearchFamily() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId("123");
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		String json = new Gson().toJson(benFamilyMapping);
		List<BenFamilyMapping> list= new ArrayList<>();
		list.add(benFamilyMapping);
		when(familyTagRepo.searchFamilyWithFamilyId(benFamilyMapping.getFamilyName(),
				benFamilyMapping.getVillageId(), benFamilyMapping.getFamilyId())).thenReturn(list);
		Assert.assertNotNull(familyTagServiceImpl.searchFamily(json));
	}
	
	@Test
	void testSearchFamily_If_FamilyID_NULL() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId(null);
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		String json = new Gson().toJson(benFamilyMapping);
		List<BenFamilyMapping> list= new ArrayList<>();
		list.add(benFamilyMapping);
		when(familyTagRepo.searchFamily(benFamilyMapping.getFamilyName(),
				benFamilyMapping.getVillageId())).thenReturn(list);
		Assert.assertNotNull(familyTagServiceImpl.searchFamily(json));
	}
	@Test
	void testSearchFamily_If_RESP_NULL() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId(null);
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		String json = new Gson().toJson(benFamilyMapping);

		when(familyTagRepo.searchFamily(benFamilyMapping.getFamilyName(),
				benFamilyMapping.getVillageId())).thenReturn(null);
		Assert.assertNotNull(familyTagServiceImpl.searchFamily(json));
	}

	@Test
	void testCreateFamilyCatchBlock() throws IEMRException {
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.createFamily(null));
	}
	@Test
	void testCreateFamilyFamilyTaggedIDNull() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId(null);
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		benFamilyMapping.setCreatedBy("Admin");
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf(1234));
		String json = new Gson().toJson(benFamilyMapping);
	
		when(familyTagRepo.getUserId("Admin")).thenReturn(123);
		when(familyTagRepo.save(any())).thenReturn(benFamilyMapping);
		MBeneficiarymapping mBeneficiarymapping = new MBeneficiarymapping();
		mBeneficiarymapping.setBenDetailsId(BigInteger.valueOf(987));
		mBeneficiarymapping.setVanID(765);
		when(benMappingRepo
		.getBenDetailsId(BigInteger.valueOf(benFamilyMapping.getBeneficiaryRegId()))).thenReturn(mBeneficiarymapping);
		
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.createFamily(json));
	}
	@Test
	void testCreateFamily() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId(null);
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		benFamilyMapping.setCreatedBy("Admin");
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf(1234));
		benFamilyMapping.setBenFamilyTagId(Long.valueOf(987));
		String json = new Gson().toJson(benFamilyMapping);
	
		when(familyTagRepo.getUserId("Admin")).thenReturn(123);
		when(familyTagRepo.save(any())).thenReturn(benFamilyMapping);
		MBeneficiarymapping mBeneficiarymapping = new MBeneficiarymapping();
		mBeneficiarymapping.setBenDetailsId(BigInteger.valueOf(987));
		mBeneficiarymapping.setVanID(765);
		when(benMappingRepo
		.getBenDetailsId(BigInteger.valueOf(benFamilyMapping.getBeneficiaryRegId()))).thenReturn(mBeneficiarymapping);
		
		String resp = familyTagServiceImpl.createFamily(json);
		Assert.assertNotNull(resp);
	}


	@Test
	void testGetFamilyId() throws IEMRException {
		familyTagServiceImpl.getFamilyId("");
	}
	
	@Test
	void testGetFamilyDetailsCatchBlock() throws IEMRException {
		Assert.assertThrows(IEMRException.class, () -> familyTagServiceImpl.getFamilyDetails(null));
	}

	@Test
	void testGetFamilyDetails() throws IEMRException {
		BenFamilyMapping benFamilyMapping = new BenFamilyMapping();
		benFamilyMapping.setFamilyId(null);
		benFamilyMapping.setFamilyId("123");
		benFamilyMapping.setIsHeadOfTheFamily(true);
		benFamilyMapping.setMemberName("memberName");
		benFamilyMapping.setFamilyHeadName("familyHeadName");
		benFamilyMapping.setCreatedBy("Admin");
		benFamilyMapping.setBeneficiaryRegId(Long.valueOf(1234));
		String json = new Gson().toJson(benFamilyMapping);
		
		List<MBeneficiarydetail> list=new ArrayList<>();
		MBeneficiarydetail mBeneficiarydetail = new MBeneficiarydetail();
		mBeneficiarydetail.setOther("other");
		list.add(mBeneficiarydetail);
		when(benMappingRepo.getBenRegId(any(), any())).thenReturn(BigInteger.valueOf(987));
		when(benDetailRepo.getFamilyDetails(any())).thenReturn(list);
		familyTagServiceImpl.getFamilyDetails(json);
	}
}
