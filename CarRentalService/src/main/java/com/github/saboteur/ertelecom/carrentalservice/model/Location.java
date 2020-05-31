package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "locations")
public class Location extends BaseModel {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "region")
    private String region;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Location() { }

    public Location(String city, String region, Address address) {
        this.city = city;
        this.region = region;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return city.equals(location.city) &&
            Objects.equals(region, location.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, region);
    }

}
