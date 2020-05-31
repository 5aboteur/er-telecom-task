package com.github.saboteur.ertelecom.carrentalservice.mapper.domain;

import com.github.saboteur.ertelecom.carrentalservice.dto.RentalInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import com.github.saboteur.ertelecom.carrentalservice.mapper.common.LocalDateTimeMapper;
import com.github.saboteur.ertelecom.carrentalservice.model.RentalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalInfoMapper implements Mapper<RentalInfo, RentalInfoDto> {

    @Autowired
    private LocalDateTimeMapper localDateTimeMapper;

    @Autowired
    private NameMapper nameMapper;

    @Override
    public RentalInfoDto convertToDto(RentalInfo entity) {
        return new RentalInfoDto(
            entity.getBranchCode(),
            localDateTimeMapper.convertToString(entity.getDateStart()),
            localDateTimeMapper.convertToString(entity.getDateEnd()),
            nameMapper.convertToDto(entity.getRenterFullName())
        );
    }

    @Override
    public RentalInfo convertToEntity(RentalInfoDto dto) {
        if (allDtoParametersAreNull(dto))
            throw new IllegalArgumentException("A rental info requires full information");

        return new RentalInfo(
            dto.getBranchCode(),
            localDateTimeMapper.convertToLocalDateTime(dto.getDateStart()),
            localDateTimeMapper.convertToLocalDateTime(dto.getDateEnd()),
            nameMapper.convertToEntity(dto.getRenterFullName())
        );
    }

    private boolean allDtoParametersAreNull(RentalInfoDto dto) {
        return dto == null
            || dto.getBranchCode() == null
            || dto.getDateStart() == null
            || dto.getDateEnd() == null
            || dto.getRenterFullName() == null;
    }

}
