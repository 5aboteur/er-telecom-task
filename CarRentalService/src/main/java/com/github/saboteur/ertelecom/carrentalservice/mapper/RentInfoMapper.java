package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.dto.RentInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.common.LocalDateTimeMapper;
import com.github.saboteur.ertelecom.carrentalservice.model.RentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentInfoMapper implements Mapper<RentInfo, RentInfoDto> {

    @Autowired
    private LocalDateTimeMapper localDateTimeMapper;

    @Autowired
    private NameMapper nameMapper;

    @Override
    public RentInfoDto convertToDto(RentInfo entity) {
        return new RentInfoDto(
            entity.getBranchCode(),
            localDateTimeMapper.convertToString(entity.getDateStart()),
            localDateTimeMapper.convertToString(entity.getDateEnd()),
            nameMapper.convertToDto(entity.getRenterFullName())
        );
    }

    @Override
    public RentInfo convertToEntity(RentInfoDto dto) {
        if (allDtoParametersAreNull(dto))
            throw new IllegalArgumentException("A rent info requires full information");

        return new RentInfo(
            dto.getBranchCode(),
            localDateTimeMapper.convertToLocalDateTime(dto.getDateStart()),
            localDateTimeMapper.convertToLocalDateTime(dto.getDateEnd()),
            nameMapper.convertToEntity(dto.getRenterFullName())
        );
    }

    private boolean allDtoParametersAreNull(RentInfoDto dto) {
        return dto == null
            || dto.getBranchCode() == null
            || dto.getDateStart() == null
            || dto.getDateEnd() == null
            || dto.getRenterFullName() == null;
    }

}
