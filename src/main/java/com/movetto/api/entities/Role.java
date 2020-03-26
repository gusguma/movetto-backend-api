package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public enum Role {

    ADMIN,USER,CUSTOMER,PARTNER;

    public String roleName(){
        return "ROLE_" + this.toString();
    }
}
