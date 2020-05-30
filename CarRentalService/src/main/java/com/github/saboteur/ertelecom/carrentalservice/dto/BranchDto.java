package com.github.saboteur.ertelecom.carrentalservice.dto;

public class BranchDto {
    private String code;
    private String phone;
    private LocationDto location;

    public BranchDto() { }

    public BranchDto(String code, String phone, LocationDto location) {
        this.code = code;
        this.phone = phone;
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public String getPhone() {
        return phone;
    }

    public LocationDto getLocation() {
        return location;
    }
}
