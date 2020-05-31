package com.github.saboteur.ertelecom.carrentalservice.dto;

public class RentalInfoDto {
    private String branchCode;
    private String dateStart;
    private String dateEnd;
    private String renterFullName;

    public RentalInfoDto() { }

    public RentalInfoDto(String branchCode, String dateStart, String dateEnd, String renterFullName) {
        this.branchCode = branchCode;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.renterFullName = renterFullName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getRenterFullName() {
        return renterFullName;
    }
}
