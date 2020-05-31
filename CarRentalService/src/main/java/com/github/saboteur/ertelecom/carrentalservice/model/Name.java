package com.github.saboteur.ertelecom.carrentalservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return first.equals(name.first) &&
            middle.equals(name.middle) &&
            last.equals(name.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, middle, last);
    }

}
