package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<RentalInfo> rentalHistory;

    public Car() { }

    public Car(String brand, String number, Set<RentalInfo> rentalHistory) {
        this.brand = brand;
        this.number = number;
        this.rentalHistory = rentalHistory;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    public Set<RentalInfo> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(Set<RentalInfo> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return brand.equals(car.brand) &&
            number.equals(car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }

}
