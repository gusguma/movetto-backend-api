package com.movetto.api.entities;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Van extends VehicleType {

    private String make;
    private String model;
    private String description;

    public Van() {
        //Empty for Framework
    }

    public Van(User user, String registration) {
        super(user);
        setRegistration(registration);
        setMaxVolume(1.5);
        setMaxWeight(160.0);
        setMaxLenght(200.0);
        setMaxWidth(200.0);
        setMaxHigh(200.0);
        this.make = "";
        this.model = "";
        this.description = "";
        this.setPlacesAvailable(6);
    }

    public Van (User user, String registration, String make, String model){
        this(user, registration);
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        if (!(o instanceof Van)) return false;
        if (!super.equals(o)) return false;
        Van van = (Van) o;
        return Objects.equals(getMake(), van.getMake()) &&
                Objects.equals(getModel(), van.getModel()) &&
                Objects.equals(getDescription(), van.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMake(), getModel(), getDescription());
    }

    @Override
    public String toString() {
        return "Van{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
