package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Shipment extends Service {

    private LocalDateTime shipmentDatetimeLimit;
    private double minimumPrice;
    private double priceShipment;

    @Enumerated(value = EnumType.STRING)
    private ShipmentStatus status;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Package> packages;

    public Shipment() {
        super();
        this.minimumPrice = 5.00;
    }

    public Shipment(Customer customer,Direction start,Direction finish) {
        super(customer,start,finish);
        this.shipmentDatetimeLimit = LocalDateTime.now().plusDays(5);
        this.packages = new HashSet<>();
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

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentDatetimeLimit=" + shipmentDatetimeLimit +
                ", minimumPrice=" + minimumPrice +
                ", priceShipment=" + priceShipment +
                ", status=" + status +
                ", packages=" + packages +
                '}';
    }
}
