package com.movetto.api.dtos;

import com.movetto.api.entities.User;
import com.movetto.api.entities.VehicleTypeEnum;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class VehicleDto {

    private int id;
    @NotNull
    private String name;
    private VehicleTypeEnum vehicleType;
    private String registration;
    private double maxVolume;
    private double maxWeight;
    private double maxLenght;
    private double maxWidth;
    private double maxHigh;
    private int hash;

    private User user;

    private LocalDateTime registrationDate;
    private Boolean active;

    public VehicleDto(int id, @NotNull String name, VehicleTypeEnum vehicleType,
                      String registration, double maxVolume, double maxWeight,
                      double maxLenght, double maxWidth, double maxHigh, int hash,
                      User user, LocalDateTime registrationDate, Boolean active) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.registration = registration;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
        this.maxLenght = maxLenght;
        this.maxWidth = maxWidth;
        this.maxHigh = maxHigh;
        this.hash = hash;
        this.user = user;
        this.registrationDate = registrationDate;
        this.active = active;
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

    public VehicleTypeEnum getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeEnum vehicleType) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
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
