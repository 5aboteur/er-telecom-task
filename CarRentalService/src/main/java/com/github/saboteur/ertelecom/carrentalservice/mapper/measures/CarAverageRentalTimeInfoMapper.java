package com.github.saboteur.ertelecom.carrentalservice.mapper.measures;

import com.github.saboteur.ertelecom.carrentalservice.dto.measures.CarAverageRentalTimeInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import com.github.saboteur.ertelecom.carrentalservice.model.measures.CarAverageRentalTimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarAverageRentalTimeInfoMapper implements Mapper<CarAverageRentalTimeInfo, CarAverageRentalTimeInfoDto> {

    @Autowired
    private BranchRecordMapper branchRecordMapper;

    @Override
    public CarAverageRentalTimeInfoDto convertToDto(CarAverageRentalTimeInfo entity) {
        return new CarAverageRentalTimeInfoDto(
            entity.getBrand(),
            entity.getNumber(),
            entity.getRecords() == null
                ? null
                : entity
                    .getRecords()
                    .entrySet()
                    .stream()
                    .map(branchRecordMapper::convertToDto)
                    .collect(Collectors.toList())
        );
    }

    @Override
    public CarAverageRentalTimeInfo convertToEntity(CarAverageRentalTimeInfoDto dto) {
        return null;
    }

}
