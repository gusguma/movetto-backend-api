package com.movetto.api.entities;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Car extends VehicleType {

    public String make;
    public String model;
    public String description;

    public Car() {
        //Empty for Framework
    }

    public Car(User user, String registration) {
        super(user);
        setRegistration(registration);
        setMaxVolume(0.5);
        setMaxWeight(250.0);
        setMaxLenght(200.0);
        setMaxWidth(200.0);
        setMaxHigh(200.0);
        this.make = "";
        this.model = "";
        this.description = "";
        this.setPlacesAvailable(4);
    }

    public Car (User user, String registration, String make, String model){
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
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(getMake(), car.getMake()) &&
                Objects.equals(getModel(), car.getModel()) &&
                Objects.equals(getDescription(), car.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMake(), getModel(), getDescription());
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
