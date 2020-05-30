package com.github.saboteur.ertelecom.carrentalservice.dto;

public class AddressDto {
    private String street;
    private String number;
    private String postalCode;

    public AddressDto() { }

    public AddressDto(String street, String number, String postalCode) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
