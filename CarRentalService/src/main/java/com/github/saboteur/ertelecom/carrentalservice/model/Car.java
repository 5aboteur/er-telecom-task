package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "brand")
    private String brand;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentInfo> rentHistory;

    public Car() { }

    public Car(String brand, String number, List<RentInfo> rentHistory) {
        this.brand = brand;
        this.number = number;
        this.rentHistory = rentHistory;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public List<RentInfo> getRentHistory() {
        return rentHistory;
    }

}
