package com.github.saboteur.ertelecom.carrentalservice.dto;

public class OrganizationShortDto {
    private String type;
    private String name;
    private String inn;

    public OrganizationShortDto() { }

    public OrganizationShortDto(String type, String name, String inn) {
        this.type = type;
        this.name = name;
        this.inn = inn;
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
}
