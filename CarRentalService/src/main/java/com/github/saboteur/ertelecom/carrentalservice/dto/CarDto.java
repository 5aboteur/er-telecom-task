package com.github.saboteur.ertelecom.carrentalservice.dto;

import java.util.List;

public class CarDto {
    private String brand;
    private String number;
    private List<RentalInfoDto> rentalHistory;

    public CarDto() { }

    public CarDto(String brand, String number, List<RentalInfoDto> rentalHistory) {
        this.brand = brand;
        this.number = number;
        this.rentalHistory = rentalHistory;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public List<RentalInfoDto> getRentalHistory() {
        return rentalHistory;
    }
}
