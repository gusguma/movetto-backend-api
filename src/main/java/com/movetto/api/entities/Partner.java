package com.movetto.api.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class Partner {

    @Column(unique = true)
    private String partnerId;
    @Column(unique = true)
    private String driverId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public Partner() {
        //Empty for Framework
    }

    public Partner(User user) {
        this.partnerId = user.getPartner().partnerId;
        this.driverId = user.getPartner().driverId;
        this.vehicles = new HashSet<Vehicle>();
        user.getRoles().add(Role.PARTNER);
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "partnerId='" + partnerId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
