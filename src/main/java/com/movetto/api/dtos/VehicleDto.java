package com.movetto.api.dtos;

import com.movetto.api.entities.User;
import com.movetto.api.entities.Vehicle;
import com.movetto.api.entities.VehicleTypeEnum;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public Boolean getActive() {
        return active;
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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
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
