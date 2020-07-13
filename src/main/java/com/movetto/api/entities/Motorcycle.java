package com.movetto.api.entities;

import javax.persistence.Entity;

@Entity
public class Motorcycle extends VehicleType {

    private String make;
    private String model;
    private String description;

    public Motorcycle() {
        super();
        setMaxVolume(0.13);
        setMaxWeight(80.0);
        setMaxLenght(50.0);
        setMaxWidth(50.0);
        setMaxHigh(50.0);
        this.make = "";
        this.model = "";
        this.description = "";
        this.setPlacesAvailable(1);
        this.setVehicleTypeEnum(VehicleTypeEnum.MOTORCYCLE);
    }

    public Motorcycle (String registration, String make, String model, String description){
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
        return "Motorcycle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
