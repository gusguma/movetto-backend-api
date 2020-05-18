package com.movetto.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bike.class, name = "Bike"),
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle"),
        @JsonSubTypes.Type(value = Van.class, name = "Van")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String registration;

    private LocalDateTime registrationDate;
    private Boolean active;

    public Vehicle() {
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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
