package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "names")
public class Name extends BaseModel {

    @Column(name = "first", nullable = false)
    private String first;

    @Column(name = "middle", nullable = false)
    private String middle;

    @Column(name = "last", nullable = false)
    private String last;

    public Name() { }

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

}
