package com.movetto.api.dtos;

import com.movetto.api.entities.Coordinate;
import com.movetto.api.entities.DirectionType;
import com.movetto.api.entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class DirectionDto {

    @NotNull
    private int id;
    private String street;
    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.POSTAL_CODE)
    private String postalCode;
    private String city;
    private String state;
    private String country;
    @NotNull
    private DirectionType directionType;

    private Coordinate coordinate;

    private LocalDateTime registrationDate;
    private boolean active;

    public DirectionDto(){
        directionType = DirectionType.USER;
        //Empty for Framework
    }

    public DirectionDto(@NotNull DirectionType directionType){
        this.directionType = directionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
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

}
