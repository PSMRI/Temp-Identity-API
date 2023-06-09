package com.iemr.common.identity.mapper;

import com.iemr.common.identity.domain.Address;
import com.iemr.common.identity.domain.Contact;
import com.iemr.common.identity.domain.Identity;
import com.iemr.common.identity.domain.MBeneficiaryAccount;
import com.iemr.common.identity.domain.MBeneficiaryImage;
import com.iemr.common.identity.domain.MBeneficiaryaddress;
import com.iemr.common.identity.domain.MBeneficiaryconsent;
import com.iemr.common.identity.domain.MBeneficiarycontact;
import com.iemr.common.identity.domain.MBeneficiarydetail;
import com.iemr.common.identity.domain.MBeneficiaryfamilymapping;
import com.iemr.common.identity.domain.MBeneficiaryidentity;
import com.iemr.common.identity.domain.MBeneficiarymapping;
import com.iemr.common.identity.domain.MBeneficiaryservicemapping;
import com.iemr.common.identity.dto.BenDetailDTO;
import com.iemr.common.identity.dto.BenFamilyDTO;
import com.iemr.common.identity.dto.BenIdentityDTO;
import com.iemr.common.identity.dto.BenServiceDTO;
import com.iemr.common.identity.dto.IdentityEditDTO;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T11:27:18+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
@Component
public class IdentityEditMapperImpl implements IdentityEditMapper {

    @Override
    public MBeneficiarymapping IdentityEditDTOToMBeneficiarymapping(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiarymapping mBeneficiarymapping = new MBeneficiarymapping();

        mBeneficiarymapping.setCreatedBy( dto.getAgentName() );
        mBeneficiarymapping.setLastModDate( dto.getEventTypeDate() );
        mBeneficiarymapping.setBenImageId( dto.getBenImageId() );
        if ( dto.getBenAccountID() != null ) {
            mBeneficiarymapping.setBenAccountID( dto.getBenAccountID().longValue() );
        }
        mBeneficiarymapping.setVanID( dto.getVanID() );

        return mBeneficiarymapping;
    }

