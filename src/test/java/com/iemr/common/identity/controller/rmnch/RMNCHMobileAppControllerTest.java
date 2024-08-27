package com.iemr.common.identity.controller.rmnch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import com.iemr.common.identity.service.rmnch.RmnchDataSyncService;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
@ExtendWith(MockitoExtension.class)
class RMNCHMobileAppControllerTest {
	@InjectMocks
	RMNCHMobileAppController rmnchMobileAppController;
	@Mock
	RmnchDataSyncService rmnchDataSyncService;

	@Test
	@Description("Tests the synchronization of data to the Amrit system. (TC_SyncDataToAmrit_Success_001)")
	void testSyncDataToAmrit() throws Exception {
		String req = "requestObj";
		when(rmnchDataSyncService.syncDataToAmrit(any())).thenReturn("resp");
		String syncDataToAmrit = rmnchMobileAppController.syncDataToAmrit(req);
		assertNotNull(syncDataToAmrit);
	}
	@Test
	@Description("Tests the behavior of the syncDataToAmrit method when provided with a null request object. (TC_SyncDataToAmritNullReq_002)")
	void testSyncDataToAmritNullReq() throws Exception {
		String req = null;
		String syncDataToAmrit = rmnchMobileAppController.syncDataToAmrit(req);
		String data = getData(syncDataToAmrit,"errorMessage");
		assertEquals("Invalid/NULL request obj", data);
	}
	@Test
	@Description("Tests the exception handling within the syncDataToAmrit method. (TC_SyncDataToAmritException_003)")
	void testSyncDataToAmritException() throws Exception {
		String req = "requestObj";
		when(rmnchDataSyncService.syncDataToAmrit(any())).thenThrow(Exception.class);
		String syncDataToAmrit = rmnchMobileAppController.syncDataToAmrit(req);
		String data = getData(syncDataToAmrit,"errorMessage");
		assertTrue(data.contains("Error in RMNCH mobile data sync"));
	}

	@Test
	@Description("Tests successful retrieval of beneficiary data. (TC_GetBeneficiaryData_Success_001)")
	void testGetBeneficiaryData() throws Exception {
		String req = "requestObj";
		String auth = "authorization";
		when(rmnchDataSyncService.getBenData(req, auth)).thenReturn("resp");
		String beneficiaryData = rmnchMobileAppController.getBeneficiaryData(req, auth);
		assertNotNull(beneficiaryData);
	}
	@Test
	@Description("Tests the handling of a null response when retrieving beneficiary data. (TC_GetBeneficiaryDataNullResp_002)")
	void testGetBeneficiaryDataNullResp() throws Exception {
		String req = "requestObj";
		String auth = "authorization";
		when(rmnchDataSyncService.getBenData(req, auth)).thenReturn(null);
		String beneficiaryData = rmnchMobileAppController.getBeneficiaryData(req, auth);
		String data = getData(beneficiaryData,"errorMessage");
		assertTrue(data.contains("No record found"));
	}
	@Test
	@Description("Tests the handling of a null response when retrieving beneficiary data. (TC_GetBeneficiaryDataNullResp_003)")
	void testGetBeneficiaryDataNullReq() throws Exception {
		String req = null;
		String auth = "authorization";
		String beneficiaryData = rmnchMobileAppController.getBeneficiaryData(req, auth);
		String data = getData(beneficiaryData,"errorMessage");
		assertEquals("Invalid/NULL request obj", data);
	}
	@Test
	@Description("Tests exception handling within the getBeneficiaryData method. (TC_GetBeneficiaryDataException_004)")
	void testGetBeneficiaryDataException() throws Exception {
		String req = "requestObj";
		String auth = "authorization";
		when(rmnchDataSyncService.getBenData(req, auth)).thenThrow(Exception.class);
		String beneficiaryData = rmnchMobileAppController.getBeneficiaryData(req, auth);
		String data = getData(beneficiaryData,"errorMessage");
		assertTrue(data.contains("Error in get data"));
	}

	@Test
	@Description("Tests successful retrieval of beneficiary data by Asha worker ID. (TC_GetBeneficiaryDataByAsha_Success_001)")
	void testGetBeneficiaryDataByAsha() throws Exception {
		String req = "requestObj";
		String auth = "authorization";
		when(rmnchDataSyncService.getBenDataByAsha(req, auth)).thenReturn("resp");
		String beneficiaryDataByAsha = rmnchMobileAppController.getBeneficiaryDataByAsha(req, auth);
		assertNotNull(beneficiaryDataByAsha);
	}
	
	@Test
	@Description("Tests the handling of a null response when retrieving beneficiary data by Asha worker ID. (TC_GetBeneficiaryDataByAshaNullResp_002)")
	void testGetBeneficiaryDataByAshaNullResp() throws Exception {
		String req = "requestObj";
		String auth = "authorization";
		when(rmnchDataSyncService.getBenDataByAsha(req, auth)).thenReturn(null);
		String beneficiaryDataByAsha = rmnchMobileAppController.getBeneficiaryDataByAsha(req, auth);
		String data = getData(beneficiaryDataByAsha,"errorMessage");
		assertTrue(data.contains("No record found"));
	}
	@Test
	@Description("Tests the behavior of the getBeneficiaryDataByAsha method when a null request object is provided. (TC_GetBeneficiaryDataByAshaNullReq_003)")
	void testGetBeneficiaryDataByAshaNullReq() throws Exception {
		String req = null;
		String auth = "authorization";
		String beneficiaryDataByAsha = rmnchMobileAppController.getBeneficiaryDataByAsha(req, auth);
		String data = getData(beneficiaryDataByAsha,"errorMessage");
		assertEquals("Invalid/NULL request obj", data);
	}
	
	@Test
	@Description("Tests exception handling within the getBeneficiaryDataByAsha method. (TC_GetBeneficiaryDataByAshaException_004)")
	void testGetBeneficiaryDataByAshaException() throws Exception {
		String req = "requestObj";
		String auth = "authorization";
		when(rmnchDataSyncService.getBenDataByAsha(req, auth)).thenThrow(Exception.class);
		String beneficiaryDataByAsha = rmnchMobileAppController.getBeneficiaryDataByAsha(req, auth);
		String data = getData(beneficiaryDataByAsha,"errorMessage");
		assertTrue(data.contains("Error in get data"));
	}
	private String getData(String resp, String status) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(resp);
		String actualresp = json.getAsString(status);
		return actualresp;
	}
}
