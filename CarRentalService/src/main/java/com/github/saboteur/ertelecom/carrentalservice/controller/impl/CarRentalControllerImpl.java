package com.github.saboteur.ertelecom.carrentalservice.controller.impl;

import com.github.saboteur.ertelecom.carrentalservice.controller.CarRentalControllerApi;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationShortDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.RentalInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.measures.CarAverageRentalTimeInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.service.CarRentalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
public class CarRentalControllerImpl implements CarRentalControllerApi {

    @Autowired
    private CarRentalService carRentalService;

    @Override
    public ResponseEntity<List<OrganizationShortDto>> getOrganizations(int pageIndex, int pageSize) {
        List<OrganizationShortDto> result = carRentalService.getOrganizations(pageIndex, pageSize);
        return ResponseEntity
            .status(
                result == null || result.size() == 0
                    ? HttpStatus.NOT_FOUND
                    : HttpStatus.OK
            )
            .body(result);
    }

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

    @Override
    public ResponseEntity<List<CarAverageRentalTimeInfoDto>> getCarsAverageRentalTimeInfo(int pageIndex, int pageSize) {
        List<CarAverageRentalTimeInfoDto> result = carRentalService.getCarsAverageRentalTimeInfo(pageIndex, pageSize);
        return ResponseEntity
            .status(
                result == null || result.size() == 0
                    ? HttpStatus.NOT_FOUND
                    : HttpStatus.OK
            )
            .body(result);
    }

    @Override
    public ResponseEntity<Boolean> updateCarRentalHistory(String carNumber, RentalInfoDto rentalInfoDto) {
        Boolean result = carRentalService.updateCarRentalHistory(carNumber, rentalInfoDto);
        return ResponseEntity.ok(result);
    }

}
