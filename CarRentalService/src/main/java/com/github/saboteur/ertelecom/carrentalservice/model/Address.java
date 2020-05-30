package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends BaseModel {

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "postal_code")
    private String postalCode;

    public Address() { }

    public Address(String street, String number, String postalCode) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

}