    @Override
    public MBeneficiaryaddress IdentityEditDTOToMBeneficiaryaddress(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiaryaddress mBeneficiaryaddress = new MBeneficiaryaddress();

        Integer parkingPlaceID = dtoCurrentAddressParkingPlaceID( dto );
        if ( parkingPlaceID != null ) {
            mBeneficiaryaddress.setCurrAreaId( parkingPlaceID );
        }
        Integer villageId = dtoEmergencyAddressVillageId( dto );
        if ( villageId != null ) {
            mBeneficiaryaddress.setEmerVillageId( villageId );
        }
        String habitation = dtoCurrentAddressHabitation( dto );
        if ( habitation != null ) {
            mBeneficiaryaddress.setCurrHabitation( habitation );
        }
        Integer servicePointID = dtoEmergencyAddressServicePointID( dto );
        if ( servicePointID != null ) {
            mBeneficiaryaddress.setEmerServicePointId( servicePointID );
        }
        String addressValue = dtoEmergencyAddressAddressValue( dto );
        if ( addressValue != null ) {
            mBeneficiaryaddress.setEmerAddressValue( addressValue );
        }
        Integer villageId1 = dtoPermanentAddressVillageId( dto );
        if ( villageId1 != null ) {
            mBeneficiaryaddress.setPermVillageId( villageId1 );
        }
        Integer zoneID = dtoPermanentAddressZoneID( dto );
        if ( zoneID != null ) {
            mBeneficiaryaddress.setPermZoneID( zoneID );
        }
        String addrLine1 = dtoEmergencyAddressAddrLine1( dto );
        if ( addrLine1 != null ) {
            mBeneficiaryaddress.setEmerAddrLine1( addrLine1 );
        }
        String addrLine3 = dtoEmergencyAddressAddrLine3( dto );
        if ( addrLine3 != null ) {
            mBeneficiaryaddress.setEmerAddrLine3( addrLine3 );
        }
        String addrLine2 = dtoEmergencyAddressAddrLine2( dto );
        if ( addrLine2 != null ) {
            mBeneficiaryaddress.setEmerAddrLine2( addrLine2 );
        }
        String zoneName = dtoEmergencyAddressZoneName( dto );
        if ( zoneName != null ) {
            mBeneficiaryaddress.setEmerZone( zoneName );
        }
        String addrLine3_1 = dtoPermanentAddressAddrLine3( dto );
        if ( addrLine3_1 != null ) {
            mBeneficiaryaddress.setPermAddrLine3( addrLine3_1 );
        }
        String addrLine2_1 = dtoPermanentAddressAddrLine2( dto );
        if ( addrLine2_1 != null ) {
            mBeneficiaryaddress.setPermAddrLine2( addrLine2_1 );
        }
        Integer subDistrictId = dtoCurrentAddressSubDistrictId( dto );
        if ( subDistrictId != null ) {
            mBeneficiaryaddress.setCurrSubDistrictId( subDistrictId );
        }
        String addrLine1_1 = dtoPermanentAddressAddrLine1( dto );
        if ( addrLine1_1 != null ) {
            mBeneficiaryaddress.setPermAddrLine1( addrLine1_1 );
        }
        String subDistrict = dtoEmergencyAddressSubDistrict( dto );
        if ( subDistrict != null ) {
            mBeneficiaryaddress.setEmerSubDistrict( subDistrict );
        }
        String country = dtoEmergencyAddressCountry( dto );
        if ( country != null ) {
            mBeneficiaryaddress.setEmerCountry( country );
        }
        String state = dtoPermanentAddressState( dto );
        if ( state != null ) {
            mBeneficiaryaddress.setPermState( state );
        }
        String country1 = dtoCurrentAddressCountry( dto );
        if ( country1 != null ) {
            mBeneficiaryaddress.setCurrCountry( country1 );
        }
        String servicePointName = dtoCurrentAddressServicePointName( dto );
        if ( servicePointName != null ) {
            mBeneficiaryaddress.setCurrServicePoint( servicePointName );
        }
        String village = dtoPermanentAddressVillage( dto );
        if ( village != null ) {
            mBeneficiaryaddress.setPermVillage( village );
        }
        Integer districtId = dtoPermanentAddressDistrictId( dto );
        if ( districtId != null ) {
            mBeneficiaryaddress.setPermDistrictId( districtId );
        }
        String addressValue1 = dtoPermanentAddressAddressValue( dto );
        if ( addressValue1 != null ) {
            mBeneficiaryaddress.setPermAddressValue( addressValue1 );
        }
        String district = dtoCurrentAddressDistrict( dto );
        if ( district != null ) {
            mBeneficiaryaddress.setCurrDistrict( district );
        }
        String parkingPlaceName = dtoPermanentAddressParkingPlaceName( dto );
        if ( parkingPlaceName != null ) {
            mBeneficiaryaddress.setPermArea( parkingPlaceName );
        }
        String pinCode = dtoCurrentAddressPinCode( dto );
        if ( pinCode != null ) {
            mBeneficiaryaddress.setCurrPinCode( pinCode );
        }
        Integer stateId = dtoEmergencyAddressStateId( dto );
        if ( stateId != null ) {
            mBeneficiaryaddress.setEmerStateId( stateId );
        }
        String pinCode1 = dtoEmergencyAddressPinCode( dto );
        if ( pinCode1 != null ) {
            mBeneficiaryaddress.setEmerPinCode( pinCode1 );
        }
        Integer stateId1 = dtoCurrentAddressStateId( dto );
        if ( stateId1 != null ) {
            mBeneficiaryaddress.setCurrStateId( stateId1 );
        }
        String parkingPlaceName1 = dtoEmergencyAddressParkingPlaceName( dto );
        if ( parkingPlaceName1 != null ) {
            mBeneficiaryaddress.setEmerArea( parkingPlaceName1 );
        }
        Integer zoneID1 = dtoEmergencyAddressZoneID( dto );
        if ( zoneID1 != null ) {
            mBeneficiaryaddress.setEmerZoneID( zoneID1 );
        }
        String subDistrict1 = dtoPermanentAddressSubDistrict( dto );
        if ( subDistrict1 != null ) {
            mBeneficiaryaddress.setPermSubDistrict( subDistrict1 );
        }
        String addrLine3_2 = dtoCurrentAddressAddrLine3( dto );
        if ( addrLine3_2 != null ) {
            mBeneficiaryaddress.setCurrAddrLine3( addrLine3_2 );
        }
        Integer countryId = dtoEmergencyAddressCountryId( dto );
        if ( countryId != null ) {
            mBeneficiaryaddress.setEmerCountryId( countryId );
        }
        String addrLine2_2 = dtoCurrentAddressAddrLine2( dto );
        if ( addrLine2_2 != null ) {
            mBeneficiaryaddress.setCurrAddrLine2( addrLine2_2 );
        }
        String addrLine1_2 = dtoCurrentAddressAddrLine1( dto );
        if ( addrLine1_2 != null ) {
            mBeneficiaryaddress.setCurrAddrLine1( addrLine1_2 );
        }
        String zoneName1 = dtoPermanentAddressZoneName( dto );
        if ( zoneName1 != null ) {
            mBeneficiaryaddress.setPermZone( zoneName1 );
        }
        String servicePointName1 = dtoPermanentAddressServicePointName( dto );
        if ( servicePointName1 != null ) {
            mBeneficiaryaddress.setPermServicePoint( servicePointName1 );
        }
        Integer servicePointID1 = dtoCurrentAddressServicePointID( dto );
        if ( servicePointID1 != null ) {
            mBeneficiaryaddress.setCurrServicePointId( servicePointID1 );
        }
        String country2 = dtoPermanentAddressCountry( dto );
        if ( country2 != null ) {
            mBeneficiaryaddress.setPermCountry( country2 );
        }
        String zoneName2 = dtoCurrentAddressZoneName( dto );
        if ( zoneName2 != null ) {
            mBeneficiaryaddress.setCurrZone( zoneName2 );
        }
        String state1 = dtoEmergencyAddressState( dto );
        if ( state1 != null ) {
            mBeneficiaryaddress.setEmerState( state1 );
        }
        Integer districtId1 = dtoEmergencyAddressDistrictId( dto );
        if ( districtId1 != null ) {
            mBeneficiaryaddress.setEmerDistrictId( districtId1 );
        }
        String pinCode2 = dtoPermanentAddressPinCode( dto );
        if ( pinCode2 != null ) {
            mBeneficiaryaddress.setPermPinCode( pinCode2 );
        }
        Integer districtId2 = dtoCurrentAddressDistrictId( dto );
        if ( districtId2 != null ) {
            mBeneficiaryaddress.setCurrDistrictId( districtId2 );
        }
        String district1 = dtoPermanentAddressDistrict( dto );
        if ( district1 != null ) {
            mBeneficiaryaddress.setPermDistrict( district1 );
        }
        Integer zoneID2 = dtoCurrentAddressZoneID( dto );
        if ( zoneID2 != null ) {
            mBeneficiaryaddress.setCurrZoneID( zoneID2 );
        }
        Integer countryId1 = dtoCurrentAddressCountryId( dto );
        if ( countryId1 != null ) {
            mBeneficiaryaddress.setCurrCountryId( countryId1 );
        }
        String state2 = dtoCurrentAddressState( dto );
        if ( state2 != null ) {
            mBeneficiaryaddress.setCurrState( state2 );
        }
        Integer countryId2 = dtoPermanentAddressCountryId( dto );
        if ( countryId2 != null ) {
            mBeneficiaryaddress.setPermCountryId( countryId2 );
        }
        Integer parkingPlaceID1 = dtoPermanentAddressParkingPlaceID( dto );
        if ( parkingPlaceID1 != null ) {
            mBeneficiaryaddress.setPermAreaId( parkingPlaceID1 );
        }
        String habitation1 = dtoEmergencyAddressHabitation( dto );
        if ( habitation1 != null ) {
            mBeneficiaryaddress.setEmerHabitation( habitation1 );
        }
        Integer subDistrictId1 = dtoPermanentAddressSubDistrictId( dto );
        if ( subDistrictId1 != null ) {
            mBeneficiaryaddress.setPermSubDistrictId( subDistrictId1 );
        }
        Integer villageId2 = dtoCurrentAddressVillageId( dto );
        if ( villageId2 != null ) {
            mBeneficiaryaddress.setCurrVillageId( villageId2 );
        }
        String parkingPlaceName2 = dtoCurrentAddressParkingPlaceName( dto );
        if ( parkingPlaceName2 != null ) {
            mBeneficiaryaddress.setCurrArea( parkingPlaceName2 );
        }
        Integer parkingPlaceID2 = dtoEmergencyAddressParkingPlaceID( dto );
        if ( parkingPlaceID2 != null ) {
            mBeneficiaryaddress.setEmerAreaId( parkingPlaceID2 );
        }
        Integer subDistrictId2 = dtoEmergencyAddressSubDistrictId( dto );
        if ( subDistrictId2 != null ) {
            mBeneficiaryaddress.setEmerSubDistrictId( subDistrictId2 );
        }
        String servicePointName2 = dtoEmergencyAddressServicePointName( dto );
        if ( servicePointName2 != null ) {
            mBeneficiaryaddress.setEmerServicePoint( servicePointName2 );
        }
        String village1 = dtoCurrentAddressVillage( dto );
        if ( village1 != null ) {
            mBeneficiaryaddress.setCurrVillage( village1 );
        }
        mBeneficiaryaddress.setCreatedDate( dto.getEventTypeDate() );
        String subDistrict2 = dtoCurrentAddressSubDistrict( dto );
        if ( subDistrict2 != null ) {
            mBeneficiaryaddress.setCurrSubDistrict( subDistrict2 );
        }
        mBeneficiaryaddress.setCreatedBy( dto.getAgentName() );
        String village2 = dtoEmergencyAddressVillage( dto );
        if ( village2 != null ) {
            mBeneficiaryaddress.setEmerVillage( village2 );
        }
        Integer stateId2 = dtoPermanentAddressStateId( dto );
        if ( stateId2 != null ) {
            mBeneficiaryaddress.setPermStateId( stateId2 );
        }
        Integer servicePointID2 = dtoPermanentAddressServicePointID( dto );
        if ( servicePointID2 != null ) {
            mBeneficiaryaddress.setPermServicePointId( servicePointID2 );
        }
        String habitation2 = dtoPermanentAddressHabitation( dto );
        if ( habitation2 != null ) {
            mBeneficiaryaddress.setPermHabitation( habitation2 );
        }
        String addressValue2 = dtoCurrentAddressAddressValue( dto );
        if ( addressValue2 != null ) {
            mBeneficiaryaddress.setCurrAddressValue( addressValue2 );
        }
        String district2 = dtoEmergencyAddressDistrict( dto );
        if ( district2 != null ) {
            mBeneficiaryaddress.setEmerDistrict( district2 );
        }
        mBeneficiaryaddress.setCurrentAddress( dto.getCurrentAddress() );
        mBeneficiaryaddress.setPermanentAddress( dto.getPermanentAddress() );
        mBeneficiaryaddress.setEmergencyAddress( dto.getEmergencyAddress() );
        mBeneficiaryaddress.setVanID( dto.getVanID() );

        return mBeneficiaryaddress;
    }

    @Override
    public MBeneficiaryconsent IdentityEditDTOToDefaultMBeneficiaryconsent(IdentityEditDTO dto, Boolean defaultYes, Boolean defaultNo) {
        if ( dto == null && defaultYes == null && defaultNo == null ) {
            return null;
        }

        MBeneficiaryconsent mBeneficiaryconsent = new MBeneficiaryconsent();

        if ( dto != null ) {
            mBeneficiaryconsent.setCreatedDate( dto.getEventTypeDate() );
            mBeneficiaryconsent.setCreatedBy( dto.getAgentName() );
            mBeneficiaryconsent.setVanID( dto.getVanID() );
        }
        if ( defaultYes != null ) {
            mBeneficiaryconsent.setShareMedicalDetailsWithFamily( defaultYes );
            mBeneficiaryconsent.setShareMedicalDetailsWithDoctor( defaultYes );
            mBeneficiaryconsent.setSharePersonalDetailsWithSpouse( defaultYes );
            mBeneficiaryconsent.setSharePersonalDetailsWithDoctor( defaultYes );
            mBeneficiaryconsent.setShareMedicalDetailsWithSpouse( defaultYes );
        }
        if ( defaultNo != null ) {
            mBeneficiaryconsent.setShareAnonymousWithNGO( defaultNo );
            mBeneficiaryconsent.setShareMedicalDetailsWithFriends( defaultNo );
            mBeneficiaryconsent.setShareAnonymousWithMedicalCommunity( defaultNo );
            mBeneficiaryconsent.setShareMedicalDetailsForMedicalStudy( defaultNo );
            mBeneficiaryconsent.setSharePersonalDetailsWithFamily( defaultNo );
            mBeneficiaryconsent.setSharePersonalDetailsWithFriends( defaultNo );
            mBeneficiaryconsent.setSharePersonalDetailsWithNGO( defaultNo );
            mBeneficiaryconsent.setSharePersonalDetailsForMedicalStudy( defaultNo );
            mBeneficiaryconsent.setSharePersonalDetailsWithGovt( defaultNo );
            mBeneficiaryconsent.setShareAnonymousWithGovt( defaultNo );
            mBeneficiaryconsent.setShareMedicalDetailsWithNGO( defaultNo );
            mBeneficiaryconsent.setShareMedicalDetailsWithGovt( defaultNo );
        }

        return mBeneficiaryconsent;
    }

