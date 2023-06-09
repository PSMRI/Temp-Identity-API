package com.iemr.common.identity.mapper;

import com.iemr.common.identity.domain.MBeneficiaryregidmapping;
import com.iemr.common.identity.dto.BenIdImportDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T11:27:18+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
@Component
public class BenIdImportMapperImpl implements BenIdImportMapper {

    @Override
    public MBeneficiaryregidmapping benIdImportDTOToMBeneficiaryregidmapping(BenIdImportDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MBeneficiaryregidmapping mBeneficiaryregidmapping = new MBeneficiaryregidmapping();

        mBeneficiaryregidmapping.setCreatedDate( dto.getCreatedDate() );
        mBeneficiaryregidmapping.setBenRegId( dto.getBenRegId() );
        mBeneficiaryregidmapping.setCreatedBy( dto.getCreatedBy() );
        mBeneficiaryregidmapping.setBeneficiaryID( dto.getBeneficiaryId() );

        return mBeneficiaryregidmapping;
    }

    @Override
    public ArrayList<MBeneficiaryregidmapping> benIdImportDTOToMBeneficiaryregidmappings(List<BenIdImportDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        ArrayList<MBeneficiaryregidmapping> arrayList = new ArrayList<MBeneficiaryregidmapping>();
        for ( BenIdImportDTO benIdImportDTO : dto ) {
            arrayList.add( benIdImportDTOToMBeneficiaryregidmapping( benIdImportDTO ) );
        }

        return arrayList;
    }
}
