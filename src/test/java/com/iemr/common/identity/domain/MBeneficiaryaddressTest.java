package com.iemr.common.identity.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class MBeneficiaryaddressTest {
	@InjectMocks
	MBeneficiaryaddress mbeneficiaryaddress;
	
	@Test
	void testHashCode() {
		mbeneficiaryaddress.hashCode();
	}

	@Test
	void testSetCurrentAddress() {
		mbeneficiaryaddress.setCurrAddressValue(null);
	}

	@Test
	void testSetPermanentAddress() {
		Address address = new Address();
		mbeneficiaryaddress.setPermanentAddress(address);
	}

	@Test
	void testSetEmergencyAddress() {
		Address address = new Address();
		mbeneficiaryaddress.setEmergencyAddress(address);
	}

	@Test
	void testGetBenAddressID() {
		mbeneficiaryaddress.getBenAddressID();
	}

	@Test
	void testGetCreatedBy() {
		mbeneficiaryaddress.getCreatedBy();
	}

	@Test
	void testGetCreatedDate() {
		mbeneficiaryaddress.getCreatedDate();
	}

	@Test
	void testGetCurrAddrLine1() {
		mbeneficiaryaddress.getCurrAddrLine1();
	}

	@Test
	void testGetCurrAddrLine2() {
		mbeneficiaryaddress.getCurrAddrLine2();
	}

	@Test
	void testGetCurrAddrLine3() {
		mbeneficiaryaddress.getCurrAddrLine3();
	}

	@Test
	void testGetCurrCountry() {
		mbeneficiaryaddress.getCurrCountry();
	}

	@Test
	void testGetCurrCountryId() {
		mbeneficiaryaddress.getCurrCountryId();
	}

	@Test
	void testGetCurrDistrict() {
		mbeneficiaryaddress.getCurrDistrict();
	}

	@Test
	void testGetCurrDistrictId() {
		mbeneficiaryaddress.getCurrDistrictId();
	}

	@Test
	void testGetCurrAddressValue() {
		mbeneficiaryaddress.getCurrAddressValue();
	}

	@Test
	void testGetCurrPinCode() {
		mbeneficiaryaddress.getCurrPinCode();
	}

	@Test
	void testGetCurrState() {
		mbeneficiaryaddress.getCurrState();
	}

	@Test
	void testGetCurrStateId() {
		mbeneficiaryaddress.getCurrStateId();
	}

	@Test
	void testGetCurrSubDistrict() {
		mbeneficiaryaddress.getCurrSubDistrict();
	}

	@Test
	void testGetCurrSubDistrictId() {
		mbeneficiaryaddress.getCurrSubDistrictId();
	}

	@Test
	void testGetCurrVillage() {
		mbeneficiaryaddress.getCurrVillage();
	}

	@Test
	void testGetCurrHabitation() {
		mbeneficiaryaddress.getCurrHabitation();
	}

	@Test
	void testGetCurrVillageId() {
		mbeneficiaryaddress.getCurrVillageId();
	}

	@Test
	void testGetDeleted() {
		mbeneficiaryaddress.getDeleted();
	}

	@Test
	void testGetEmerAddrLine1() {
		mbeneficiaryaddress.getEmerAddrLine1();
	}

	@Test
	void testGetEmerAddrLine2() {
		mbeneficiaryaddress.getEmerAddrLine2();
	}

	@Test
	void testGetEmerAddrLine3() {
		mbeneficiaryaddress.getEmerAddrLine3();
	}

	@Test
	void testGetEmerCountry() {
		mbeneficiaryaddress.getEmerCountry();
	}

	@Test
	void testGetEmerCountryId() {
		mbeneficiaryaddress.getEmerCountryId();
	}

	@Test
	void testGetEmerDistrict() {
		mbeneficiaryaddress.getEmerDistrict();
	}

	@Test
	void testGetEmerDistrictId() {
		mbeneficiaryaddress.getEmerDistrictId();
	}

	@Test
	void testGetEmerAddressValue() {
		mbeneficiaryaddress.getEmerAddressValue();
	}

	@Test
	void testGetEmerPinCode() {
		mbeneficiaryaddress.getEmerPinCode();
	}

	@Test
	void testGetEmerState() {
		mbeneficiaryaddress.getEmerState();
	}

	@Test
	void testGetEmerStateId() {
		mbeneficiaryaddress.getEmerStateId();
	}

	@Test
	void testGetEmerSubDistrict() {
		mbeneficiaryaddress.getEmerSubDistrict();
	}

	@Test
	void testGetEmerSubDistrictId() {
		mbeneficiaryaddress.getEmerSubDistrictId();
	}

	@Test
	void testGetEmerVillage() {
		mbeneficiaryaddress.getEmerVillage();
	}

	@Test
	void testGetEmerHabitation() {
		mbeneficiaryaddress.getEmerHabitation();
	}

	@Test
	void testGetEmerVillageId() {
		mbeneficiaryaddress.getEmerVillageId();
	}

	@Test
	void testGetLastModDate() {
		mbeneficiaryaddress.getLastModDate();
	}

	@Test
	void testGetModifiedBy() {
		mbeneficiaryaddress.getModifiedBy();
	}

	@Test
	void testGetPermAddrLine1() {
		mbeneficiaryaddress.getPermAddrLine1();
	}

	@Test
	void testGetPermAddrLine2() {
		mbeneficiaryaddress.getPermAddrLine2();
	}

	@Test
	void testGetPermAddrLine3() {
		mbeneficiaryaddress.getPermAddrLine3();
	}

	@Test
	void testGetPermAddressValue() {
		mbeneficiaryaddress.getPermAddressValue();
	}

	@Test
	void testGetPermCountry() {
		mbeneficiaryaddress.getPermCountry();
	}

	@Test
	void testGetPermCountryId() {
		mbeneficiaryaddress.getPermCountryId();
	}

	@Test
	void testGetPermDistrict() {
		mbeneficiaryaddress.getPermDistrict();
	}

	@Test
	void testGetPermDistrictId() {
		mbeneficiaryaddress.getPermDistrictId();
	}

	@Test
	void testGetPermPinCode() {
		mbeneficiaryaddress.getPermPinCode();
	}

	@Test
	void testGetPermState() {
		mbeneficiaryaddress.getPermState();
	}

	@Test
	void testGetPermStateId() {
		mbeneficiaryaddress.getPermStateId();
	}

	@Test
	void testGetPermSubDistrict() {
		mbeneficiaryaddress.getPermSubDistrict();
	}

	@Test
	void testGetPermSubDistrictId() {
		mbeneficiaryaddress.getPermSubDistrictId();
	}

	@Test
	void testGetPermVillage() {
		mbeneficiaryaddress.getPermVillage();
	}

	@Test
	void testGetPermHabitation() {
		mbeneficiaryaddress.getPermHabitation();
	}

	@Test
	void testGetPermVillageId() {
		mbeneficiaryaddress.getPermVillageId();
	}

	@Test
	void testGetPermZoneID() {
		mbeneficiaryaddress.getPermZoneID();
	}

	@Test
	void testGetPermZone() {
		mbeneficiaryaddress.getPermZone();
	}

	@Test
	void testGetPermAreaId() {
		mbeneficiaryaddress.getPermAreaId();
	}

	@Test
	void testGetPermArea() {
		mbeneficiaryaddress.getPermArea();
	}

	@Test
	void testGetPermServicePointId() {
		mbeneficiaryaddress.getPermServicePointId();
	}

	@Test
	void testGetPermServicePoint() {
		mbeneficiaryaddress.getPermServicePoint();
	}

	@Test
	void testGetCurrZoneID() {
		mbeneficiaryaddress.getCurrZoneID();
	}

	@Test
	void testGetCurrZone() {
		mbeneficiaryaddress.getCurrZone();
	}

	@Test
	void testGetCurrAreaId() {
		mbeneficiaryaddress.getCurrAreaId();
	}

	@Test
	void testGetCurrArea() {
		mbeneficiaryaddress.getCurrArea();
	}

	@Test
	void testGetCurrServicePointId() {
		mbeneficiaryaddress.getCurrServicePointId();
	}

	@Test
	void testGetCurrServicePoint() {
		mbeneficiaryaddress.getCurrServicePoint();
	}

	@Test
	void testGetEmerZoneID() {
		mbeneficiaryaddress.getEmerZoneID();
	}

	@Test
	void testGetEmerZone() {
		mbeneficiaryaddress.getEmerZone();
	}

	@Test
	void testGetEmerAreaId() {
		mbeneficiaryaddress.getEmerAreaId();
	}

	@Test
	void testGetEmerArea() {
		mbeneficiaryaddress.getEmerArea();
	}

	@Test
	void testGetEmerServicePointId() {
		mbeneficiaryaddress.getEmerServicePointId();
	}

	@Test
	void testGetEmerServicePoint() {
		mbeneficiaryaddress.getEmerServicePoint();
	}

	@Test
	void testGetProcessed() {
		mbeneficiaryaddress.getProcessed();
	}

	@Test
	void testGetReserved() {
		mbeneficiaryaddress.getReserved();
	}

	@Test
	void testGetReservedById() {
		mbeneficiaryaddress.getReservedById();
	}

	@Test
	void testGetReservedFor() {
		mbeneficiaryaddress.getReservedFor();
	}

	@Test
	void testGetReservedOn() {
		mbeneficiaryaddress.getReservedOn();
	}

	@Test
	void testGetVanID() {
		mbeneficiaryaddress.getVanID();
	}

	@Test
	void testGetParkingPlaceID() {
		mbeneficiaryaddress.getParkingPlaceID();
	}

	@Test
	void testGetVanSerialNo() {
		mbeneficiaryaddress.getVanSerialNo();
	}

	@Test
	void testSetBenAddressID() {
		mbeneficiaryaddress.setBenAddressID(null);
	}

	@Test
	void testSetCreatedBy() {
		mbeneficiaryaddress.setCreatedBy(null);
	}

	@Test
	void testSetCreatedDate() {
		mbeneficiaryaddress.setCreatedDate(null);
	}

	@Test
	void testSetCurrAddrLine1() {
		mbeneficiaryaddress.setCurrAddrLine1(null);
	}

	@Test
	void testSetCurrAddrLine2() {
		mbeneficiaryaddress.setCurrAddrLine2(null);
	}

	@Test
	void testSetCurrAddrLine3() {
		mbeneficiaryaddress.setCurrAddrLine3(null);
	}

	@Test
	void testSetCurrCountry() {
		mbeneficiaryaddress.setCurrCountry(null);
	}

	@Test
	void testSetCurrCountryId() {
		mbeneficiaryaddress.setCurrCountryId(null);
	}

	@Test
	void testSetCurrDistrict() {
		mbeneficiaryaddress.setCurrDistrict(null);
	}

	@Test
	void testSetCurrDistrictId() {
		mbeneficiaryaddress.setCurrDistrictId(null);
	}

	@Test
	void testSetCurrAddressValue() {
		mbeneficiaryaddress.setCurrAddressValue(null);
	}

	@Test
	void testSetCurrPinCode() {
		mbeneficiaryaddress.setCurrPinCode(null);
	}

	@Test
	void testSetCurrState() {
		mbeneficiaryaddress.setCurrState(null);
	}

	@Test
	void testSetCurrStateId() {
		mbeneficiaryaddress.setCurrStateId(null);
	}

	@Test
	void testSetCurrSubDistrict() {
		mbeneficiaryaddress.setCurrSubDistrict(null);
	}

	@Test
	void testSetCurrSubDistrictId() {
		mbeneficiaryaddress.setCurrSubDistrictId(null);
	}

	@Test
	void testSetCurrVillage() {
		mbeneficiaryaddress.setCurrVillage(null);
	}

	@Test
	void testSetCurrHabitation() {
		mbeneficiaryaddress.setCurrHabitation(null);
	}

	@Test
	void testSetCurrVillageId() {
		mbeneficiaryaddress.setCurrVillageId(null);
	}

	@Test
	void testSetDeleted() {
		mbeneficiaryaddress.setDeleted(null);
	}

	@Test
	void testSetEmerAddrLine1() {
		mbeneficiaryaddress.setEmerAddrLine1(null);
	}

	@Test
	void testSetEmerAddrLine2() {
		mbeneficiaryaddress.setEmerAddrLine2(null);
	}

	@Test
	void testSetEmerAddrLine3() {
		mbeneficiaryaddress.setEmerAddrLine3(null);
	}

	@Test
	void testSetEmerCountry() {
		mbeneficiaryaddress.setEmerCountry(null);
	}

	@Test
	void testSetEmerCountryId() {
		mbeneficiaryaddress.setEmerCountryId(null);
	}

	@Test
	void testSetEmerDistrict() {
		mbeneficiaryaddress.setEmerDistrict(null);
	}

	@Test
	void testSetEmerDistrictId() {
		mbeneficiaryaddress.setEmerDistrictId(null);
	}

	@Test
	void testSetEmerAddressValue() {
		mbeneficiaryaddress.setEmerAddressValue(null);
	}

	@Test
	void testSetEmerPinCode() {
		mbeneficiaryaddress.setEmerPinCode(null);
	}

	@Test
	void testSetEmerState() {
		mbeneficiaryaddress.setEmerState(null);
	}

	@Test
	void testSetEmerStateId() {
		mbeneficiaryaddress.setEmerStateId(null);
	}

	@Test
	void testSetEmerSubDistrict() {
		mbeneficiaryaddress.setEmerSubDistrict(null);
	}

	@Test
	void testSetEmerSubDistrictId() {
		mbeneficiaryaddress.setEmerSubDistrictId(null);
	}

	@Test
	void testSetEmerVillage() {
		mbeneficiaryaddress.setEmerVillage(null);
	}

	@Test
	void testSetEmerHabitation() {
		mbeneficiaryaddress.setEmerHabitation(null);
	}

	@Test
	void testSetEmerVillageId() {
		mbeneficiaryaddress.setEmerVillageId(null);
	}

	@Test
	void testSetLastModDate() {
		mbeneficiaryaddress.setLastModDate(null);
	}

	@Test
	void testSetModifiedBy() {
		mbeneficiaryaddress.setModifiedBy(null);
	}

	@Test
	void testSetPermAddrLine1() {
		mbeneficiaryaddress.setPermAddrLine1(null);
	}

	@Test
	void testSetPermAddrLine2() {
		mbeneficiaryaddress.setPermAddrLine2(null);
	}

	@Test
	void testSetPermAddrLine3() {
		mbeneficiaryaddress.setEmerAddrLine3(null);
	}

	@Test
	void testSetPermAddressValue() {
		mbeneficiaryaddress.setPermAddressValue(null);
	}

	@Test
	void testSetPermCountry() {
		mbeneficiaryaddress.setPermCountry(null);
	}

	@Test
	void testSetPermCountryId() {
		mbeneficiaryaddress.setPermCountryId(null);
	}

	@Test
	void testSetPermDistrict() {
		mbeneficiaryaddress.setPermDistrict(null);
	}

	@Test
	void testSetPermDistrictId() {
		mbeneficiaryaddress.setPermDistrictId(null);
	}

	@Test
	void testSetPermPinCode() {
		mbeneficiaryaddress.setPermPinCode(null);
	}

	@Test
	void testSetPermState() {
		mbeneficiaryaddress.setPermState(null);
	}

	@Test
	void testSetPermStateId() {
		mbeneficiaryaddress.setPermStateId(null);
	}

	@Test
	void testSetPermSubDistrict() {
		mbeneficiaryaddress.setPermSubDistrict(null);
	}

	@Test
	void testSetPermSubDistrictId() {
		mbeneficiaryaddress.setPermSubDistrictId(null);
	}

	@Test
	void testSetPermVillage() {
		mbeneficiaryaddress.setPermVillage(null);
	}

	@Test
	void testSetPermHabitation() {
		mbeneficiaryaddress.setPermHabitation(null);
	}

	@Test
	void testSetPermVillageId() {
		mbeneficiaryaddress.setPermVillageId(null);
	}

	@Test
	void testSetPermZoneID() {
		mbeneficiaryaddress.setPermZoneID(null);
	}

	@Test
	void testSetPermZone() {
		mbeneficiaryaddress.setPermZone(null);
	}

	@Test
	void testSetPermAreaId() {
		mbeneficiaryaddress.setPermAreaId(null);
	}

	@Test
	void testSetPermArea() {
		mbeneficiaryaddress.setPermArea(null);
	}

	@Test
	void testSetPermServicePointId() {
		mbeneficiaryaddress.setPermServicePointId(null);
	}

	@Test
	void testSetPermServicePoint() {
		mbeneficiaryaddress.setPermServicePoint(null);
	}

	@Test
	void testSetCurrZoneID() {
		mbeneficiaryaddress.setCurrZoneID(null);
	}

	@Test
	void testSetCurrZone() {
		mbeneficiaryaddress.setCurrZone(null);
	}

	@Test
	void testSetCurrAreaId() {
		mbeneficiaryaddress.setCurrAreaId(null);
	}

	@Test
	void testSetCurrArea() {
		mbeneficiaryaddress.setCurrArea(null);
	}

	@Test
	void testSetCurrServicePointId() {
		mbeneficiaryaddress.setCurrServicePointId(null);
	}

	@Test
	void testSetCurrServicePoint() {
		mbeneficiaryaddress.setCurrServicePoint(null);
	}

	@Test
	void testSetEmerZoneID() {
		mbeneficiaryaddress.setEmerZoneID(null);
	}

	@Test
	void testSetEmerZone() {
		mbeneficiaryaddress.setEmerZone(null);
	}

	@Test
	void testSetEmerAreaId() {
		mbeneficiaryaddress.setEmerAreaId(null);
	}

	@Test
	void testSetEmerArea() {
		mbeneficiaryaddress.setEmerArea(null);
	}

	@Test
	void testSetEmerServicePointId() {
		mbeneficiaryaddress.setEmerServicePointId(null);
	}

	@Test
	void testSetEmerServicePoint() {
		mbeneficiaryaddress.setEmerServicePoint(null);
	}

	@Test
	void testSetProcessed() {
		mbeneficiaryaddress.setProcessed(null);
	}

	@Test
	void testSetReserved() {
		mbeneficiaryaddress.setReserved(null);
	}

	@Test
	void testSetReservedById() {
		mbeneficiaryaddress.setReservedById(null);
	}

	@Test
	void testSetReservedFor() {
		mbeneficiaryaddress.setReservedFor(null);
	}

	@Test
	void testSetReservedOn() {
		mbeneficiaryaddress.setReservedOn(null);
	}

	@Test
	void testSetVanID() {
		mbeneficiaryaddress.setVanID(null);
	}

	@Test
	void testSetParkingPlaceID() {
		mbeneficiaryaddress.setParkingPlaceID(null);
	}

	@Test
	void testSetVanSerialNo() {
		mbeneficiaryaddress.setVanSerialNo(null);
	}

	@Test
	void testEqualsObject() {
		MBeneficiaryaddress mBeneficiaryaddress2 = new MBeneficiaryaddress();
		mbeneficiaryaddress.equals(mBeneficiaryaddress2);
	}

	@Test
	void testCanEqual() {
		MBeneficiaryaddress mBeneficiaryaddress2 = new MBeneficiaryaddress();
		mbeneficiaryaddress.canEqual(mBeneficiaryaddress2);
	}

	@Test
	void testToString() {
		mbeneficiaryaddress.toString();
	}

}
