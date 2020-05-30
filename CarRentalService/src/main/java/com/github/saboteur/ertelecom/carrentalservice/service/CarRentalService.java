package com.github.saboteur.ertelecom.carrentalservice.service;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;

public interface CarRentalService {

    Long createOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganization(Long organizationId);
    Boolean updateOrganization(Long organizationId, OrganizationDto organizationDto);
    Boolean deleteOrganization(Long organizationId);

}
