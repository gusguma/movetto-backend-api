package com.movetto.api.dtos;

import com.movetto.api.entities.VehicleTypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public abstract class VehicleTypeDto extends VehicleDto {
    private double maxVolume; // m3
    private double maxWeight; // Kg
    private double maxLenght; // cm
    private double maxWidth; // cm
    private double maxHigh; // cm
    private int placesAvailable;

    @Enumerated(value = EnumType.STRING)
    private VehicleTypeEnum vehicleTypeEnum;

    public VehicleTypeDto() {
        super();
        placesAvailable = 0;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(double maxLenght) {
        this.maxLenght = maxLenght;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public double getMaxHigh() {
        return maxHigh;
    }

    public void setMaxHigh(double maxHigh) {
        this.maxHigh = maxHigh;
    }

    public int getPlacesAvailable() {
        return placesAvailable;
    }

    public void setPlacesAvailable(int placesAvailable) {
        this.placesAvailable = placesAvailable;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    @Override
    public String toString() {
        return "VehicleTypeDto{" +
                "maxVolume=" + maxVolume +
                ", maxWeight=" + maxWeight +
                ", maxLenght=" + maxLenght +
                ", maxWidth=" + maxWidth +
                ", maxHigh=" + maxHigh +
                ", placesAvailable=" + placesAvailable +
                ", vehicleTypeEnum=" + vehicleTypeEnum +
                '}';
    }
}
