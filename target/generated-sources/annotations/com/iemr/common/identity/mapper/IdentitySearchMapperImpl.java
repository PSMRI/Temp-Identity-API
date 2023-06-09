package com.iemr.common.identity.mapper;

import com.iemr.common.identity.domain.Address;
import com.iemr.common.identity.domain.MBeneficiaryaddress;
import com.iemr.common.identity.domain.MBeneficiarycontact;
import com.iemr.common.identity.domain.MBeneficiarydetail;
import com.iemr.common.identity.dto.IdentitySearchDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T11:27:19+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
@Component
public class IdentitySearchMapperImpl implements IdentitySearchMapper {

    @Override
    public MBeneficiarydetail IdentitySearchDTOMBeneficiarydetail(IdentitySearchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiarydetail mBeneficiarydetail = new MBeneficiarydetail();

        mBeneficiarydetail.setFatherName( dto.getFatherName() );
        mBeneficiarydetail.setFirstName( dto.getFirstName() );
        mBeneficiarydetail.setLastName( dto.getLastName() );
        mBeneficiarydetail.setBeneficiaryRegID( dto.getBeneficiaryRegId() );
        mBeneficiarydetail.setGender( dto.getGenderName() );
        mBeneficiarydetail.setGenderId( dto.getGenderId() );
        mBeneficiarydetail.setMiddleName( dto.getMiddleName() );
        mBeneficiarydetail.setSpouseName( dto.getSpouseName() );
        mBeneficiarydetail.setDob( dto.getDob() );

        return mBeneficiarydetail;
    }

    @Override
    public MBeneficiaryaddress IdentitySearchDTOToMBeneficiaryaddress(IdentitySearchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiaryaddress mBeneficiaryaddress = new MBeneficiaryaddress();

        String state = dtoCurrentAddressState( dto );
        if ( state != null ) {
            mBeneficiaryaddress.setCurrState( state );
        }
        String district = dtoCurrentAddressDistrict( dto );
        if ( district != null ) {
            mBeneficiaryaddress.setCurrDistrict( district );
        }
        Integer districtId = dtoCurrentAddressDistrictId( dto );
        if ( districtId != null ) {
            mBeneficiaryaddress.setCurrDistrictId( districtId );
        }
        mBeneficiaryaddress.setCurrPinCode( dto.getPinCode() );
        Integer stateId = dtoCurrentAddressStateId( dto );
        if ( stateId != null ) {
            mBeneficiaryaddress.setCurrStateId( stateId );
        }
        mBeneficiaryaddress.setCurrentAddress( dto.getCurrentAddress() );
        mBeneficiaryaddress.setPermanentAddress( dto.getPermanentAddress() );
        mBeneficiaryaddress.setEmergencyAddress( dto.getEmergencyAddress() );

        return mBeneficiaryaddress;
    }

    @Override
    public MBeneficiarycontact IdentitySearchDTOToMBeneficiarycontact(IdentitySearchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiarycontact mBeneficiarycontact = new MBeneficiarycontact();

        mBeneficiarycontact.setPhoneNum1( dto.getContactNumber() );
        mBeneficiarycontact.setPhoneNum2( dto.getContactNumber() );
        mBeneficiarycontact.setPhoneNum3( dto.getContactNumber() );
        mBeneficiarycontact.setPhoneNum4( dto.getContactNumber() );
        mBeneficiarycontact.setPreferredPhoneNum( dto.getContactNumber() );
        mBeneficiarycontact.setPhoneNum5( dto.getContactNumber() );

        return mBeneficiarycontact;
    }

    private String dtoCurrentAddressState(IdentitySearchDTO identitySearchDTO) {
        if ( identitySearchDTO == null ) {
            return null;
        }
        Address currentAddress = identitySearchDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String state = currentAddress.getState();
        if ( state == null ) {
            return null;
        }
        return state;
    }

    private String dtoCurrentAddressDistrict(IdentitySearchDTO identitySearchDTO) {
        if ( identitySearchDTO == null ) {
            return null;
        }
        Address currentAddress = identitySearchDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        String district = currentAddress.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private Integer dtoCurrentAddressDistrictId(IdentitySearchDTO identitySearchDTO) {
        if ( identitySearchDTO == null ) {
            return null;
        }
        Address currentAddress = identitySearchDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer districtId = currentAddress.getDistrictId();
        if ( districtId == null ) {
            return null;
        }
        return districtId;
    }

    private Integer dtoCurrentAddressStateId(IdentitySearchDTO identitySearchDTO) {
        if ( identitySearchDTO == null ) {
            return null;
        }
        Address currentAddress = identitySearchDTO.getCurrentAddress();
        if ( currentAddress == null ) {
            return null;
        }
        Integer stateId = currentAddress.getStateId();
        if ( stateId == null ) {
            return null;
        }
        return stateId;
    }
}
