package com.movetto.api.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Customer extends User {

    @Column(unique = true, nullable = false)
    private String customerId;

    public Customer() {
        //Empty for framework
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public String getNip() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                '}';
    }
}
