package com.movetto.api.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private VehicleType vehicleType;
    @Column(unique = true)
    private String registration;
    private double maxVolume;
    private double maxWeight;
    private double maxLenght;
    private double maxWidth;
    private double maxHigh;

    @ManyToOne
    private User user;

    private LocalDateTime registrationDate;
    private Boolean active;

    public Vehicle() {
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Vehicle(String name, VehicleType vehicleType,
                   @Nullable String registration, double maxVolume,
                   double maxWeight, double maxLenght, double maxWidth,
                   double maxHigh) {
        this();
        this.name = name;
        this.vehicleType = vehicleType;
        this.registration = registration;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
        this.maxLenght = maxLenght;
        this.maxWidth = maxWidth;
        this.maxHigh = maxHigh;
    }

}
