package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String registration;
    @Column(unique = true)
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

    public Vehicle(User user){
        this();
        this.user = user;
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
                getHash() == vehicle.getHash() &&
                getName().equals(vehicle.getName()) &&
                Objects.equals(getRegistration(), vehicle.getRegistration()) &&
                getUser().equals(vehicle.getUser()) &&
                Objects.equals(getRegistrationDate(), vehicle.getRegistrationDate()) &&
                Objects.equals(isActive(), vehicle.isActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRegistration(), getHash(),
                getUser(), getRegistrationDate(), isActive());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                ", hash=" + hash +
                ", user=" + user +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
