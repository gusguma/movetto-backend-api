package com.movetto.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends User {

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true, nullable = false)
    private String nip;


}
