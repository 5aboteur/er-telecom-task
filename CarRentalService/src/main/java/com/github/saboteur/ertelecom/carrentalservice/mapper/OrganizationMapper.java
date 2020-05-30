package com.github.saboteur.ertelecom.carrentalservice.mapper;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
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
        return new Organization(
            dto.getType(),
            dto.getName(),
            dto.getInn(),
            dto
                .getBranches()
                .stream()
                .map(branchMapper::convertToEntity)
                .collect(Collectors.toList()),
            dto
                .getCars()
                .stream()
                .map(carMapper::convertToEntity)
                .collect(Collectors.toList())
        );
    }

}
