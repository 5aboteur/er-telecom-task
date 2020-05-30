package com.github.saboteur.ertelecom.carrentalservice.controller.impl;

import com.github.saboteur.ertelecom.carrentalservice.controller.CarRentalControllerApi;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.service.CarRentalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class CarRentalControllerImpl implements CarRentalControllerApi {

    @Autowired
    private CarRentalService carRentalService;

    @Override
    public ResponseEntity<Long> createOrganization(OrganizationDto organizationDto) {
        Long result = carRentalService.createOrganization(organizationDto);
        return ResponseEntity
            .status(
                result == -1 || result == 0
                    ? HttpStatus.BAD_REQUEST
                    : HttpStatus.CREATED
            )
            .body(result);
    }

    @Override
    public ResponseEntity<OrganizationDto> getOrganization(Long organizationId) {
        OrganizationDto result = carRentalService.getOrganization(organizationId);
        return ResponseEntity
            .status(
                result == null
                    ? HttpStatus.NOT_FOUND
                    : HttpStatus.OK
            )
            .body(result);
    }

    @Override
    public ResponseEntity<Boolean> updateOrganization(Long organizationId, OrganizationDto organizationDto) {
        Boolean result = carRentalService.updateOrganization(organizationId, organizationDto);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Boolean> deleteOrganization(Long organizationId) {
        Boolean result = carRentalService.deleteOrganization(organizationId);
        return ResponseEntity.ok(result);
    }

}
