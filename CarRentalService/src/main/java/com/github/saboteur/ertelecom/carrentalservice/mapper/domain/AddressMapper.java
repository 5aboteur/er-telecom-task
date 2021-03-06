package com.github.saboteur.ertelecom.carrentalservice.mapper.domain;

import com.github.saboteur.ertelecom.carrentalservice.dto.AddressDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import com.github.saboteur.ertelecom.carrentalservice.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressDto> {

    @Override
    public AddressDto convertToDto(Address entity) {
        return new AddressDto(
            entity.getStreet(),
            entity.getNumber(),
            entity.getPostalCode()
        );
    }

    @Override
    public Address convertToEntity(AddressDto dto) {
        if (dto == null || dto.getStreet() == null || dto.getNumber() == null)
            throw new IllegalArgumentException("An address requires 'street' and 'number' information");

        return new Address(
            dto.getStreet(),
            dto.getNumber(),
            dto.getPostalCode()
        );
    }

}
