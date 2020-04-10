package com.movetto.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Embeddable
public class Partner {

    @Column(unique = true)
    private String partnerId;
    @Column(unique = true)
    private String driverId;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

    public Partner() {
        //Empty for Framework
    }

    public Partner(User user) {
        this.partnerId = user.getPartner().partnerId;
        this.driverId = user.getPartner().driverId;
        this.vehicles = new HashSet<>();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partner)) return false;
        Partner partner = (Partner) o;
        return Objects.equals(getPartnerId(), partner.getPartnerId()) &&
                Objects.equals(getDriverId(), partner.getDriverId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPartnerId(), getDriverId());
    }

    @Override
    public String toString() {
        return "Partner{" +
                "partnerId='" + partnerId + '\'' +
                ", driverId='" + driverId + '\'' +
                '}';
    }
}