    @Override
    public MBeneficiarycontact IdentityEdiDTOToMBeneficiarycontact(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiarycontact mBeneficiarycontact = new MBeneficiarycontact();

        String emergencyContactNum = dtoContactEmergencyContactNum( dto );
        if ( emergencyContactNum != null ) {
            mBeneficiarycontact.setEmergencyContactNum( emergencyContactNum );
        }
        String preferredPhoneTyp = dtoContactPreferredPhoneTyp( dto );
        if ( preferredPhoneTyp != null ) {
            mBeneficiarycontact.setPreferredPhoneTyp( preferredPhoneTyp );
        }
        String preferredPhoneNum = dtoContactPreferredPhoneNum( dto );
        if ( preferredPhoneNum != null ) {
            mBeneficiarycontact.setPreferredPhoneNum( preferredPhoneNum );
        }
        mBeneficiarycontact.setEmailId( dto.getPreferredEmailId() );
        String preferredSMSPhoneNum = dtoContactPreferredSMSPhoneNum( dto );
        if ( preferredSMSPhoneNum != null ) {
            mBeneficiarycontact.setPreferredSMSPhoneNum( preferredSMSPhoneNum );
        }
        String phoneNum1 = dtoContactPhoneNum1( dto );
        if ( phoneNum1 != null ) {
            mBeneficiarycontact.setPhoneNum1( phoneNum1 );
        }
        String phoneNum2 = dtoContactPhoneNum2( dto );
        if ( phoneNum2 != null ) {
            mBeneficiarycontact.setPhoneNum2( phoneNum2 );
        }
        String phoneTyp5 = dtoContactPhoneTyp5( dto );
        if ( phoneTyp5 != null ) {
            mBeneficiarycontact.setPhoneTyp5( phoneTyp5 );
        }
        String phoneNum3 = dtoContactPhoneNum3( dto );
        if ( phoneNum3 != null ) {
            mBeneficiarycontact.setPhoneNum3( phoneNum3 );
        }
        mBeneficiarycontact.setCreatedDate( dto.getEventTypeDate() );
        String phoneNum4 = dtoContactPhoneNum4( dto );
        if ( phoneNum4 != null ) {
            mBeneficiarycontact.setPhoneNum4( phoneNum4 );
        }
        String preferredSMSPhoneTyp = dtoContactPreferredSMSPhoneTyp( dto );
        if ( preferredSMSPhoneTyp != null ) {
            mBeneficiarycontact.setPreferredSMSPhoneTyp( preferredSMSPhoneTyp );
        }
        String phoneNum5 = dtoContactPhoneNum5( dto );
        if ( phoneNum5 != null ) {
            mBeneficiarycontact.setPhoneNum5( phoneNum5 );
        }
        mBeneficiarycontact.setCreatedBy( dto.getAgentName() );
        String phoneTyp3 = dtoContactPhoneTyp3( dto );
        if ( phoneTyp3 != null ) {
            mBeneficiarycontact.setPhoneTyp3( phoneTyp3 );
        }
        String phoneTyp4 = dtoContactPhoneTyp4( dto );
        if ( phoneTyp4 != null ) {
            mBeneficiarycontact.setPhoneTyp4( phoneTyp4 );
        }
        String phoneTyp1 = dtoContactPhoneTyp1( dto );
        if ( phoneTyp1 != null ) {
            mBeneficiarycontact.setPhoneTyp1( phoneTyp1 );
        }
        String phoneTyp2 = dtoContactPhoneTyp2( dto );
        if ( phoneTyp2 != null ) {
            mBeneficiarycontact.setPhoneTyp2( phoneTyp2 );
        }
        mBeneficiarycontact.setVanID( dto.getVanID() );

        return mBeneficiarycontact;
    }

    @Override
    public MBeneficiarydetail IdentityEditDTOToMBeneficiarydetail(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiarydetail mBeneficiarydetail = new MBeneficiarydetail();

        mBeneficiarydetail.setFatherName( dto.getFatherName() );
        mBeneficiarydetail.setLastName( dto.getLastName() );
        mBeneficiarydetail.setPreferredLanguage( dto.getPreferredLanguage() );
        mBeneficiarydetail.setEducation( dto.getEducation() );
        mBeneficiarydetail.setOccupation( dto.getOccupation() );
        mBeneficiarydetail.setGender( dto.getGender() );
        mBeneficiarydetail.setTitleId( dto.getTitleId() );
        mBeneficiarydetail.setServicePointId( dto.getServicePointId() );
        if ( dto.getReligionId() != null ) {
            mBeneficiarydetail.setReligionId( BigInteger.valueOf( dto.getReligionId() ) );
        }
        mBeneficiarydetail.setTitle( dto.getTitle() );
        mBeneficiarydetail.setHealthCareWorkerId( dto.getHealthCareWorkerId() );
        mBeneficiarydetail.setEducationId( dto.getEducationId() );
        mBeneficiarydetail.setOccupationId( dto.getOccupationId() );
        mBeneficiarydetail.setPlaceOfWork( dto.getPlaceOfWork() );
        mBeneficiarydetail.setSourceOfInfo( dto.getSourceOfInfo() );
        mBeneficiarydetail.setZoneId( dto.getZoneId() );
        mBeneficiarydetail.setCommunityId( dto.getCommunityId() );
        mBeneficiarydetail.setIncomeStatus( dto.getIncomeStatus() );
        mBeneficiarydetail.setMotherName( dto.getMotherName() );
        mBeneficiarydetail.setGenderId( dto.getGenderId() );
        mBeneficiarydetail.setCommunity( dto.getCommunity() );
        mBeneficiarydetail.setIncomeStatusId( dto.getIncomeStatusId() );
        mBeneficiarydetail.setReligion( dto.getReligion() );
        mBeneficiarydetail.setFirstName( dto.getFirstName() );
        mBeneficiarydetail.setMaritalStatusId( dto.getMaritalStatusId() );
        mBeneficiarydetail.setAreaId( dto.getAreaId() );
        mBeneficiarydetail.setBeneficiaryRegID( dto.getBeneficiaryRegId() );
        mBeneficiarydetail.setCreatedDate( dto.getEventTypeDate() );
        mBeneficiarydetail.setCreatedBy( dto.getAgentName() );
        mBeneficiarydetail.setDob( dto.getDob() );
        mBeneficiarydetail.setMiddleName( dto.getMiddleName() );
        mBeneficiarydetail.setSpouseName( dto.getSpouseName() );
        mBeneficiarydetail.setPhcId( dto.getPhcId() );
        mBeneficiarydetail.setMaritalStatus( dto.getMaritalStatus() );
        mBeneficiarydetail.setRemarks( dto.getRemarks() );
        mBeneficiarydetail.setHealthCareWorker( dto.getHealthCareWorker() );
        mBeneficiarydetail.setStatus( dto.getStatus() );
        mBeneficiarydetail.setLiteracyStatus( dto.getLiteracyStatus() );
        mBeneficiarydetail.setPreferredLanguageId( dto.getPreferredLanguageId() );
        mBeneficiarydetail.setSexualOrientationID( dto.getSexualOrientationID() );
        mBeneficiarydetail.setSexualOrientationType( dto.getSexualOrientationType() );
        mBeneficiarydetail.setVanID( dto.getVanID() );

        mBeneficiarydetail.setAgeAtMarriage( MBeneficiarydetail.getAgeAtMarriageCalc(dto.getDob(), dto.getMarriageDate(), dto.getAgeAtMarriage()) );
        mBeneficiarydetail.setMarriageDate( MBeneficiarydetail.getMarriageDateCalc(dto.getDob(), dto.getMarriageDate(), dto.getAgeAtMarriage()) );
        mBeneficiarydetail.setIsHIVPositive( MBeneficiarydetail.setIsHIVPositive(dto.getIsHIVPositive()) );

        return mBeneficiarydetail;
    }

