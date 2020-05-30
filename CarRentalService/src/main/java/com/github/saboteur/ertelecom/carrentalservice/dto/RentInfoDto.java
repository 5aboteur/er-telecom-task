package com.github.saboteur.ertelecom.carrentalservice.dto;

public class RentInfoDto {
    private String branchCode;
    private String dateStart;
    private String dateEnd;
    private String tenantFullName;

    public RentInfoDto() { }

    public RentInfoDto(String branchCode, String dateStart, String dateEnd, String tenantFullName) {
        this.branchCode = branchCode;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.tenantFullName = tenantFullName;
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

    public String getTenantFullName() {
        return tenantFullName;
    }
}
