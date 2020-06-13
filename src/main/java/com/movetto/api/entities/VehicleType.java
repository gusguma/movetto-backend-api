package com.movetto.api.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class VehicleType extends Vehicle {

    private double maxVolume; // m3
    private double maxWeight; // Kg
    private double maxLenght; // cm
    private double maxWidth; // cm
    private double maxHigh; // cm
    private int placesAvailable;

    @Enumerated(value = EnumType.STRING)
    private VehicleTypeEnum vehicleTypeEnum;

    public VehicleType() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleType)) return false;
        if (!super.equals(o)) return false;
        VehicleType that = (VehicleType) o;
        return Double.compare(that.getMaxVolume(), getMaxVolume()) == 0 &&
                Double.compare(that.getMaxWeight(), getMaxWeight()) == 0 &&
                Double.compare(that.getMaxLenght(), getMaxLenght()) == 0 &&
                Double.compare(that.getMaxWidth(), getMaxWidth()) == 0 &&
                Double.compare(that.getMaxHigh(), getMaxHigh()) == 0 &&
                getPlacesAvailable() == that.getPlacesAvailable();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMaxVolume(), getMaxWeight(),
                getMaxLenght(), getMaxWidth(), getMaxHigh(), getPlacesAvailable());
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "maxVolume=" + maxVolume +
                ", maxWeight=" + maxWeight +
                ", maxLenght=" + maxLenght +
                ", maxWidth=" + maxWidth +
                ", maxHigh=" + maxHigh +
                ", placesAvailable=" + placesAvailable +
                '}';
    }
}
