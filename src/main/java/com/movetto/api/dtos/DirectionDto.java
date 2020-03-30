package com.movetto.api.dtos;

import com.movetto.api.entities.Coordinate;
import com.movetto.api.entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class DirectionDto {

    @NotNull
    private int id;
    @NotNull
    private String name;
    private String street;
    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.POSTAL_CODE)
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private int hash;

    private Coordinate coordinate;
    @NotNull
    private User user;

    private LocalDateTime localDateTime;
    private boolean active;

    public DirectionDto(){
        //Empty for Framework
    }

    public DirectionDto(@NotNull int id, @NotNull String name, String street,
                        @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.POSTAL_CODE) String postalCode,
                        String city, String state, String country, int hash, Coordinate coordinate,
                        @NotNull User user, LocalDateTime localDateTime, boolean active) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.hash = hash;
        this.coordinate = coordinate;
        this.user = user;
        this.localDateTime = localDateTime;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "DirectionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", hash=" + hash +
                ", coordinate=" + coordinate +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", active=" + active +
                '}';
    }
}
