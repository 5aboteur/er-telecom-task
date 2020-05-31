package com.github.saboteur.ertelecom.carrentalservice.mapper.domain;

import com.github.saboteur.ertelecom.carrentalservice.dto.CarDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import com.github.saboteur.ertelecom.carrentalservice.model.Car;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarMapper implements Mapper<Car, CarDto> {

    private final RentalInfoMapper rentalInfoMapper;

    public CarMapper(RentalInfoMapper rentalInfoMapper) {
        this.rentalInfoMapper = rentalInfoMapper;
    }

    @Override
    public CarDto convertToDto(Car entity) {
        return new CarDto(
            entity.getBrand(),
            entity.getNumber(),
            entity.getRentalHistory() == null
                ? null
                : entity
                    .getRentalHistory()
                    .stream()
                    .map(rentalInfoMapper::convertToDto)
                    .collect(Collectors.toList())
        );
    }

    @Override
    public Car convertToEntity(CarDto dto) {
        if (dto == null || dto.getBrand() == null || dto.getNumber() == null)
            throw new IllegalArgumentException("A car requires 'brand' and 'number' information");

        return new Car(
            dto.getBrand(),
            dto.getNumber(),
            dto.getRentalHistory() == null
                ? null
                : dto
                    .getRentalHistory()
                    .stream()
                    .map(rentalInfoMapper::convertToEntity)
                    .collect(Collectors.toSet())
        );
    }

}
