package com.movetto.api.entities;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Bike extends VehicleType {

    private String make;
    private String description;

    public Bike() {
        //Empty for Framework
    }

    public Bike(User user) {
        super(user);
        setMaxVolume(0.13);
        setMaxWeight(15.0);
        setMaxLenght(50.0);
        setMaxWidth(50.0);
        setMaxHigh(50.0);
        this.make = "";
        this.description = "";
    }

    public Bike(User user, String make){
        this(user);
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bike)) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return Objects.equals(getMake(), bike.getMake()) &&
                Objects.equals(getDescription(), bike.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMake(), getDescription());
    }

    @Override
    public String toString() {
        return "Bike{" +
                "make='" + make + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