    @Override
    public MBeneficiaryfamilymapping IdentityEditDTOToMBeneficiaryfamilymapping(BenFamilyDTO benFamilyDTO, String createdBy, Timestamp createdDate) {
        if ( benFamilyDTO == null && createdBy == null && createdDate == null ) {
            return null;
        }

        MBeneficiaryfamilymapping mBeneficiaryfamilymapping = new MBeneficiaryfamilymapping();

        if ( benFamilyDTO != null ) {
            mBeneficiaryfamilymapping.setAssociatedBenRegId( benFamilyDTO.getAssociatedBenRegId() );
            mBeneficiaryfamilymapping.setIsEmergencyContact( benFamilyDTO.getIsEmergencyContact() );
            mBeneficiaryfamilymapping.setRelationshipToSelf( benFamilyDTO.getRelationshipToSelf() );
            mBeneficiaryfamilymapping.setBenFamilyMapId( benFamilyDTO.getBenFamilyMapId() );
            mBeneficiaryfamilymapping.setDeleted( benFamilyDTO.getDeleted() );
            mBeneficiaryfamilymapping.setLastModDate( benFamilyDTO.getLastModDate() );
            mBeneficiaryfamilymapping.setModifiedBy( benFamilyDTO.getModifiedBy() );
            mBeneficiaryfamilymapping.setRelationshipID( benFamilyDTO.getRelationshipID() );
            mBeneficiaryfamilymapping.setVanID( benFamilyDTO.getVanID() );
            mBeneficiaryfamilymapping.setParkingPlaceID( benFamilyDTO.getParkingPlaceID() );
        }
        if ( createdBy != null ) {
            mBeneficiaryfamilymapping.setCreatedBy( createdBy );
        }
        if ( createdDate != null ) {
            mBeneficiaryfamilymapping.setCreatedDate( createdDate );
        }

        return mBeneficiaryfamilymapping;
    }

    @Override
    public List<MBeneficiaryfamilymapping> IdentityEditDTOListToMBeneficiaryfamilymappingList(List<BenFamilyDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<MBeneficiaryfamilymapping> list1 = new ArrayList<MBeneficiaryfamilymapping>( list.size() );
        for ( BenFamilyDTO benFamilyDTO : list ) {
            list1.add( benFamilyDTOToMBeneficiaryfamilymapping( benFamilyDTO ) );
        }

        return list1;
    }

    @Override
    public MBeneficiaryidentity IdentityToMBeneficiaryidentity(Identity identity, String createdBy, Timestamp createdDate) {
        if ( identity == null && createdBy == null && createdDate == null ) {
            return null;
        }

        MBeneficiaryidentity mBeneficiaryidentity = new MBeneficiaryidentity();

        if ( identity != null ) {
            mBeneficiaryidentity.setIdentityNo( identity.getIdentityNo() );
            mBeneficiaryidentity.setExpiryDate( identity.getExpiryDate() );
            mBeneficiaryidentity.setIdentityName( identity.getIdentityName() );
            mBeneficiaryidentity.setIdentityType( identity.getIdentityType() );
            mBeneficiaryidentity.setIsVerified( identity.getIsVerified() );
            mBeneficiaryidentity.setIssueDate( identity.getIssueDate() );
            mBeneficiaryidentity.setIdentityFilePath( identity.getIdentityFilePath() );
            mBeneficiaryidentity.setBenIdentityId( identity.getBenIdentityId() );
            mBeneficiaryidentity.setDeleted( identity.getDeleted() );
            mBeneficiaryidentity.setIdentityNameId( identity.getIdentityNameId() );
            mBeneficiaryidentity.setIdentityTypeId( identity.getIdentityTypeId() );
        }
        if ( createdBy != null ) {
            mBeneficiaryidentity.setCreatedBy( createdBy );
        }
        if ( createdDate != null ) {
            mBeneficiaryidentity.setCreatedDate( createdDate );
        }

        return mBeneficiaryidentity;
    }

    @Override
    public List<MBeneficiaryidentity> IdentityEditDTOListToMBeneficiaryidentityList(List<Identity> list) {
        if ( list == null ) {
            return null;
        }

        List<MBeneficiaryidentity> list1 = new ArrayList<MBeneficiaryidentity>( list.size() );
        for ( Identity identity : list ) {
            list1.add( identityToMBeneficiaryidentity( identity ) );
        }

        return list1;
    }

    @Override
    public MBeneficiaryservicemapping IdentityEditDTOToMBeneficiaryservicemapping(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiaryservicemapping mBeneficiaryservicemapping = new MBeneficiaryservicemapping();

        mBeneficiaryservicemapping.setServiceProviderId( dto.getServiceProviderId() );
        mBeneficiaryservicemapping.setRegisteredDate( dto.getEventTypeDate() );
        mBeneficiaryservicemapping.setStateId( dto.getStateId() );
        mBeneficiaryservicemapping.setRegisteredById( dto.getAgentId() );
        mBeneficiaryservicemapping.setProviderServiceMapId( dto.getProviderServiceMapId() );
        mBeneficiaryservicemapping.setServiceName( dto.getServiceName() );
        mBeneficiaryservicemapping.setServiceProviderName( dto.getServiceProviderName() );
        mBeneficiaryservicemapping.setRegisteredByName( dto.getAgentName() );
        mBeneficiaryservicemapping.setCreatedDate( dto.getEventTypeDate() );
        mBeneficiaryservicemapping.setStateName( dto.getStateName() );
        mBeneficiaryservicemapping.setCreatedBy( dto.getAgentName() );
        mBeneficiaryservicemapping.setServiceId( dto.getServiceId() );
        mBeneficiaryservicemapping.setVanID( dto.getVanID() );

        return mBeneficiaryservicemapping;
    }

    @Override
    public BenDetailDTO MBeneficiarydetailToBenDetailDTO(MBeneficiarydetail detail) {
        if ( detail == null ) {
            return null;
        }

        BenDetailDTO benDetailDTO = new BenDetailDTO();

        benDetailDTO.setFatherName( detail.getFatherName() );
        benDetailDTO.setLastName( detail.getLastName() );
        benDetailDTO.setPreferredLanguage( detail.getPreferredLanguage() );
        benDetailDTO.setEducation( detail.getEducation() );
        benDetailDTO.setOccupation( detail.getOccupation() );
        benDetailDTO.setGender( detail.getGender() );
        benDetailDTO.setServicePointId( detail.getServicePointId() );
        if ( detail.getReligionId() != null ) {
            benDetailDTO.setReligionId( detail.getReligionId().intValue() );
        }
        benDetailDTO.setTitle( detail.getTitle() );
        benDetailDTO.setPlaceOfWork( detail.getPlaceOfWork() );
        benDetailDTO.setSourceOfInfo( detail.getSourceOfInfo() );
        benDetailDTO.setZoneId( detail.getZoneId() );
        benDetailDTO.setModifiedBy( detail.getModifiedBy() );
        benDetailDTO.setIncomeStatus( detail.getIncomeStatus() );
        benDetailDTO.setMotherName( detail.getMotherName() );
        benDetailDTO.setCommunity( detail.getCommunity() );
        benDetailDTO.setBeneficiaryDetailsId( detail.getBeneficiaryDetailsId() );
        benDetailDTO.setReligion( detail.getReligion() );
        benDetailDTO.setFirstName( detail.getFirstName() );
        benDetailDTO.setAreaId( detail.getAreaId() );
        benDetailDTO.setBeneficiaryRegID( detail.getBeneficiaryRegID() );
        benDetailDTO.setCreatedDate( detail.getCreatedDate() );
        benDetailDTO.setDeleted( detail.getDeleted() );
        benDetailDTO.setCreatedBy( detail.getCreatedBy() );
        benDetailDTO.setEmergencyRegistration( detail.getEmergencyRegistration() );
        benDetailDTO.setDob( detail.getDob() );
        benDetailDTO.setLastModDate( detail.getLastModDate() );
        benDetailDTO.setMiddleName( detail.getMiddleName() );
        benDetailDTO.setSpouseName( detail.getSpouseName() );
        benDetailDTO.setPhcId( detail.getPhcId() );
        benDetailDTO.setMaritalStatus( detail.getMaritalStatus() );
        benDetailDTO.setRemarks( detail.getRemarks() );
        benDetailDTO.setPreferredLanguageId( detail.getPreferredLanguageId() );
        benDetailDTO.setStatus( detail.getStatus() );
        benDetailDTO.setHealthCareWorkerId( detail.getHealthCareWorkerId() );
        benDetailDTO.setHealthCareWorker( detail.getHealthCareWorker() );
        benDetailDTO.setIncomeStatusId( detail.getIncomeStatusId() );
        benDetailDTO.setOccupationId( detail.getOccupationId() );
        benDetailDTO.setGenderId( detail.getGenderId() );
        benDetailDTO.setMaritalStatusId( detail.getMaritalStatusId() );
        benDetailDTO.setTitleId( detail.getTitleId() );
        benDetailDTO.setCommunityId( detail.getCommunityId() );
        benDetailDTO.setEducationId( detail.getEducationId() );
        if ( detail.getIsHIVPositive() != null ) {
            benDetailDTO.setIsHIVPositive( String.valueOf( detail.getIsHIVPositive() ) );
        }
        benDetailDTO.setSexualOrientationID( detail.getSexualOrientationID() );
        benDetailDTO.setSexualOrientationType( detail.getSexualOrientationType() );
        benDetailDTO.setVanID( detail.getVanID() );
        benDetailDTO.setParkingPlaceID( detail.getParkingPlaceID() );
        benDetailDTO.setHeadOfFamily_RelationID( detail.getHeadOfFamily_RelationID() );
        benDetailDTO.setFamilyId( detail.getFamilyId() );
        benDetailDTO.setOther( detail.getOther() );
        benDetailDTO.setHeadOfFamily_Relation( detail.getHeadOfFamily_Relation() );

        return benDetailDTO;
    }

