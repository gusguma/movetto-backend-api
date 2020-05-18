package com.movetto.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.movetto.api.entities.Customer;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.ShipmentStatus;
import com.movetto.api.entities.User;
import com.movetto.api.entities.Package;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentDto extends ServiceDto {
    private LocalDateTime shipmentDatetimeLimit;
    private double minimumPrice;
    private double priceShipment;
    private ShipmentStatus status;
    private Set<Package> packages;
    private User destinationUser;

    public ShipmentDto() {
        super();
        this.minimumPrice = 5.00;
        this.status = ShipmentStatus.SAVED;
    }

    public ShipmentDto(User customer, Direction start, Direction finish, User destinationUser) {
        super(customer,start,finish);
        this.destinationUser = destinationUser;
        this.shipmentDatetimeLimit = LocalDateTime.now().plusDays(5);
        this.packages = new HashSet<>();
    }

    public LocalDateTime getShipmentDatetimeLimit() {
        return shipmentDatetimeLimit;
    }

    public void setShipmentDatetimeLimit(LocalDateTime shipmentDatetimeLimit) {
        this.shipmentDatetimeLimit = shipmentDatetimeLimit;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public double getPriceShipment() {
        return priceShipment;
    }

    public void setPriceShipment(double priceShipment) {
        this.priceShipment = priceShipment;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public User getDestinationUser() {
        return destinationUser;
    }

    public void setDestinationUser(User destinationUser) {
        this.destinationUser = destinationUser;
    }

    @Override
    public String toString() {
        return "ShipmentDto{" +
                "shipmentDatetimeLimit=" + shipmentDatetimeLimit +
                ", minimumPrice=" + minimumPrice +
                ", priceShipment=" + priceShipment +
                ", status=" + status +
                ", packages=" + packages +
                ", destinationUser=" + destinationUser +
                '}';
    }
}

