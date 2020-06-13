package com.movetto.api.dtos;

import java.time.LocalDateTime;

public abstract class VehicleDto {

    private int id;
    private String name;
    private String registration;

    private LocalDateTime registrationDate;
    private Boolean active;

    public VehicleDto() {
        this.name = "DEFAULT";
        this.registrationDate = LocalDateTime.now();
        this.active = true;
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
                "name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
