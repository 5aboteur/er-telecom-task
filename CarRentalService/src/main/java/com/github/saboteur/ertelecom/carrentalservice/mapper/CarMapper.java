package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.dto.CarDto;
import com.github.saboteur.ertelecom.carrentalservice.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarMapper implements Mapper<Car, CarDto> {

    @Autowired
    private RentInfoMapper rentInfoMapper;

    @Override
    public CarDto convertToDto(Car entity) {
        return new CarDto(
            entity.getBrand(),
            entity.getNumber(),
            entity
                .getRentHistory()
                .stream()
                .map(rentInfoMapper::convertToDto)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Car convertToEntity(CarDto dto) {
        return new Car(
            dto.getBrand(),
            dto.getNumber(),
            dto
                .getRentHistory()
                .stream()
                .map(rentInfoMapper::convertToEntity)
                .collect(Collectors.toList())
        );
    }

}
