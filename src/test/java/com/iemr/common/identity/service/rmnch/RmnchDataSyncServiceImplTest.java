package com.iemr.common.identity.service.rmnch;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.google.gson.Gson;
import com.iemr.common.identity.data.rmnch.GetBenRequestHandler;
import com.iemr.common.identity.data.rmnch.RMNCHBeneficiaryDetailsRmnch;
import com.iemr.common.identity.data.rmnch.RMNCHBornBirthDetails;
import com.iemr.common.identity.data.rmnch.RMNCHCBACdetails;
import com.iemr.common.identity.data.rmnch.RMNCHHouseHoldDetails;
import com.iemr.common.identity.data.rmnch.RMNCHMBeneficiaryaddress;
import com.iemr.common.identity.repo.rmnch.RMNCHBenAccountRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenAddressRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenContactRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBenImageRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBeneficiaryDetailsRmnchRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHBornBirthDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHCBACDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHHouseHoldDetailsRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHMBenMappingRepo;
import com.iemr.common.identity.repo.rmnch.RMNCHMBenRegIdMapRepo;
@ExtendWith(MockitoExtension.class)
class RmnchDataSyncServiceImplTest {
	@InjectMocks
	RmnchDataSyncServiceImpl rmnchDataSyncServiceImpl;
	
	@Mock
	private RMNCHBeneficiaryDetailsRmnchRepo rMNCHBeneficiaryDetailsRmnchRepo;
	@Mock
	private RMNCHBornBirthDetailsRepo rMNCHBornBirthDetailsRepo;
	@Mock
	private RMNCHCBACDetailsRepo rMNCHCBACDetailsRepo;
	@Mock
	private RMNCHHouseHoldDetailsRepo rMNCHHouseHoldDetailsRepo;

	@Mock
	private RMNCHBenAddressRepo rMNCHBenAddressRepo;
	@Mock
	private RMNCHMBenMappingRepo rMNCHMBenMappingRepo;
	@Mock
	private RMNCHBenDetailsRepo rMNCHBenDetailsRepo;
	@Mock
	private RMNCHBenAccountRepo rMNCHBenAccountRepo;
	@Mock
	private RMNCHBenImageRepo rMNCHBenImageRepo;
	@Mock
	private RMNCHBenContactRepo rMNCHBenContactRepo;
	@Mock
	private RMNCHMBenRegIdMapRepo rMNCHMBenRegIdMapRepo;

