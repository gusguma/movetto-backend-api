package com.movetto.api.entities;

public enum Role {

    ADMIN,USER,CUSTOMER,PARTNER, DESTINATION;

    public String roleName(){
        return "ROLE_" + this.toString();
    }
}
