package com.movetto.api.entity;

import org.omg.CORBA.WStringSeqHelper;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Direction {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, columnDefinition = "default")
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
    @Column(nullable = false, columnDefinition = "true")
    private boolean status;
    @Embedded @Column(nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return getId() == direction.getId() &&
                isStatus() == direction.isStatus() &&
                getName().equals(direction.getName()) &&
                getStreet().equals(direction.getStreet()) &&
                getPostalCode().equals(direction.getPostalCode()) &&
                getCity().equals(direction.getCity()) &&
                getState().equals(direction.getState()) &&
                getCountry().equals(direction.getCountry()) &&
                getCoordinate().equals(direction.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(),
                getPostalCode(), getCity(), getState(), getCountry(),
                isStatus(), getCoordinate());
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", status=" + status +
                ", coordinate=" + coordinate +
                '}';
    }
}