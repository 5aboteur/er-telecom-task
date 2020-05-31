package com.github.saboteur.ertelecom.carrentalservice.controller;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationShortDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.RentalInfoDto;
import com.github.saboteur.ertelecom.carrentalservice.dto.measure.CarAverageRentalTimeInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Car Rental service controller")
@RestController
@RequestMapping("api")
public interface CarRentalControllerApi {

    // Organizations APIs

    @ApiOperation(value = "Get all organizations")
    @GetMapping("/organizations/get")
    ResponseEntity<List<OrganizationShortDto>> getOrganizations(
        @ApiParam(value = "Page index", defaultValue = "0", example = "0")
        @RequestParam(value = "pageIndex")
        int pageIndex,

        @ApiParam(value = "Page size", defaultValue = "10", example = "10")
        @RequestParam(value = "pageSize")
        int pageSize
    );

    // Organization APIs

    @ApiOperation(value = "Add organization info")
    @PostMapping("/organization/create")
    ResponseEntity<Long> createOrganization(
        @ApiParam("Full organization info")
        @RequestBody
        OrganizationDto organization
    );

    @ApiOperation(value = "Get organization info by ID")
    @GetMapping("/organization/get")
    ResponseEntity<OrganizationDto> getOrganization(
        @ApiParam(value = "Organization ID", required = true, example = "666")
        @RequestParam(value = "organizationId")
        Long organizationId
    );

    @ApiOperation(value = "Update organization info")
    @PutMapping("/organization/update")
    ResponseEntity<Boolean> updateOrganization(
        @ApiParam(value = "Organization ID", required = true, example = "666")
        @RequestParam(value = "organizationId")
        Long organizationId,

        @ApiParam("Full organization info")
        @RequestBody
        OrganizationDto organization
    );

    @ApiOperation(value = "Delete organization info")
    @DeleteMapping("/organization/delete")
    ResponseEntity<Boolean> deleteOrganization(
        @ApiParam(value = "Organization ID", required = true, example = "666")
        @RequestParam(value = "organizationId")
        Long organizationId
    );

    // Cars APIs

    // TODO: play with async here
    @ApiOperation(value = "Get all car's average rental time info for every branch")
    @GetMapping("/cars/rental/info/get")
    ResponseEntity<List<CarAverageRentalTimeInfoDto>> getCarsAverageRentalTimeInfo(
        @ApiParam(value = "Page index", defaultValue = "0", example = "0")
        @RequestParam(value = "pageIndex")
        int pageIndex,

        @ApiParam(value = "Page size", defaultValue = "10", example = "10")
        @RequestParam(value = "pageSize")
        int pageSize
    );

    // Car APIs

    @ApiOperation(value = "Update car rental history")
    @PutMapping("/car/rental/update")
    ResponseEntity<Boolean> updateCarRentalHistory(
        @ApiParam(value = "Car number", required = true, example = "V666AD66")
        @RequestParam(value = "carNumber")
        String carNumber,

        @ApiParam("Rental info")
        @RequestBody
        RentalInfoDto rentalInfoDto
    );

}
