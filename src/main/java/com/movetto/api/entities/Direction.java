package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Direction {

    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DirectionType directionType;

    @Embedded
    private Coordinate coordinate;

    private LocalDateTime registrationDate;
    private boolean active;

    public Direction() {
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Direction(String street, String postalCode, String city,
                     String state, String country, Coordinate coordinate,
                     DirectionType directionType) {
        this();
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.coordinate = coordinate;
        this.directionType = directionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
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
        return "Direction{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", coordinate=" + coordinate +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
