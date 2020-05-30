package com.github.saboteur.ertelecom.carrentalservice.controller;

import com.github.saboteur.ertelecom.carrentalservice.dto.OrganizationDto;
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

@Api(value = "Car Rental service controller")
@RestController
@RequestMapping("api")
public interface CarRentalControllerApi {

    // Rent APIs

//    @ApiOperation(value = "")
//    @PostMapping("")
//    ResponseEntity<String> createRentRecord(
//        @ApiParam("Full rental info")
//        @RequestBody
//        RentRecordDto rentRecordDto
//    );

    // Organization APIs

    @ApiOperation(value = "Add organization info")
    @PostMapping("/carrental/organization/create")
    ResponseEntity<Long> createOrganization(
        @ApiParam("Full organization info")
        @RequestBody
        OrganizationDto organization
    );

    @ApiOperation(value = "Get organization info by ID")
    @GetMapping("/carrental/organization/get")
    ResponseEntity<OrganizationDto> getOrganization(
        @ApiParam(value = "Organization ID", required = true, example = "666")
        @RequestParam(value = "organizationId")
        Long organizationId
    );

    @ApiOperation(value = "Update organization info")
    @PutMapping("/carrental/organization/update")
    ResponseEntity<Boolean> updateOrganization(
        @ApiParam(value = "Organization ID", required = true, example = "666")
        @RequestParam(value = "organizationId")
        Long organizationId,

        @ApiParam("Full organization info")
        @RequestBody
        OrganizationDto organization
    );

    @ApiOperation(value = "Delete organization info")
    @DeleteMapping("/carrental/organization/delete")
    ResponseEntity<Boolean> deleteOrganization(
        @ApiParam(value = "Organization ID", required = true, example = "666")
        @RequestParam(value = "organizationId")
        Long organizationId
    );

    // Car APIs

}
