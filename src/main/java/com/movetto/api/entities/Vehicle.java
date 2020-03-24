package com.movetto.api.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private VehicleType vehicleType;

    @Column(unique = true)
    private String registration;

    @Column(nullable = false)
    private double maxVolume;

    @Column(nullable = false)
    private double maxWeight;

    @Column(nullable = false)
    private double maxLenght;

    @Column(nullable = false)
    private double maxWidth;

    @Column(nullable = false)
    private double maxHigh;

    public Vehicle() {
        //Empty for framework
    }

    public Vehicle(String name, VehicleType vehicleType,
                   @Nullable String registration, double maxVolume,
                   double maxWeight, double maxLenght, double maxWidth,
                   double maxHigh) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.registration = registration;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
        this.maxLenght = maxLenght;
        this.maxWidth = maxWidth;
        this.maxHigh = maxHigh;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegistration() {
        return registration;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMaxLenght() {
        return maxLenght;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxHigh() {
        return maxHigh;
    }
}
