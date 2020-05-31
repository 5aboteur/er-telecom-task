package com.github.saboteur.ertelecom.carrentalservice.model.measure;

import java.util.Map;

public class CarAverageRentalTimeInfo {
    private String brand;
    private String number;
    private Map<String, Long> records;

    public CarAverageRentalTimeInfo() { }

    public CarAverageRentalTimeInfo(String brand, String number, Map<String, Long> records) {
        this.brand = brand;
        this.number = number;
        this.records = records;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public Map<String, Long> getRecords() {
        return records;
    }
}
