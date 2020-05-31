package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "branches")
public class Branch extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    public Branch() { }

    public Branch(String code, String phone, Location location) {
        this.code = code;
        this.phone = phone;
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public String getPhone() {
        return phone;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return code.equals(branch.code) &&
            Objects.equals(phone, branch.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, phone);
    }

}