    @Override
    public BenFamilyDTO MBeneficiaryfamilymappingToBenFamilyDTO(MBeneficiaryfamilymapping family) {
        if ( family == null ) {
            return null;
        }

        BenFamilyDTO benFamilyDTO = new BenFamilyDTO();

        benFamilyDTO.setCreatedDate( family.getCreatedDate() );
        benFamilyDTO.setDeleted( family.getDeleted() );
        benFamilyDTO.setRelationshipToSelf( family.getRelationshipToSelf() );
        benFamilyDTO.setCreatedBy( family.getCreatedBy() );
        benFamilyDTO.setBenFamilyMapId( family.getBenFamilyMapId() );
        benFamilyDTO.setAssociatedBenRegId( family.getAssociatedBenRegId() );
        benFamilyDTO.setLastModDate( family.getLastModDate() );
        benFamilyDTO.setModifiedBy( family.getModifiedBy() );
        benFamilyDTO.setIsEmergencyContact( family.getIsEmergencyContact() );
        benFamilyDTO.setRelationshipID( family.getRelationshipID() );
        benFamilyDTO.setVanID( family.getVanID() );
        benFamilyDTO.setParkingPlaceID( family.getParkingPlaceID() );

        return benFamilyDTO;
    }

    @Override
    public List<BenFamilyDTO> mBeneficiaryfamilymappingListToBenFamilyDTOList(List<MBeneficiaryfamilymapping> families) {
        if ( families == null ) {
            return null;
        }

        List<BenFamilyDTO> list = new ArrayList<BenFamilyDTO>( families.size() );
        for ( MBeneficiaryfamilymapping mBeneficiaryfamilymapping : families ) {
            list.add( MBeneficiaryfamilymappingToBenFamilyDTO( mBeneficiaryfamilymapping ) );
        }

        return list;
    }

    @Override
    public BenFamilyDTO mapToBenFamilyDTO(BenFamilyDTO benFamilyDTO) {
        if ( benFamilyDTO == null ) {
            return null;
        }

        BenFamilyDTO benFamilyDTO1 = new BenFamilyDTO();

        benFamilyDTO1.setBenFamilyMapId( benFamilyDTO.getBenFamilyMapId() );
        benFamilyDTO1.setAssociatedBenRegId( benFamilyDTO.getAssociatedBenRegId() );
        benFamilyDTO1.setCreatedBy( benFamilyDTO.getCreatedBy() );
        benFamilyDTO1.setCreatedDate( benFamilyDTO.getCreatedDate() );
        benFamilyDTO1.setDeleted( benFamilyDTO.getDeleted() );
        benFamilyDTO1.setIsEmergencyContact( benFamilyDTO.getIsEmergencyContact() );
        benFamilyDTO1.setLastModDate( benFamilyDTO.getLastModDate() );
        benFamilyDTO1.setModifiedBy( benFamilyDTO.getModifiedBy() );
        benFamilyDTO1.setRelationshipToSelf( benFamilyDTO.getRelationshipToSelf() );
        benFamilyDTO1.setRelationshipID( benFamilyDTO.getRelationshipID() );
        benFamilyDTO1.setVanID( benFamilyDTO.getVanID() );
        benFamilyDTO1.setParkingPlaceID( benFamilyDTO.getParkingPlaceID() );

        return benFamilyDTO1;
    }

    @Override
    public MBeneficiaryfamilymapping mapToMBeneficiaryfamilymapping(MBeneficiaryfamilymapping beneficiaryfamilymapping) {
        if ( beneficiaryfamilymapping == null ) {
            return null;
        }

        MBeneficiaryfamilymapping mBeneficiaryfamilymapping = new MBeneficiaryfamilymapping();

        mBeneficiaryfamilymapping.setBenFamilyMapId( beneficiaryfamilymapping.getBenFamilyMapId() );
        mBeneficiaryfamilymapping.setAssociatedBenRegId( beneficiaryfamilymapping.getAssociatedBenRegId() );
        mBeneficiaryfamilymapping.setCreatedBy( beneficiaryfamilymapping.getCreatedBy() );
        mBeneficiaryfamilymapping.setCreatedDate( beneficiaryfamilymapping.getCreatedDate() );
        mBeneficiaryfamilymapping.setDeleted( beneficiaryfamilymapping.getDeleted() );
        mBeneficiaryfamilymapping.setIsEmergencyContact( beneficiaryfamilymapping.getIsEmergencyContact() );
        mBeneficiaryfamilymapping.setLastModDate( beneficiaryfamilymapping.getLastModDate() );
        mBeneficiaryfamilymapping.setModifiedBy( beneficiaryfamilymapping.getModifiedBy() );
        mBeneficiaryfamilymapping.setProcessed( beneficiaryfamilymapping.getProcessed() );
        mBeneficiaryfamilymapping.setRelationshipToSelf( beneficiaryfamilymapping.getRelationshipToSelf() );
        mBeneficiaryfamilymapping.setRelationshipID( beneficiaryfamilymapping.getRelationshipID() );
        mBeneficiaryfamilymapping.setReserved( beneficiaryfamilymapping.getReserved() );
        mBeneficiaryfamilymapping.setReservedById( beneficiaryfamilymapping.getReservedById() );
        mBeneficiaryfamilymapping.setReservedFor( beneficiaryfamilymapping.getReservedFor() );
        mBeneficiaryfamilymapping.setReservedOn( beneficiaryfamilymapping.getReservedOn() );
        mBeneficiaryfamilymapping.setBenMapId( beneficiaryfamilymapping.getBenMapId() );
        mBeneficiaryfamilymapping.setVanID( beneficiaryfamilymapping.getVanID() );
        mBeneficiaryfamilymapping.setParkingPlaceID( beneficiaryfamilymapping.getParkingPlaceID() );
        mBeneficiaryfamilymapping.setVanSerialNo( beneficiaryfamilymapping.getVanSerialNo() );

        return mBeneficiaryfamilymapping;
    }

    @Override
    public List<MBeneficiaryfamilymapping> mapToMBeneficiaryfamilymappingList(Collection<MBeneficiaryfamilymapping> beneficiaryfamilymappings) {
        if ( beneficiaryfamilymappings == null ) {
            return null;
        }

        List<MBeneficiaryfamilymapping> list = new ArrayList<MBeneficiaryfamilymapping>( beneficiaryfamilymappings.size() );
        for ( MBeneficiaryfamilymapping mBeneficiaryfamilymapping : beneficiaryfamilymappings ) {
            list.add( mapToMBeneficiaryfamilymapping( mBeneficiaryfamilymapping ) );
        }

        return list;
    }

