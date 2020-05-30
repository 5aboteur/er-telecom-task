package com.github.saboteur.ertelecom.carrentalservice.mapper.domain;

import com.github.saboteur.ertelecom.carrentalservice.dto.LocationDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
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
            entity.getRegion(),
            entity.getAddress() == null
                ? null
                : addressMapper.convertToDto(entity.getAddress())
        );
    }

    @Override
    public Location convertToEntity(LocationDto dto) {
        if (dto == null || dto.getCity() == null)
            throw new IllegalArgumentException("A location requires 'city' information");

        return new Location(
            dto.getCity(),
            dto.getRegion(),
            dto.getAddress() == null
                ? null
                : addressMapper.convertToEntity(dto.getAddress())
        );
    }

}
