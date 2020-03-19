package com.movetto.api.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Direction {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private boolean status;
    @Embedded
    private Coordinate coordinate;

    public Direction() {
        //Empty for Framework
    }

    public Direction(String name, String street, String postalCode,
                     String city, String state, String country) {
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public boolean isStatus() {
        return status;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