	@Test
	void testSyncDataToAmrit() throws Exception {
		RMNCHBeneficiaryDetailsRmnch rMNCHBeneficiaryDetailsRmnch = new RMNCHBeneficiaryDetailsRmnch();
		Long[] ids = {Long.valueOf(123),Long.valueOf(456)};
		rMNCHBeneficiaryDetailsRmnch.setRelatedBeneficiaryIds(ids);
		String json = new Gson().toJson(rMNCHBeneficiaryDetailsRmnch);
		JSONObject jsonObject = new JSONObject();
		
		List<String> list=new ArrayList<>();
		list.add(json);
		char s= '"';
		String t = s+"[";
		String r = "]"+s;
		jsonObject.put("beneficiaryDetails", list);
		
		List<String> birthlist=new ArrayList<>();
		List<RMNCHBornBirthDetails> rMNCHBornBirthDetailslist=new ArrayList<>();
		RMNCHBornBirthDetails rMNCHBornBirthDetails = new RMNCHBornBirthDetails();
		rMNCHBornBirthDetailslist.add(rMNCHBornBirthDetails);
		String birthJson = new Gson().toJson(rMNCHBornBirthDetails);
		birthlist.add(birthJson);
		jsonObject.put("bornBirthDeatils", birthlist);
		
		List<String> cbaclist=new ArrayList<>();
		List<RMNCHCBACdetails> rMNCHCBACdetailslist=new ArrayList<>();
		RMNCHCBACdetails rMNCHCBACdetails = new RMNCHCBACdetails();
		rMNCHCBACdetails.setBenficieryid(Long.valueOf(987));
		rMNCHCBACdetailslist.add(rMNCHCBACdetails);
		String cbacJson = new Gson().toJson(rMNCHCBACdetails);
		cbaclist.add(birthJson);
		jsonObject.put("cBACDetails", cbaclist);
		
		List<String> householdlist=new ArrayList<>();
		List<RMNCHHouseHoldDetails> rMNCHHouseHoldDetailslist=new ArrayList<>();
		RMNCHHouseHoldDetails rMNCHHouseHoldDetails = new RMNCHHouseHoldDetails();
		rMNCHHouseHoldDetails.setHouseoldId(Long.valueOf(987));
		rMNCHHouseHoldDetailslist.add(rMNCHHouseHoldDetails);
		String householdJson = new Gson().toJson(rMNCHHouseHoldDetails);
		householdlist.add(householdJson);
		jsonObject.put("houseHoldDetails", householdlist);	
		
		String json1 = jsonObject.toString();
		String replace = json1.replace(t, "[").replace(r, "]");
		String replace2 = replace.replace("\\", "");
		
		when(rMNCHHouseHoldDetailsRepo.saveAll(anyList())).thenReturn(rMNCHHouseHoldDetailslist);
		when(rMNCHHouseHoldDetailsRepo.getByHouseHoldID(Long.valueOf(987))).thenReturn(rMNCHHouseHoldDetails);
		when(rMNCHCBACDetailsRepo.saveAll(anyList())).thenReturn(rMNCHCBACdetailslist);
		when(rMNCHCBACDetailsRepo.getByRegID(any())).thenReturn(rMNCHCBACdetails);
		when(rMNCHMBenRegIdMapRepo.getRegID(any())).thenReturn(Long.valueOf(987));
		when(rMNCHBornBirthDetailsRepo.saveAll(anyList())).thenReturn(rMNCHBornBirthDetailslist);
		when(rMNCHBornBirthDetailsRepo.getByRegID(any())).thenReturn(rMNCHBornBirthDetails);
		when(rMNCHMBenRegIdMapRepo.getRegID(any())).thenReturn(Long.valueOf(987));
		when(rMNCHBeneficiaryDetailsRmnchRepo.getByRegID(any())).thenReturn(rMNCHBeneficiaryDetailsRmnch);
		when(rMNCHMBenRegIdMapRepo.getRegID(any())).thenReturn(Long.valueOf(987));
		String syncDataToAmrit = rmnchDataSyncServiceImpl.syncDataToAmrit(replace2);
		Assert.assertNotNull(syncDataToAmrit);
	}

	/*
	 * @Test void testGetBenData() throws Exception { GetBenRequestHandler
	 * getBenRequestHandler = new GetBenRequestHandler();
	 * getBenRequestHandler.setAshaId(123); getBenRequestHandler.setVillageID(456);
	 * getBenRequestHandler.setPageNo(9);
	 * getBenRequestHandler.setFromDate(Timestamp.valueOf(LocalDateTime.now()));
	 * getBenRequestHandler.setToDate(Timestamp.valueOf(LocalDateTime.now()));
	 * String request = new Gson().toJson(getBenRequestHandler);
	 * 
	 * List<RMNCHMBeneficiaryaddress> list = new ArrayList<>();
	 * RMNCHMBeneficiaryaddress rmnchmBeneficiaryaddress = new
	 * RMNCHMBeneficiaryaddress(); list.add(rmnchmBeneficiaryaddress);
	 * 
	 * Page<RMNCHMBeneficiaryaddress> pagermnch= new PageImpl<>(list);
	 * when(rMNCHBenAddressRepo.getBenDataFilteredWithDateRange(any(), any(), any(),
	 * any())).thenReturn(pagermnch); rmnchDataSyncServiceImpl.getBenData(request,
	 * null); }
	 */

}