    @Override
    public List<BenFamilyDTO> mapToMBeneficiaryfamilymappingWithBenFamilyDTOList(List<MBeneficiaryfamilymapping> beneficiaryfamilymappings) {
        if ( beneficiaryfamilymappings == null ) {
            return null;
        }

        List<BenFamilyDTO> list = new ArrayList<BenFamilyDTO>( beneficiaryfamilymappings.size() );
        for ( MBeneficiaryfamilymapping mBeneficiaryfamilymapping : beneficiaryfamilymappings ) {
            list.add( MBeneficiaryfamilymappingToBenFamilyDTO( mBeneficiaryfamilymapping ) );
        }

        return list;
    }

    @Override
    public BenIdentityDTO mBeneficiaryidentityToBenIdentityEditDTO(MBeneficiaryidentity identity) {
        if ( identity == null ) {
            return null;
        }

        BenIdentityDTO benIdentityDTO = new BenIdentityDTO();

        benIdentityDTO.setBenIdentityId( identity.getBenIdentityId() );
        benIdentityDTO.setIdentityName( identity.getIdentityName() );
        benIdentityDTO.setIsVerified( identity.getIsVerified() );
        benIdentityDTO.setExpiryDate( identity.getExpiryDate() );
        benIdentityDTO.setIdentityNo( identity.getIdentityNo() );
        benIdentityDTO.setCreatedDate( identity.getCreatedDate() );
        benIdentityDTO.setDeleted( identity.getDeleted() );
        benIdentityDTO.setCreatedBy( identity.getCreatedBy() );
        benIdentityDTO.setIdentityType( identity.getIdentityType() );
        benIdentityDTO.setLastModDate( identity.getLastModDate() );
        benIdentityDTO.setModifiedBy( identity.getModifiedBy() );
        benIdentityDTO.setIdentityFilePath( identity.getIdentityFilePath() );
        benIdentityDTO.setIssueDate( identity.getIssueDate() );
        benIdentityDTO.setIdentityNameId( identity.getIdentityNameId() );
        benIdentityDTO.setIdentityTypeId( identity.getIdentityTypeId() );
        benIdentityDTO.setVanID( identity.getVanID() );
        benIdentityDTO.setParkingPlaceID( identity.getParkingPlaceID() );

        return benIdentityDTO;
    }

    @Override
    public List<BenIdentityDTO> mBeneficiaryidentityListToBenIdentityEditDTOList(List<MBeneficiaryidentity> identity) {
        if ( identity == null ) {
            return null;
        }

        List<BenIdentityDTO> list = new ArrayList<BenIdentityDTO>( identity.size() );
        for ( MBeneficiaryidentity mBeneficiaryidentity : identity ) {
            list.add( mBeneficiaryidentityToBenIdentityEditDTO( mBeneficiaryidentity ) );
        }

        return list;
    }

    @Override
    public BenServiceDTO mBeneficiaryservicemappingToBenServiceDTO(MBeneficiaryservicemapping service) {
        if ( service == null ) {
            return null;
        }

        BenServiceDTO benServiceDTO = new BenServiceDTO();

        benServiceDTO.setServiceProviderId( service.getServiceProviderId() );
        benServiceDTO.setRegisteredDate( service.getRegisteredDate() );
        benServiceDTO.setRegisteredById( service.getRegisteredById() );
        benServiceDTO.setStateId( service.getStateId() );
        benServiceDTO.setBenServiceMapID( service.getBenServiceMapID() );
        benServiceDTO.setProviderServiceMapId( service.getProviderServiceMapId() );
        benServiceDTO.setServiceName( service.getServiceName() );
        benServiceDTO.setFirstAvailedOn( service.getFirstAvailedOn() );
        benServiceDTO.setServiceProviderName( service.getServiceProviderName() );
        benServiceDTO.setRegisteredByName( service.getRegisteredByName() );
        benServiceDTO.setCreatedDate( service.getCreatedDate() );
        benServiceDTO.setCreatedBy( service.getCreatedBy() );
        benServiceDTO.setStateName( service.getStateName() );
        benServiceDTO.setLastModDate( service.getLastModDate() );
        benServiceDTO.setModifiedBy( service.getModifiedBy() );
        benServiceDTO.setServiceId( service.getServiceId() );
        benServiceDTO.setVanID( service.getVanID() );
        benServiceDTO.setParkingPlaceID( service.getParkingPlaceID() );

        return benServiceDTO;
    }

    @Override
    public List<BenServiceDTO> mBeneficiaryservicemappingListToBenServiceDTOList(List<MBeneficiaryservicemapping> services) {
        if ( services == null ) {
            return null;
        }

        List<BenServiceDTO> list = new ArrayList<BenServiceDTO>( services.size() );
        for ( MBeneficiaryservicemapping mBeneficiaryservicemapping : services ) {
            list.add( mBeneficiaryservicemappingToBenServiceDTO( mBeneficiaryservicemapping ) );
        }

        return list;
    }

    @Override
    public MBeneficiaryAccount identityEditDTOToMBeneficiaryAccount(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiaryAccount mBeneficiaryAccount = new MBeneficiaryAccount();

        mBeneficiaryAccount.setCreatedDate( dto.getEventTypeDate() );
        mBeneficiaryAccount.setCreatedBy( dto.getAgentName() );
        mBeneficiaryAccount.setAccountNo( dto.getAccountNo() );
        mBeneficiaryAccount.setBranchName( dto.getBranchName() );
        mBeneficiaryAccount.setBankName( dto.getBankName() );
        mBeneficiaryAccount.setBenAccountID( dto.getBenAccountID() );
        mBeneficiaryAccount.setIfscCode( dto.getIfscCode() );
        mBeneficiaryAccount.setVanID( dto.getVanID() );

        return mBeneficiaryAccount;
    }

    @Override
    public List<MBeneficiaryAccount> identityEditDTOToMBeneficiaryAccount(List<IdentityEditDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<MBeneficiaryAccount> list = new ArrayList<MBeneficiaryAccount>( dto.size() );
        for ( IdentityEditDTO identityEditDTO : dto ) {
            list.add( identityEditDTOToMBeneficiaryAccount( identityEditDTO ) );
        }

        return list;
    }

    @Override
    public MBeneficiaryImage identityEditDTOToMBeneficiaryImage(IdentityEditDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiaryImage mBeneficiaryImage = new MBeneficiaryImage();

        mBeneficiaryImage.setCreatedDate( dto.getEventTypeDate() );
        mBeneficiaryImage.setBenImage( dto.getBenImage() );
        mBeneficiaryImage.setCreatedBy( dto.getAgentName() );
        mBeneficiaryImage.setBenImageId( dto.getBenImageId() );
        mBeneficiaryImage.setVanID( dto.getVanID() );

        return mBeneficiaryImage;
    }

    @Override
    public List<MBeneficiaryImage> identityEditDTOToMBeneficiaryImage(List<IdentityEditDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<MBeneficiaryImage> list = new ArrayList<MBeneficiaryImage>( dto.size() );
        for ( IdentityEditDTO identityEditDTO : dto ) {
            list.add( identityEditDTOToMBeneficiaryImage( identityEditDTO ) );
        }

        return list;
    }

