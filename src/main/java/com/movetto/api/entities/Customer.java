package com.movetto.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Customer implements Serializable {

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
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                '}';
    }
}
