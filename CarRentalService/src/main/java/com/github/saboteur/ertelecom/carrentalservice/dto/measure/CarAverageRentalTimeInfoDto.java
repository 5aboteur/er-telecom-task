package com.github.saboteur.ertelecom.carrentalservice.dto.measure;

import java.util.List;

public class CarAverageRentalTimeInfoDto {
    private String brand;
    private String number;
    private List<BranchRecordDto> records;

    public CarAverageRentalTimeInfoDto() { }

    public CarAverageRentalTimeInfoDto(String brand, String number, List<BranchRecordDto> records) {
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

    public List<BranchRecordDto> getRecords() {
        return records;
    }
}
