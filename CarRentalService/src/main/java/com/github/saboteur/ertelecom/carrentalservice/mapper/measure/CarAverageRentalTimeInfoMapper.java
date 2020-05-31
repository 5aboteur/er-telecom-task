package com.github.saboteur.ertelecom.carrentalservice.mapper.measure;

import com.github.saboteur.ertelecom.carrentalservice.dto.measure.CarAverageRentalTimeInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import com.github.saboteur.ertelecom.carrentalservice.model.measure.CarAverageRentalTimeInfo;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarAverageRentalTimeInfoMapper implements Mapper<CarAverageRentalTimeInfo, CarAverageRentalTimeInfoDto> {

    private final BranchRecordMapper branchRecordMapper;

    public CarAverageRentalTimeInfoMapper(BranchRecordMapper branchRecordMapper) {
        this.branchRecordMapper = branchRecordMapper;
    }

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
