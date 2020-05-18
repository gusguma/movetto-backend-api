package com.movetto.api.dtos;

import com.fasterxml.jackson.annotation.*;
import com.movetto.api.entities.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TravelDto.class, name = "Travel"),
        @JsonSubTypes.Type(value = ShipmentDto.class, name = "Shipment")
})

public abstract class ServiceDto implements Serializable {

    private int id;
    private String description;
    private double price;
    private User customer;
    private User partner;
    private Direction startDirection;
    private Direction endDirection;
    private Vehicle vehicle;
    private LocalDateTime registrationDate;
    private boolean active;

    public ServiceDto() {
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public ServiceDto(User customer
            , Direction startDirection, Direction endDirection){
        this();
        this.customer = customer;
        this.startDirection = startDirection;
        this.endDirection = endDirection;
    }

    public ServiceDto(User customer, User partner, Vehicle vehicle){
        this.customer = customer;
        this.partner = partner;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getPartner() {
        return partner;
    }

    public void setPartner(User partner) {
        this.partner = partner;
    }

    public Direction getStartDirection() {
        return startDirection;
    }

    public void setStartDirection(Direction startDirection) {
        this.startDirection = startDirection;
    }

    public Direction getEndDirection() {
        return endDirection;
    }

    public void setEndDirection(Direction endDirection) {
        this.endDirection = endDirection;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        return "ServiceDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", customer=" + customer +
                ", partner=" + partner +
                ", startDirection=" + startDirection +
                ", endDirection=" + endDirection +
                ", vehicle=" + vehicle +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
