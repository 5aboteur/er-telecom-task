package com.github.saboteur.ertelecom.carrentalservice.mapper.domain;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationShortDto;
import com.github.saboteur.ertelecom.carrentalservice.mapper.Mapper;
import com.github.saboteur.ertelecom.carrentalservice.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrganizationMapper implements Mapper<Organization, OrganizationDto> {

    @Autowired
    private BranchMapper branchMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public OrganizationDto convertToDto(Organization entity) {
        return new OrganizationDto(
            entity.getType(),
            entity.getName(),
            entity.getInn(),
            entity
                .getBranches()
                .stream()
                .map(branchMapper::convertToDto)
                .collect(Collectors.toList()),
            entity
                .getCars()
                .stream()
                .map(carMapper::convertToDto)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Organization convertToEntity(OrganizationDto dto) {
        if (dto == null || dto.getType() == null || dto.getName() == null || dto.getInn() == null)
            throw new IllegalArgumentException("An organization requires 'type', 'name' and 'inn' information");

        return new Organization(
            dto.getType(),
            dto.getName(),
            dto.getInn(),
            dto.getBranches() == null
                ? null
                : dto
                    .getBranches()
                    .stream()
                    .map(branchMapper::convertToEntity)
                    .collect(Collectors.toList()),
            dto.getCars() == null
                ? null
                : dto
                    .getCars()
                    .stream()
                    .map(carMapper::convertToEntity)
                    .collect(Collectors.toList())
        );
    }

    public OrganizationShortDto convertToShortDto(Organization entity) {
        return new OrganizationShortDto(
            entity.getType(),
            entity.getName(),
            entity.getInn()
        );
    }

}
