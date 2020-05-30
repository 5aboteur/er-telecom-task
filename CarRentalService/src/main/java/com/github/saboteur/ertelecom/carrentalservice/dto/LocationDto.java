package com.github.saboteur.ertelecom.carrentalservice.dto;

public class LocationDto {
    private String city;
    private String state;
    private AddressDto address;

    public LocationDto() { }

    public LocationDto(String city, String state, AddressDto address) {
        this.city = city;
        this.state = state;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public AddressDto getAddress() {
        return address;
    }
}
