package com.github.saboteur.ertelecom.carrentalservice.dto;

import java.util.List;

public class OrganizationDto {
    private String type;
    private String name;
    private String inn;
    private List<BranchDto> branches;
    private List<CarDto> cars;

    public OrganizationDto() { }

    public OrganizationDto(String type, String name, String inn, List<BranchDto> branches, List<CarDto> cars) {
        this.type = type;
        this.name = name;
        this.inn = inn;
        this.branches = branches;
        this.cars = cars;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getInn() {
        return inn;
    }

    public List<BranchDto> getBranches() {
        return branches;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
