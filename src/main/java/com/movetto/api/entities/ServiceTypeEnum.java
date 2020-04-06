package com.movetto.api.entities;

public enum ServiceTypeEnum {

    SHIPMENT,TRAVEL;

    public String serviceTypeName(){
        return "SERVICE_TYPE_" + this.toString();
    }

}
