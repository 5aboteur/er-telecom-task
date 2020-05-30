package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.dto.LocationDto;
import com.github.saboteur.ertelecom.carrentalservice.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements Mapper<Location, LocationDto> {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public LocationDto convertToDto(Location entity) {
        return new LocationDto(
            entity.getCity(),
            entity.getState(),
            addressMapper.convertToDto(entity.getAddress())
        );
    }

    @Override
    public Location convertToEntity(LocationDto dto) {
        return new Location(
            dto.getCity(),
            dto.getState(),
            addressMapper.convertToEntity(dto.getAddress())
        );
    }

}
