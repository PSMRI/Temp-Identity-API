package com.iemr.common.identity.mapper;

import com.iemr.common.identity.domain.MBeneficiarydetail;
import com.iemr.common.identity.domain.MBeneficiarymapping;
import com.iemr.common.identity.domain.MBeneficiaryregidmapping;
import com.iemr.common.identity.dto.BeneficiariesPartialDTO;
import com.iemr.common.identity.dto.BeneficiaryCreateResp;
import java.math.BigInteger;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T11:27:19+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
@Component
public class IdentityPartialMapperImpl implements IdentityPartialMapper {

    @Override
    public BeneficiariesPartialDTO MBeneficiarymappingToBeneficiariesPartialDTO(MBeneficiarymapping map) {
        if ( map == null ) {
            return null;
        }

        BeneficiariesPartialDTO beneficiariesPartialDTO = new BeneficiariesPartialDTO();

        String firstName = mapMBeneficiarydetailFirstName( map );
        if ( firstName != null ) {
            beneficiariesPartialDTO.setFirstName( firstName );
        }
        String lastName = mapMBeneficiarydetailLastName( map );
        if ( lastName != null ) {
            beneficiariesPartialDTO.setLastName( lastName );
        }
        String fatherName = mapMBeneficiarydetailFatherName( map );
        if ( fatherName != null ) {
            beneficiariesPartialDTO.setFatherName( fatherName );
        }
        BigInteger beneficiaryID = mapMBeneficiaryregidmappingBeneficiaryID( map );
        if ( beneficiaryID != null ) {
            beneficiariesPartialDTO.setBenId( beneficiaryID );
        }
        BigInteger benRegId = mapMBeneficiaryregidmappingBenRegId( map );
        if ( benRegId != null ) {
            beneficiariesPartialDTO.setBenRegId( benRegId );
        }
        String middleName = mapMBeneficiarydetailMiddleName( map );
        if ( middleName != null ) {
            beneficiariesPartialDTO.setMiddleName( middleName );
        }
        String spouseName = mapMBeneficiarydetailSpouseName( map );
        if ( spouseName != null ) {
            beneficiariesPartialDTO.setSpouseName( spouseName );
        }
        BigInteger beneficiaryDetailsId = mapMBeneficiarydetailBeneficiaryDetailsId( map );
        if ( beneficiaryDetailsId != null ) {
            beneficiariesPartialDTO.setBeneficiaryDetailsId( beneficiaryDetailsId );
        }

        beneficiariesPartialDTO.setBeneficiaryAge( MBeneficiarydetail.calculateAge(map.getMBeneficiarydetail().getDob()) );

        return beneficiariesPartialDTO;
    }

    @Override
    public BeneficiaryCreateResp MBeneficiarymappingToBeneficiaryCreateResp(MBeneficiarymapping map) {
        if ( map == null ) {
            return null;
        }

        BeneficiaryCreateResp beneficiaryCreateResp = new BeneficiaryCreateResp();

        BigInteger benRegId = mapMBeneficiaryregidmappingBenRegId( map );
        if ( benRegId != null ) {
            beneficiaryCreateResp.setBenRegId( benRegId );
        }
        BigInteger beneficiaryID = mapMBeneficiaryregidmappingBeneficiaryID( map );
        if ( beneficiaryID != null ) {
            beneficiaryCreateResp.setBenId( beneficiaryID );
        }

        return beneficiaryCreateResp;
    }

    private String mapMBeneficiarydetailFirstName(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiarydetail mBeneficiarydetail = mBeneficiarymapping.getMBeneficiarydetail();
        if ( mBeneficiarydetail == null ) {
            return null;
        }
        String firstName = mBeneficiarydetail.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String mapMBeneficiarydetailLastName(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiarydetail mBeneficiarydetail = mBeneficiarymapping.getMBeneficiarydetail();
        if ( mBeneficiarydetail == null ) {
            return null;
        }
        String lastName = mBeneficiarydetail.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String mapMBeneficiarydetailFatherName(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiarydetail mBeneficiarydetail = mBeneficiarymapping.getMBeneficiarydetail();
        if ( mBeneficiarydetail == null ) {
            return null;
        }
        String fatherName = mBeneficiarydetail.getFatherName();
        if ( fatherName == null ) {
            return null;
        }
        return fatherName;
    }

    private BigInteger mapMBeneficiaryregidmappingBeneficiaryID(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiaryregidmapping mBeneficiaryregidmapping = mBeneficiarymapping.getMBeneficiaryregidmapping();
        if ( mBeneficiaryregidmapping == null ) {
            return null;
        }
        BigInteger beneficiaryID = mBeneficiaryregidmapping.getBeneficiaryID();
        if ( beneficiaryID == null ) {
            return null;
        }
        return beneficiaryID;
    }

    private BigInteger mapMBeneficiaryregidmappingBenRegId(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiaryregidmapping mBeneficiaryregidmapping = mBeneficiarymapping.getMBeneficiaryregidmapping();
        if ( mBeneficiaryregidmapping == null ) {
            return null;
        }
        BigInteger benRegId = mBeneficiaryregidmapping.getBenRegId();
        if ( benRegId == null ) {
            return null;
        }
        return benRegId;
    }

    private String mapMBeneficiarydetailMiddleName(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiarydetail mBeneficiarydetail = mBeneficiarymapping.getMBeneficiarydetail();
        if ( mBeneficiarydetail == null ) {
            return null;
        }
        String middleName = mBeneficiarydetail.getMiddleName();
        if ( middleName == null ) {
            return null;
        }
        return middleName;
    }

    private String mapMBeneficiarydetailSpouseName(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiarydetail mBeneficiarydetail = mBeneficiarymapping.getMBeneficiarydetail();
        if ( mBeneficiarydetail == null ) {
            return null;
        }
        String spouseName = mBeneficiarydetail.getSpouseName();
        if ( spouseName == null ) {
            return null;
        }
        return spouseName;
    }

    private BigInteger mapMBeneficiarydetailBeneficiaryDetailsId(MBeneficiarymapping mBeneficiarymapping) {
        if ( mBeneficiarymapping == null ) {
            return null;
        }
        MBeneficiarydetail mBeneficiarydetail = mBeneficiarymapping.getMBeneficiarydetail();
        if ( mBeneficiarydetail == null ) {
            return null;
        }
        BigInteger beneficiaryDetailsId = mBeneficiarydetail.getBeneficiaryDetailsId();
        if ( beneficiaryDetailsId == null ) {
            return null;
        }
        return beneficiaryDetailsId;
    }
}
