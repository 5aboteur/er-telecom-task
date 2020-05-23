package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
public class Branch extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    public String getPhone() {
        return phone;
    }

    public Location getLocation() {
        return location;
    }

}
