package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent_info")
public class RentInfo extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @Column(name = "branch_code", nullable = false)
    private String branchCode;

    @Column(name = "date_start", nullable = false)
    private LocalDateTime dateStart;

    @Column(name = "date_end", nullable = false)
    private LocalDateTime dateEnd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "renter_full_name_id", nullable = false)
    private Name renterFullName;

    public RentInfo() { }

    public RentInfo(String branchCode, LocalDateTime dateStart, LocalDateTime dateEnd, Name renterFullName) {
        this.branchCode = branchCode;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.renterFullName = renterFullName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public Name getRenterFullName() {
        return renterFullName;
    }

}
