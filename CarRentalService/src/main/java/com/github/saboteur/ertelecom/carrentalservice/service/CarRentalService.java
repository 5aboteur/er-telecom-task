package com.github.saboteur.ertelecom.carrentalservice.service;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;

public interface CarRentalService {

    Long createOrganization(OrganizationDto organization);
    OrganizationDto getOrganization(Long organizationId);
    Boolean updateOrganization(String organizationId, OrganizationDto organization);
    Boolean deleteOrganization(String organizationId);

}
