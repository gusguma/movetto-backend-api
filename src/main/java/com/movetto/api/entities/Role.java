package com.movetto.api.entities;

public enum Role {

    ADMIN,USER,CUSTOMER,PARTNER;

    public String roleName(){
        return "ROLE_" + this.toString();
    }
}