    private Integer dtoCurrentAddressParkingPlaceID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer parkingPlaceID = currentAddress.getParkingPlaceID();
        if ( parkingPlaceID == null ) {
            return null;
        }
        return parkingPlaceID;
    }

    private Integer dtoEmergencyAddressVillageId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer villageId = emergencyAddress.getVillageId();
        if ( villageId == null ) {
            return null;
        }
        return villageId;
    }

    private String dtoCurrentAddressHabitation(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String habitation = currentAddress.getHabitation();
        if ( habitation == null ) {
            return null;
        }
        return habitation;
    }

    private Integer dtoEmergencyAddressServicePointID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer servicePointID = emergencyAddress.getServicePointID();
        if ( servicePointID == null ) {
            return null;
        }
        return servicePointID;
    }

    private String dtoEmergencyAddressAddressValue(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String addressValue = emergencyAddress.getAddressValue();
        if ( addressValue == null ) {
            return null;
        }
        return addressValue;
    }

    private Integer dtoPermanentAddressVillageId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer villageId = permanentAddress.getVillageId();
        if ( villageId == null ) {
            return null;
        }
        return villageId;
    }

    private Integer dtoPermanentAddressZoneID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer zoneID = permanentAddress.getZoneID();
        if ( zoneID == null ) {
            return null;
        }
        return zoneID;
    }

    private String dtoEmergencyAddressAddrLine1(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String addrLine1 = emergencyAddress.getAddrLine1();
        if ( addrLine1 == null ) {
            return null;
        }
        return addrLine1;
    }

    private String dtoEmergencyAddressAddrLine3(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String addrLine3 = emergencyAddress.getAddrLine3();
        if ( addrLine3 == null ) {
            return null;
        }
        return addrLine3;
    }

    private String dtoEmergencyAddressAddrLine2(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String addrLine2 = emergencyAddress.getAddrLine2();
        if ( addrLine2 == null ) {
            return null;
        }
        return addrLine2;
    }

    private String dtoEmergencyAddressZoneName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String zoneName = emergencyAddress.getZoneName();
        if ( zoneName == null ) {
            return null;
        }
        return zoneName;
    }

    private String dtoPermanentAddressAddrLine3(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String addrLine3 = permanentAddress.getAddrLine3();
        if ( addrLine3 == null ) {
            return null;
        }
        return addrLine3;
    }

    private String dtoPermanentAddressAddrLine2(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String addrLine2 = permanentAddress.getAddrLine2();
        if ( addrLine2 == null ) {
            return null;
        }
        return addrLine2;
    }

    private Integer dtoCurrentAddressSubDistrictId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer subDistrictId = currentAddress.getSubDistrictId();
        if ( subDistrictId == null ) {
            return null;
        }
        return subDistrictId;
    }

    private String dtoPermanentAddressAddrLine1(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String addrLine1 = permanentAddress.getAddrLine1();
        if ( addrLine1 == null ) {
            return null;
        }
        return addrLine1;
    }

    private String dtoEmergencyAddressSubDistrict(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String subDistrict = emergencyAddress.getSubDistrict();
        if ( subDistrict == null ) {
            return null;
        }
        return subDistrict;
    }

    private String dtoEmergencyAddressCountry(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String country = emergencyAddress.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    private String dtoPermanentAddressState(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String state = permanentAddress.getState();
        if ( state == null ) {
            return null;
        }
        return state;
    }

    private String dtoCurrentAddressCountry(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String country = currentAddress.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    private String dtoCurrentAddressServicePointName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String servicePointName = currentAddress.getServicePointName();
        if ( servicePointName == null ) {
            return null;
        }
        return servicePointName;
    }

    private String dtoPermanentAddressVillage(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String village = permanentAddress.getVillage();
        if ( village == null ) {
            return null;
        }
        return village;
    }

    private Integer dtoPermanentAddressDistrictId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer districtId = permanentAddress.getDistrictId();
        if ( districtId == null ) {
            return null;
        }
        return districtId;
    }

    private String dtoPermanentAddressAddressValue(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String addressValue = permanentAddress.getAddressValue();
        if ( addressValue == null ) {
            return null;
        }
        return addressValue;
    }

    private String dtoCurrentAddressDistrict(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String district = currentAddress.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private String dtoPermanentAddressParkingPlaceName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String parkingPlaceName = permanentAddress.getParkingPlaceName();
        if ( parkingPlaceName == null ) {
            return null;
        }
        return parkingPlaceName;
    }

    private String dtoCurrentAddressPinCode(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String pinCode = currentAddress.getPinCode();
        if ( pinCode == null ) {
            return null;
        }
        return pinCode;
    }

    private Integer dtoEmergencyAddressStateId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer stateId = emergencyAddress.getStateId();
        if ( stateId == null ) {
            return null;
        }
        return stateId;
    }

    private String dtoEmergencyAddressPinCode(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String pinCode = emergencyAddress.getPinCode();
        if ( pinCode == null ) {
            return null;
        }
        return pinCode;
    }

    private Integer dtoCurrentAddressStateId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer stateId = currentAddress.getStateId();
        if ( stateId == null ) {
            return null;
        }
        return stateId;
    }

    private String dtoEmergencyAddressParkingPlaceName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String parkingPlaceName = emergencyAddress.getParkingPlaceName();
        if ( parkingPlaceName == null ) {
            return null;
        }
        return parkingPlaceName;
    }

    private Integer dtoEmergencyAddressZoneID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer zoneID = emergencyAddress.getZoneID();
        if ( zoneID == null ) {
            return null;
        }
        return zoneID;
    }

    private String dtoPermanentAddressSubDistrict(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String subDistrict = permanentAddress.getSubDistrict();
        if ( subDistrict == null ) {
            return null;
        }
        return subDistrict;
    }

    private String dtoCurrentAddressAddrLine3(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String addrLine3 = currentAddress.getAddrLine3();
        if ( addrLine3 == null ) {
            return null;
        }
        return addrLine3;
    }

    private Integer dtoEmergencyAddressCountryId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer countryId = emergencyAddress.getCountryId();
        if ( countryId == null ) {
            return null;
        }
        return countryId;
    }

    private String dtoCurrentAddressAddrLine2(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String addrLine2 = currentAddress.getAddrLine2();
        if ( addrLine2 == null ) {
            return null;
        }
        return addrLine2;
    }

    private String dtoCurrentAddressAddrLine1(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String addrLine1 = currentAddress.getAddrLine1();
        if ( addrLine1 == null ) {
            return null;
        }
        return addrLine1;
    }

    private String dtoPermanentAddressZoneName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String zoneName = permanentAddress.getZoneName();
        if ( zoneName == null ) {
            return null;
        }
        return zoneName;
    }

    private String dtoPermanentAddressServicePointName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String servicePointName = permanentAddress.getServicePointName();
        if ( servicePointName == null ) {
            return null;
        }
        return servicePointName;
    }

    private Integer dtoCurrentAddressServicePointID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer servicePointID = currentAddress.getServicePointID();
        if ( servicePointID == null ) {
            return null;
        }
        return servicePointID;
    }

    private String dtoPermanentAddressCountry(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String country = permanentAddress.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    private String dtoCurrentAddressZoneName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String zoneName = currentAddress.getZoneName();
        if ( zoneName == null ) {
            return null;
        }
        return zoneName;
    }

    private String dtoEmergencyAddressState(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String state = emergencyAddress.getState();
        if ( state == null ) {
            return null;
        }
        return state;
    }

    private Integer dtoEmergencyAddressDistrictId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer districtId = emergencyAddress.getDistrictId();
        if ( districtId == null ) {
            return null;
        }
        return districtId;
    }

    private String dtoPermanentAddressPinCode(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String pinCode = permanentAddress.getPinCode();
        if ( pinCode == null ) {
            return null;
        }
        return pinCode;
    }

    private Integer dtoCurrentAddressDistrictId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer districtId = currentAddress.getDistrictId();
        if ( districtId == null ) {
            return null;
        }
        return districtId;
    }

    private String dtoPermanentAddressDistrict(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String district = permanentAddress.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private Integer dtoCurrentAddressZoneID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer zoneID = currentAddress.getZoneID();
        if ( zoneID == null ) {
            return null;
        }
        return zoneID;
    }

    private Integer dtoCurrentAddressCountryId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer countryId = currentAddress.getCountryId();
        if ( countryId == null ) {
            return null;
        }
        return countryId;
    }

    private String dtoCurrentAddressState(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String state = currentAddress.getState();
        if ( state == null ) {
            return null;
        }
        return state;
    }

    private Integer dtoPermanentAddressCountryId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer countryId = permanentAddress.getCountryId();
        if ( countryId == null ) {
            return null;
        }
        return countryId;
    }

    private Integer dtoPermanentAddressParkingPlaceID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer parkingPlaceID = permanentAddress.getParkingPlaceID();
        if ( parkingPlaceID == null ) {
            return null;
        }
        return parkingPlaceID;
    }

    private String dtoEmergencyAddressHabitation(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String habitation = emergencyAddress.getHabitation();
        if ( habitation == null ) {
            return null;
        }
        return habitation;
    }

    private Integer dtoPermanentAddressSubDistrictId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer subDistrictId = permanentAddress.getSubDistrictId();
        if ( subDistrictId == null ) {
            return null;
        }
        return subDistrictId;
    }

    private Integer dtoCurrentAddressVillageId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer villageId = currentAddress.getVillageId();
        if ( villageId == null ) {
            return null;
        }
        return villageId;
    }

    private String dtoCurrentAddressParkingPlaceName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String parkingPlaceName = currentAddress.getParkingPlaceName();
        if ( parkingPlaceName == null ) {
            return null;
        }
        return parkingPlaceName;
    }

    private Integer dtoEmergencyAddressParkingPlaceID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer parkingPlaceID = emergencyAddress.getParkingPlaceID();
        if ( parkingPlaceID == null ) {
            return null;
        }
        return parkingPlaceID;
    }

    private Integer dtoEmergencyAddressSubDistrictId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        Integer subDistrictId = emergencyAddress.getSubDistrictId();
        if ( subDistrictId == null ) {
            return null;
        }
        return subDistrictId;
    }

    private String dtoEmergencyAddressServicePointName(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String servicePointName = emergencyAddress.getServicePointName();
        if ( servicePointName == null ) {
            return null;
        }
        return servicePointName;
    }

    private String dtoCurrentAddressVillage(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String village = currentAddress.getVillage();
        if ( village == null ) {
            return null;
        }
        return village;
    }

    private String dtoCurrentAddressSubDistrict(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String subDistrict = currentAddress.getSubDistrict();
        if ( subDistrict == null ) {
            return null;
        }
        return subDistrict;
    }

    private String dtoEmergencyAddressVillage(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String village = emergencyAddress.getVillage();
        if ( village == null ) {
            return null;
        }
        return village;
    }

    private Integer dtoPermanentAddressStateId(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer stateId = permanentAddress.getStateId();
        if ( stateId == null ) {
            return null;
        }
        return stateId;
    }

    private Integer dtoPermanentAddressServicePointID(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        Integer servicePointID = permanentAddress.getServicePointID();
        if ( servicePointID == null ) {
            return null;
        }
        return servicePointID;
    }

    private String dtoPermanentAddressHabitation(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address permanentAddress = identityEditDTO.getPermanentAddress();
        if ( permanentAddress == null ) {
            return null;
        }
        String habitation = permanentAddress.getHabitation();
        if ( habitation == null ) {
            return null;
        }
        return habitation;
    }

    private String dtoCurrentAddressAddressValue(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address currentAddress = identityEditDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String addressValue = currentAddress.getAddressValue();
        if ( addressValue == null ) {
            return null;
        }
        return addressValue;
    }

    private String dtoEmergencyAddressDistrict(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Address emergencyAddress = identityEditDTO.getEmergencyAddress();
        if ( emergencyAddress == null ) {
            return null;
        }
        String district = emergencyAddress.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private String dtoContactEmergencyContactNum(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String emergencyContactNum = contact.getEmergencyContactNum();
        if ( emergencyContactNum == null ) {
            return null;
        }
        return emergencyContactNum;
    }

    private String dtoContactPreferredPhoneTyp(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String preferredPhoneTyp = contact.getPreferredPhoneTyp();
        if ( preferredPhoneTyp == null ) {
            return null;
        }
        return preferredPhoneTyp;
    }

    private String dtoContactPreferredPhoneNum(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String preferredPhoneNum = contact.getPreferredPhoneNum();
        if ( preferredPhoneNum == null ) {
            return null;
        }
        return preferredPhoneNum;
    }

    private String dtoContactPreferredSMSPhoneNum(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String preferredSMSPhoneNum = contact.getPreferredSMSPhoneNum();
        if ( preferredSMSPhoneNum == null ) {
            return null;
        }
        return preferredSMSPhoneNum;
    }

    private String dtoContactPhoneNum1(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneNum1 = contact.getPhoneNum1();
        if ( phoneNum1 == null ) {
            return null;
        }
        return phoneNum1;
    }

    private String dtoContactPhoneNum2(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneNum2 = contact.getPhoneNum2();
        if ( phoneNum2 == null ) {
            return null;
        }
        return phoneNum2;
    }

    private String dtoContactPhoneTyp5(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneTyp5 = contact.getPhoneTyp5();
        if ( phoneTyp5 == null ) {
            return null;
        }
        return phoneTyp5;
    }

    private String dtoContactPhoneNum3(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneNum3 = contact.getPhoneNum3();
        if ( phoneNum3 == null ) {
            return null;
        }
        return phoneNum3;
    }

    private String dtoContactPhoneNum4(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneNum4 = contact.getPhoneNum4();
        if ( phoneNum4 == null ) {
            return null;
        }
        return phoneNum4;
    }

    private String dtoContactPreferredSMSPhoneTyp(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String preferredSMSPhoneTyp = contact.getPreferredSMSPhoneTyp();
        if ( preferredSMSPhoneTyp == null ) {
            return null;
        }
        return preferredSMSPhoneTyp;
    }

    private String dtoContactPhoneNum5(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneNum5 = contact.getPhoneNum5();
        if ( phoneNum5 == null ) {
            return null;
        }
        return phoneNum5;
    }

    private String dtoContactPhoneTyp3(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneTyp3 = contact.getPhoneTyp3();
        if ( phoneTyp3 == null ) {
            return null;
        }
        return phoneTyp3;
    }

    private String dtoContactPhoneTyp4(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneTyp4 = contact.getPhoneTyp4();
        if ( phoneTyp4 == null ) {
            return null;
        }
        return phoneTyp4;
    }

    private String dtoContactPhoneTyp1(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneTyp1 = contact.getPhoneTyp1();
        if ( phoneTyp1 == null ) {
            return null;
        }
        return phoneTyp1;
    }

    private String dtoContactPhoneTyp2(IdentityEditDTO identityEditDTO) {
        if ( identityEditDTO == null ) {
            return null;
        }
        Contact contact = identityEditDTO.getContact();
        if ( contact == null ) {
            return null;
        }
        String phoneTyp2 = contact.getPhoneTyp2();
        if ( phoneTyp2 == null ) {
            return null;
        }
        return phoneTyp2;
    }

    protected MBeneficiaryfamilymapping benFamilyDTOToMBeneficiaryfamilymapping(BenFamilyDTO benFamilyDTO) {
        if ( benFamilyDTO == null ) {
            return null;
        }

        MBeneficiaryfamilymapping mBeneficiaryfamilymapping = new MBeneficiaryfamilymapping();

        mBeneficiaryfamilymapping.setBenFamilyMapId( benFamilyDTO.getBenFamilyMapId() );
        mBeneficiaryfamilymapping.setAssociatedBenRegId( benFamilyDTO.getAssociatedBenRegId() );
        mBeneficiaryfamilymapping.setCreatedBy( benFamilyDTO.getCreatedBy() );
        mBeneficiaryfamilymapping.setCreatedDate( benFamilyDTO.getCreatedDate() );
        mBeneficiaryfamilymapping.setDeleted( benFamilyDTO.getDeleted() );
        mBeneficiaryfamilymapping.setIsEmergencyContact( benFamilyDTO.getIsEmergencyContact() );
        mBeneficiaryfamilymapping.setLastModDate( benFamilyDTO.getLastModDate() );
        mBeneficiaryfamilymapping.setModifiedBy( benFamilyDTO.getModifiedBy() );
        mBeneficiaryfamilymapping.setRelationshipToSelf( benFamilyDTO.getRelationshipToSelf() );
        mBeneficiaryfamilymapping.setRelationshipID( benFamilyDTO.getRelationshipID() );
        mBeneficiaryfamilymapping.setVanID( benFamilyDTO.getVanID() );
        mBeneficiaryfamilymapping.setParkingPlaceID( benFamilyDTO.getParkingPlaceID() );

        return mBeneficiaryfamilymapping;
    }

    protected MBeneficiaryidentity identityToMBeneficiaryidentity(Identity identity) {
        if ( identity == null ) {
            return null;
        }

        MBeneficiaryidentity mBeneficiaryidentity = new MBeneficiaryidentity();

        mBeneficiaryidentity.setBenIdentityId( identity.getBenIdentityId() );
        mBeneficiaryidentity.setCreatedBy( identity.getCreatedBy() );
        mBeneficiaryidentity.setDeleted( identity.getDeleted() );
        mBeneficiaryidentity.setExpiryDate( identity.getExpiryDate() );
        mBeneficiaryidentity.setIdentityFilePath( identity.getIdentityFilePath() );
        mBeneficiaryidentity.setIdentityNameId( identity.getIdentityNameId() );
        mBeneficiaryidentity.setIdentityName( identity.getIdentityName() );
        mBeneficiaryidentity.setIdentityNo( identity.getIdentityNo() );
        mBeneficiaryidentity.setIdentityTypeId( identity.getIdentityTypeId() );
        mBeneficiaryidentity.setIdentityType( identity.getIdentityType() );
        mBeneficiaryidentity.setIssueDate( identity.getIssueDate() );
        mBeneficiaryidentity.setIsVerified( identity.getIsVerified() );

        return mBeneficiaryidentity;
    }
}
