package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Shipment extends ServiceType {

    private LocalDateTime shipmentDatetimeLimit;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Package> packages;

    public Shipment() {
        this.shipmentDatetimeLimit = LocalDateTime.now().plusDays(5);
        setServiceType(ServiceTypeEnum.SHIPMENT);
    }

    public Shipment(Customer customer, Partner partner, Vehicle vehicle,
                    Direction start, Direction finish) {
        super(customer, partner, vehicle, start, finish);
        this.shipmentDatetimeLimit = LocalDateTime.now().plusDays(5);
        setServiceType(ServiceTypeEnum.SHIPMENT);
    }

    public LocalDateTime getShipmentDatetimeLimit() {
        return shipmentDatetimeLimit;
    }

    public void setShipmentDatetimeLimit(LocalDateTime shipmentDatetimeLimit) {
        this.shipmentDatetimeLimit = shipmentDatetimeLimit;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shipment)) return false;
        if (!super.equals(o)) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(getShipmentDatetimeLimit(), shipment.getShipmentDatetimeLimit()) &&
                Objects.equals(getPackages(), shipment.getPackages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getShipmentDatetimeLimit(), getPackages());
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentDatetimeLimit=" + shipmentDatetimeLimit +
                ", packages=" + packages +
                '}';
    }
}
