package com.github.saboteur.ertelecom.carrentalservice.service;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationShortDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.RentalInfoDto;

import java.util.List;

public interface CarRentalService {

    List<OrganizationShortDto> getOrganizations(int pageIndex, int pageSize);

    Long createOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganization(Long organizationId);
    Boolean updateOrganization(Long organizationId, OrganizationDto organizationDto);
    Boolean deleteOrganization(Long organizationId);

    Boolean updateCarRentalHistory(String carNumber, RentalInfoDto rentalInfoDto);

}
