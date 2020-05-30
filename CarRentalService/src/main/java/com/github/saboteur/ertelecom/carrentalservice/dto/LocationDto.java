package com.github.saboteur.ertelecom.carrentalservice.dto;

public class LocationDto {
    private String city;
    private String region;
    private AddressDto address;

    public LocationDto() { }

    public LocationDto(String city, String region, AddressDto address) {
        this.city = city;
        this.region = region;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public AddressDto getAddress() {
        return address;
    }
}
