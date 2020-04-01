package com.movetto.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Partner {

    @Column(unique = true)
    private String partnerId;
    @Column(unique = true)
    private String driverId;

    public Partner() {
        //Empty for Framework
    }

    public Partner(User user) {
        this.partnerId = user.getPartner().partnerId;
        this.driverId = user.getPartner().driverId;
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
