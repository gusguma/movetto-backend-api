package com.movetto.api.dtos;

import com.movetto.api.entities.VehicleTypeEnum;

public class BikeDto extends VehicleTypeDto {

    private String make;
    private String description;

    public BikeDto() {
        super();
        setMaxVolume(0.13);
        setMaxWeight(15.0);
        setMaxLenght(50.0);
        setMaxWidth(50.0);
        setMaxHigh(50.0);
        this.make = "";
        this.description = "";
        this.setVehicleTypeEnum(VehicleTypeEnum.BIKE);
    }

    public BikeDto(String make, String description){
        this();
        this.make = make;
        this.description = description;
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
    public String toString() {
        return "BikeDto{" +
                "make='" + make + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
