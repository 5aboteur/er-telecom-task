package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "organizations")
public class Organization extends BaseModel {

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inn", nullable = false, unique = true)
    private String inn;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Branch> branches;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Car> cars;

    public Organization() { }

    public Organization(String type, String name, String inn, List<Branch> branches, List<Car> cars) {
        this.type = type;
        this.name = name;
        this.inn = inn;
        this.branches = branches;
        this.cars = cars;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getInn() {
        return inn;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return type.equals(that.type) &&
            name.equals(that.name) &&
            inn.equals(that.inn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, inn);
    }

}
