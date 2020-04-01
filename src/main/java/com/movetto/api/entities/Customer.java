package com.movetto.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Customer extends User {

    @Column(unique = true)
    private String customerId;



}
