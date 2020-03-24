package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum Role {

    ADMIN, CUSTOMER, PARTNER, USER;

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public String roleName(){
        return this.name = toString();
    }
}
