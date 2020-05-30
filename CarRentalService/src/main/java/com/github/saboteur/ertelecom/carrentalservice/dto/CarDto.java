package com.github.saboteur.ertelecom.carrentalservice.dto;

import java.util.List;

public class CarDto {
    private String brand;
    private String number;
    private List<RentInfoDto> rentHistory;

    public CarDto() { }

    public CarDto(String brand, String number, List<RentInfoDto> rentHistory) {
        this.brand = brand;
        this.number = number;
        this.rentHistory = rentHistory;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public List<RentInfoDto> getRentHistory() {
        return rentHistory;
    }
}
