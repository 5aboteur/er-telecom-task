package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location extends BaseModel {

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Address getAddress() {
        return address;
    }

}
