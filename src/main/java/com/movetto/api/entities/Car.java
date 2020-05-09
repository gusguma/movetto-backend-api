package com.movetto.api.entities;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Car extends VehicleType {

    private String make;
    private String model;
    private String description;

    public Car() {
        super();
        setMaxVolume(0.5);
        setMaxWeight(250.0);
        setMaxLenght(200.0);
        setMaxWidth(200.0);
        setMaxHigh(200.0);
        this.make = "";
        this.model = "";
        this.description = "";
        this.setPlacesAvailable(4);
        this.setVehicleTypeEnum(VehicleTypeEnum.CAR);
    }

    public Car (String registration, String make, String model, String description){
        this();
        this.setRegistration(registration);
        this.make = make;
        this.model = model;
        this.description = description;
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
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
