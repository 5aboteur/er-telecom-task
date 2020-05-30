package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "organizations")
public class Organization extends BaseModel {

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private String inn;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
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

}
