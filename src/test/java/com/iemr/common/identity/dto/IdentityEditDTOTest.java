package com.iemr.common.identity.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class IdentityEditDTOTest {
	@InjectMocks
	IdentityEditDTO identityEditDTO;
	@Test
	void testHashCode() {
		identityEditDTO.hashCode();
	}

	@Test
	void testGetEventTypeName() {
		identityEditDTO.getEventTypeName();
	}

	@Test
	void testGetEventTypeDate() {
		identityEditDTO.getEventTypeDate();
	}

	@Test
	void testGetAgentId() {
		identityEditDTO.getAgentId();
	}

	@Test
	void testGetAgentName() {
		identityEditDTO.getAgentName();
	}

	@Test
	void testGetAgentPSMapId() {
		identityEditDTO.getAgentPSMapId();
	}

	@Test
	void testGetAgentComment() {
		identityEditDTO.getAgentComment();
	}

	@Test
	void testGetServiceId() {
		identityEditDTO.getServiceId();
	}

	@Test
	void testGetServiceName() {
		identityEditDTO.getServiceName();
	}

	@Test
	void testGetServiceProviderId() {
		identityEditDTO.getServiceProviderId();
	}

	@Test
	void testGetServiceProviderName() {
		identityEditDTO.getServiceProviderName();
	}

	@Test
	void testGetStateId() {
		identityEditDTO.getStateId();
	}

	@Test
	void testGetStateName() {
		identityEditDTO.getStateName();
	}

	@Test
	void testGetProviderServiceMapId() {
		identityEditDTO.getProviderServiceMapId();
	}

	@Test
	void testGetBeneficaryId() {
		identityEditDTO.getBeneficaryId();
	}

	@Test
	void testGetBeneficiaryRegId() {
		identityEditDTO.getBeneficiaryRegId();
	}

	@Test
	void testGetChangeInSelfDetails() {
		identityEditDTO.getChangeInSelfDetails();
	}

	@Test
	void testGetFirstName() {
		identityEditDTO.getFirstName();
	}

	@Test
	void testGetMiddleName() {
		identityEditDTO.getMiddleName();
	}

	@Test
	void testGetLastName() {
		identityEditDTO.getLastName();
	}

	@Test
	void testGetFatherName() {
		identityEditDTO.getFatherName();
	}

	@Test
	void testGetMotherName() {
		identityEditDTO.getMotherName();
	}

	@Test
	void testGetSpouseName() {
		identityEditDTO.getSpouseName();
	}

	@Test
	void testGetMaritalStatusId() {
		identityEditDTO.getMaritalStatusId();
	}

	@Test
	void testGetMaritalStatus() {
		identityEditDTO.getMaritalStatus();
	}

	@Test
	void testGetDob() {
		identityEditDTO.getDob();
	}

	@Test
	void testGetGenderId() {
		identityEditDTO.getGenderId();
	}

	@Test
	void testGetGender() {
		identityEditDTO.getGender();
	}

	@Test
	void testGetTitleId() {
		identityEditDTO.getTitleId();
	}

	@Test
	void testGetTitle() {
		identityEditDTO.getTitle();
	}

	@Test
	void testGetLiteracyStatus() {
		identityEditDTO.getLiteracyStatus();
	}

	@Test
	void testGetChangeInAddress() {
		identityEditDTO.getChangeInAddress();
	}

	@Test
	void testGetCurrentAddress() {
		identityEditDTO.getCurrentAddress();
	}

	@Test
	void testGetPermanentAddress() {
		identityEditDTO.getPermanentAddress();
	}

	@Test
	void testGetEmergencyAddress() {
		identityEditDTO.getEmergencyAddress();
	}

	@Test
	void testGetIsPermAddrSameAsCurrAddr() {
		identityEditDTO.getIsPermAddrSameAsCurrAddr();
	}

	@Test
	void testGetIsPermAddrSameAsEmerAddr() {
		identityEditDTO.getIsPermAddrSameAsEmerAddr();
	}

	@Test
	void testGetIsEmerAddrSameAsCurrAddr() {
		identityEditDTO.getIsEmerAddrSameAsCurrAddr();
	}

	@Test
	void testGetIsEmerAddrSameAsPermAddr() {
		identityEditDTO.getIsEmerAddrSameAsPermAddr();
	}

	@Test
	void testGetAddressType() {
		identityEditDTO.getAddressType();
	}

	@Test
	void testGetChangeInContacts() {
		identityEditDTO.getChangeInContacts();
	}

	@Test
	void testGetContact() {
		identityEditDTO.getContact();
	}

	@Test
	void testGetPreferredEmailId() {
		identityEditDTO.getPreferredEmailId();
	}

	@Test
	void testGetChangeInIdentities() {
		identityEditDTO.getChangeInIdentities();
	}

	@Test
	void testGetIdentities() {
		identityEditDTO.getIdentities();
	}

	@Test
	void testGetChangeInOtherDetails() {
		identityEditDTO.getChangeInOtherDetails();
	}

	@Test
	void testGetPreferredLanguageId() {
		identityEditDTO.getPreferredLanguageId();
	}

	@Test
	void testGetPreferredLanguage() {
		identityEditDTO.getPreferredLanguage();
	}

	@Test
	void testGetCommunityId() {
		identityEditDTO.getCommunityId();
	}

	@Test
	void testGetCommunity() {
		identityEditDTO.getCommunity();
	}

	@Test
	void testGetEducationId() {
		identityEditDTO.getEducationId();
	}

	@Test
	void testGetEducation() {
		identityEditDTO.getEducation();
	}

	@Test
	void testGetIncomeStatusId() {
		identityEditDTO.getIncomeStatusId();
	}

	@Test
	void testGetIncomeStatus() {
		identityEditDTO.getIncomeStatus();
	}

	@Test
	void testGetOccupationId() {
		identityEditDTO.getOccupationId();
	}

	@Test
	void testGetOccupation() {
		identityEditDTO.getOccupation();
	}

	@Test
	void testGetReligionId() {
		identityEditDTO.getReligionId();
	}

	@Test
	void testGetReligion() {
		identityEditDTO.getReligion();
	}

	@Test
	void testGetPlaceOfWork() {
		identityEditDTO.getPlaceOfWork();
	}

	@Test
	void testGetHealthCareWorkerId() {
		identityEditDTO.getHealthCareWorkerId();
	}

	@Test
	void testGetHealthCareWorker() {
		identityEditDTO.getHealthCareWorker();
	}

	@Test
	void testGetMonthlyFamilyIncome() {
		identityEditDTO.getMonthlyFamilyIncome();
	}

	@Test
	void testGetChangeInFamilyDetails() {
		identityEditDTO.getChangeInFamilyDetails();
	}

	@Test
	void testGetBenFamilyDTOs() {
		identityEditDTO.getBenFamilyDTOs();
	}

	@Test
	void testGetChangeInAssociations() {
		identityEditDTO.getChangeInAssociations();
	}

	@Test
	void testGetZoneId() {
		identityEditDTO.getZoneId();
	}

	@Test
	void testGetAreaId() {
		identityEditDTO.getAreaId();
	}

	@Test
	void testGetServicePointId() {
		identityEditDTO.getServicePointId();
	}

	@Test
	void testGetPhcId() {
		identityEditDTO.getPhcId();
	}

	@Test
	void testGetRemarks() {
		identityEditDTO.getRemarks();
	}

	@Test
	void testGetSourceOfInfo() {
		identityEditDTO.getSourceOfInfo();
	}

	@Test
	void testGetStatusId() {
		identityEditDTO.getStatusId();
	}

	@Test
	void testGetStatus() {
		identityEditDTO.getStatus();
	}

	@Test
	void testGetChangeInBankDetails() {
		identityEditDTO.getChangeInBankDetails();
	}

	@Test
	void testGetBankName() {
		identityEditDTO.getBankName();
	}

	@Test
	void testGetBranchName() {
		identityEditDTO.getBranchName();
	}

	@Test
	void testGetIfscCode() {
		identityEditDTO.getIfscCode();
	}

	@Test
	void testGetAccountNo() {
		identityEditDTO.getAccountNo();
	}

	@Test
	void testGetBenAccountID() {
		identityEditDTO.getBenAccountID();
	}

	@Test
	void testGetChangeInBenImage() {
		identityEditDTO.getChangeInBenImage();
	}

	@Test
	void testGetBenImage() {
		identityEditDTO.getBenImage();
	}

	@Test
	void testGetBenImageId() {
		identityEditDTO.getBenImageId();
	}

	@Test
	void testGetMarriageDate() {
		identityEditDTO.getMarriageDate();
	}

	@Test
	void testGetAgeAtMarriage() {
		identityEditDTO.getAgeAtMarriage();
	}

	@Test
	void testGetSexualOrientationID() {
		identityEditDTO.getSexualOrientationID();
	}

	@Test
	void testGetSexualOrientationType() {
		identityEditDTO.getSexualOrientationType();
	}

	@Test
	void testGetIsHIVPositive() {
		identityEditDTO.getIsHIVPositive();
	}

	@Test
	void testGetVanID() {
		identityEditDTO.getVanID();
	}

	@Test
	void testGetParkingPlaceId() {
		identityEditDTO.getParkingPlaceId();
	}

	@Test
	void testIsEmergencyRegistration() {
		identityEditDTO.isEmergencyRegistration();
	}

	@Test
	void testSetEventTypeName() {
		identityEditDTO.setEventTypeName(null);
	}

	@Test
	void testSetEventTypeDate() {
		identityEditDTO.setEventTypeDate(null);
	}

	@Test
	void testSetAgentId() {
		identityEditDTO.setAgentId(null);
	}

	@Test
	void testSetAgentName() {
		identityEditDTO.setAgentName(null);
	}

	@Test
	void testSetAgentPSMapId() {
		identityEditDTO.setAgentPSMapId(null);
	}

	@Test
	void testSetAgentComment() {
		identityEditDTO.setAgentComment(null);
	}

	@Test
	void testSetServiceId() {
		identityEditDTO.setServiceId(null);
	}

	@Test
	void testSetServiceName() {
		identityEditDTO.setServiceName(null);
	}

	@Test
	void testSetServiceProviderId() {
		identityEditDTO.setServiceProviderId(null);
	}

	@Test
	void testSetServiceProviderName() {
		identityEditDTO.setServiceProviderName(null);
	}

	@Test
	void testSetStateId() {
		identityEditDTO.setStateId(null);
	}

	@Test
	void testSetStateName() {
		identityEditDTO.setStateName(null);
	}

	@Test
	void testSetProviderServiceMapId() {
		identityEditDTO.setProviderServiceMapId(null);
	}

	@Test
	void testSetBeneficaryId() {
		identityEditDTO.setBeneficaryId(null);
	}

	@Test
	void testSetBeneficiaryRegId() {
		identityEditDTO.setBeneficiaryRegId(null);
	}

	@Test
	void testSetChangeInSelfDetails() {
		identityEditDTO.setChangeInSelfDetails(null);
	}

	@Test
	void testSetFirstName() {
		identityEditDTO.setFirstName(null);
	}

	@Test
	void testSetMiddleName() {
		identityEditDTO.setMiddleName(null);
	}

	@Test
	void testSetLastName() {
		identityEditDTO.setLastName(null);
	}

	@Test
	void testSetFatherName() {
		identityEditDTO.setFatherName(null);
	}

	@Test
	void testSetMotherName() {
		identityEditDTO.setMotherName(null);
	}

	@Test
	void testSetSpouseName() {
		identityEditDTO.setSpouseName(null);
	}

	@Test
	void testSetMaritalStatusId() {
		identityEditDTO.setMaritalStatusId(null);
	}

	@Test
	void testSetMaritalStatus() {
		identityEditDTO.setMaritalStatus(null);
	}

	@Test
	void testSetDob() {
		identityEditDTO.setDob(null);
	}

	@Test
	void testSetGenderId() {
		identityEditDTO.setGenderId(null);
	}

	@Test
	void testSetGender() {
		identityEditDTO.setGender(null);
	}

	@Test
	void testSetTitleId() {
		identityEditDTO.setTitleId(null);
	}

	@Test
	void testSetTitle() {
		identityEditDTO.setTitle(null);
	}

	@Test
	void testSetLiteracyStatus() {
		identityEditDTO.setLiteracyStatus(null);
	}

	@Test
	void testSetChangeInAddress() {
		identityEditDTO.setChangeInAddress(null);
	}

	@Test
	void testSetCurrentAddress() {
		identityEditDTO.setCurrentAddress(null);
	}

	@Test
	void testSetPermanentAddress() {
		identityEditDTO.setPermanentAddress(null);
	}

	@Test
	void testSetEmergencyAddress() {
		identityEditDTO.setEmergencyAddress(null);
	}

	@Test
	void testSetIsPermAddrSameAsCurrAddr() {
		identityEditDTO.setIsPermAddrSameAsCurrAddr(null);
	}

	@Test
	void testSetIsPermAddrSameAsEmerAddr() {
		identityEditDTO.setIsPermAddrSameAsEmerAddr(null);
	}

	@Test
	void testSetIsEmerAddrSameAsCurrAddr() {
		identityEditDTO.setIsEmerAddrSameAsCurrAddr(null);
	}

	@Test
	void testSetIsEmerAddrSameAsPermAddr() {
		identityEditDTO.setIsEmerAddrSameAsPermAddr(null);
	}

	@Test
	void testSetAddressType() {
		identityEditDTO.setAddressType(null);
	}

	@Test
	void testSetChangeInContacts() {
		identityEditDTO.setChangeInContacts(null);
	}

	@Test
	void testSetContact() {
		identityEditDTO.setContact(null);
	}

	@Test
	void testSetPreferredEmailId() {
		identityEditDTO.setPreferredEmailId(null);
	}

	@Test
	void testSetChangeInIdentities() {
		identityEditDTO.setChangeInIdentities(null);
	}

	@Test
	void testSetIdentities() {
		identityEditDTO.setIdentities(null);
	}

	@Test
	void testSetChangeInOtherDetails() {
		identityEditDTO.setChangeInOtherDetails(null);
	}

	@Test
	void testSetPreferredLanguageId() {
		identityEditDTO.setPreferredLanguageId(null);
	}

	@Test
	void testSetPreferredLanguage() {
		identityEditDTO.setPreferredLanguage(null);
	}

	@Test
	void testSetCommunityId() {
		identityEditDTO.setCommunityId(null);
	}

	@Test
	void testSetCommunity() {
		identityEditDTO.setCommunity(null);
	}

	@Test
	void testSetEducationId() {
		identityEditDTO.setEducationId(null);
	}

	@Test
	void testSetEducation() {
		identityEditDTO.setEducation(null);
	}

	@Test
	void testSetIncomeStatusId() {
		identityEditDTO.setIncomeStatusId(null);
	}

	@Test
	void testSetIncomeStatus() {
		identityEditDTO.setIncomeStatus(null);
	}

	@Test
	void testSetOccupationId() {
		identityEditDTO.setOccupationId(null);
	}

	@Test
	void testSetOccupation() {
		identityEditDTO.setOccupation(null);
	}

	@Test
	void testSetReligionId() {
		identityEditDTO.setReligionId(null);
	}

	@Test
	void testSetReligion() {
		identityEditDTO.setReligion(null);
	}

	@Test
	void testSetPlaceOfWork() {
		identityEditDTO.setPlaceOfWork(null);
	}

	@Test
	void testSetHealthCareWorkerId() {
		identityEditDTO.setHealthCareWorkerId(null);
	}

	@Test
	void testSetHealthCareWorker() {
		identityEditDTO.setHealthCareWorker(null);
	}

	@Test
	void testSetMonthlyFamilyIncome() {
		identityEditDTO.setMonthlyFamilyIncome(null);
	}

	@Test
	void testSetChangeInFamilyDetails() {
		identityEditDTO.setChangeInFamilyDetails(null);
	}

	@Test
	void testSetBenFamilyDTOs() {
		identityEditDTO.setBenFamilyDTOs(null);
	}

	@Test
	void testSetChangeInAssociations() {
		identityEditDTO.setChangeInAssociations(null);
	}

	@Test
	void testSetZoneId() {
		identityEditDTO.setZoneId(null);
	}

	@Test
	void testSetAreaId() {
		identityEditDTO.setAreaId(null);
	}

	@Test
	void testSetServicePointId() {
		identityEditDTO.setServicePointId(null);
	}

	@Test
	void testSetPhcId() {
		identityEditDTO.setPhcId(null);
	}

	@Test
	void testSetRemarks() {
		identityEditDTO.setRemarks(null);
	}

	@Test
	void testSetSourceOfInfo() {
		identityEditDTO.setSourceOfInfo(null);
	}

	@Test
	void testSetStatusId() {
		identityEditDTO.setStatusId(null);
	}

	@Test
	void testSetStatus() {
		identityEditDTO.setStatus(null);
	}

	@Test
	void testSetChangeInBankDetails() {
		identityEditDTO.setChangeInBankDetails(null);
	}

	@Test
	void testSetBankName() {
		identityEditDTO.setBankName(null);
	}

	@Test
	void testSetBranchName() {
		identityEditDTO.setBranchName(null);
	}

	@Test
	void testSetIfscCode() {
		identityEditDTO.setIfscCode(null);
	}

	@Test
	void testSetAccountNo() {
		identityEditDTO.setAccountNo(null);
	}

	@Test
	void testSetBenAccountID() {
		identityEditDTO.setBenAccountID(null);
	}

	@Test
	void testSetChangeInBenImage() {
		identityEditDTO.setChangeInBenImage(null);
	}

	@Test
	void testSetBenImage() {
		identityEditDTO.setBenImage(null);
	}

	@Test
	void testSetBenImageId() {
		identityEditDTO.setBenImageId(null);
	}

	@Test
	void testSetMarriageDate() {
		identityEditDTO.setMarriageDate(null);
	}

	@Test
	void testSetAgeAtMarriage() {
		identityEditDTO.setAgeAtMarriage(null);
	}

	@Test
	void testSetSexualOrientationID() {
		identityEditDTO.setSexualOrientationID(null);
	}

	@Test
	void testSetSexualOrientationType() {
		identityEditDTO.setSexualOrientationType(null);
	}

	@Test
	void testSetIsHIVPositive() {
		identityEditDTO.setIsHIVPositive(null);
	}

	@Test
	void testSetVanID() {
		identityEditDTO.setVanID(null);
	}

	@Test
	void testSetParkingPlaceId() {
		identityEditDTO.setParkingPlaceId(null);
	}

	@Test
	void testSetEmergencyRegistration() {
		identityEditDTO.setEmergencyRegistration(false);
	}

	@Test
	void testEqualsObject() {
		IdentityEditDTO identityEditDTO2 = new IdentityEditDTO();
		identityEditDTO.equals(identityEditDTO2);
	}

	@Test
	void testCanEqual() {
		IdentityEditDTO identityEditDTO2 = new IdentityEditDTO();
		identityEditDTO.canEqual(identityEditDTO2);
	}

	@Test
	void testToString() {
		identityEditDTO.toString();
	}

}
