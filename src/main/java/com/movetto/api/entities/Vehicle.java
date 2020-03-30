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
    @Column(nullable = false)
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
    private int hash;

    @ManyToOne
    private User user;

    private LocalDateTime registrationDate;
    private Boolean active;

    public Vehicle() {
        this.name = "default";
        this.hash = hashCode();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getId() == vehicle.getId() &&
                Double.compare(vehicle.getMaxVolume(), getMaxVolume()) == 0 &&
                Double.compare(vehicle.getMaxWeight(), getMaxWeight()) == 0 &&
                Double.compare(vehicle.getMaxLenght(), getMaxLenght()) == 0 &&
                Double.compare(vehicle.getMaxWidth(), getMaxWidth()) == 0 &&
                Double.compare(vehicle.getMaxHigh(), getMaxHigh()) == 0 &&
                getHash() == vehicle.getHash() &&
                getName().equals(vehicle.getName()) &&
                getVehicleType() == vehicle.getVehicleType() &&
                Objects.equals(getRegistration(), vehicle.getRegistration()) &&
                Objects.equals(getUser(), vehicle.getUser()) &&
                Objects.equals(getRegistrationDate(), vehicle.getRegistrationDate()) &&
                Objects.equals(isActive(), vehicle.isActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVehicleType(), getRegistration(),
                getMaxVolume(), getMaxWeight(), getMaxLenght(), getMaxWidth(),
                getMaxHigh(), getHash(), getUser(), getRegistrationDate(),
                isActive());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehicleType=" + vehicleType +
                ", registration='" + registration + '\'' +
                ", maxVolume=" + maxVolume +
                ", maxWeight=" + maxWeight +
                ", maxLenght=" + maxLenght +
                ", maxWidth=" + maxWidth +
                ", maxHigh=" + maxHigh +
                ", hash=" + hash +
                ", user=" + user +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
