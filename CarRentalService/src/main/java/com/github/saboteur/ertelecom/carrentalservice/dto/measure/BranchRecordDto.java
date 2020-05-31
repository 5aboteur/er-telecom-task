package com.github.saboteur.ertelecom.carrentalservice.dto.measure;

public class BranchRecordDto {
    private String code;
    private String time;

    public BranchRecordDto() { }

    public BranchRecordDto(String code, String time) {
        this.code = code;
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public String getTime() {
        return time;
    }
}
