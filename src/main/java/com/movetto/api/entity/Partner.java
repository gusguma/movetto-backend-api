package com.movetto.api.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Partner extends User {

    @Column(unique = true, nullable = false)
    private String partnerId;
    @Column(unique = true, nullable = false)
    private String driverId;

    public Partner() {
        //Empty for Framework
    }

    public Partner(String nip, String driverId) {
        this.partnerId = nip;
        this.driverId = driverId;
    }

    public String getNip() {
        return partnerId;
    }

    public String getDriverId() {
        return driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partner)) return false;
        Partner partner = (Partner) o;
        return partnerId.equals(partner.partnerId) &&
                getDriverId().equals(partner.getDriverId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerId, getDriverId());
    }

    @Override
    public String toString() {
        return "Partner{" +
                "partnerId='" + partnerId + '\'' +
                ", driverId='" + driverId + '\'' +
                '}';
    }
}
