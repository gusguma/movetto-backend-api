package com.movetto.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Customer {

    @Column(unique = true)
    private String customerId;

    public Customer() {
        //Empty for Framework
    }

    public Customer(User user) {
        this.customerId = user.getCustomer().customerId;
        user.getRoles().add(Role.CUSTOMER);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCustomerId(), customer.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCustomerId());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                '}';
    }
}
