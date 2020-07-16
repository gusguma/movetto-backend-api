package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToDoubleFunction;

@Entity
public class Shipment extends Service {

    private LocalDateTime shipmentDatetimeLimit;
    private double minimumPrice;
    private double priceShipment;

    @Enumerated(value = EnumType.STRING)
    private ShipmentStatus status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Package> packages;

    @ManyToOne
    private User destinationUser;

    public Shipment() {
        super();
        this.minimumPrice = 5.00;
        this.status = ShipmentStatus.SAVED;
    }

    public Shipment(User customer,Direction start,Direction finish, User destinationUser) {
        super(customer,start,finish);
        this.destinationUser = destinationUser;
        this.shipmentDatetimeLimit = LocalDateTime.now().plusDays(5);
        this.packages = new HashSet<>();
        this.status = ShipmentStatus.SAVED;
        this.minimumPrice = 5.00;
    }

    public void setShipmentPrice(){
        priceShipment = this.getMinimumPrice() + this.getPackages().stream()
                .mapToDouble(Package::getPricePackage)
                .sum();
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
        return "Shipment{" +
                "shipmentDatetimeLimit=" + shipmentDatetimeLimit +
                ", minimumPrice=" + minimumPrice +
                ", priceShipment=" + priceShipment +
                ", status=" + status +
                ", packages=" + packages +
                ", destinationUser=" + destinationUser +
                '}';
    }
}
