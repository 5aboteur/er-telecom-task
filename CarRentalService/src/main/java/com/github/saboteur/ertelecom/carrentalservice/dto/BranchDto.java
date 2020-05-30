package com.github.saboteur.ertelecom.carrentalservice.dto;

public class BranchDto {
    private String phone;
    private LocationDto location;

    public BranchDto() { }

    public BranchDto(String phone, LocationDto location) {
        this.phone = phone;
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public LocationDto getLocation() {
        return location;
    }
}
