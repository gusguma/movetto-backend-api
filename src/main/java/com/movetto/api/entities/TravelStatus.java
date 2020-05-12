package com.movetto.api.entities;

public enum TravelStatus {

    SAVED, ACCEPTED, COLLECTED, TRANSIT, DETAINED, FINISHED, DELETED;

    public String shipmentStatusName(){
        return "SHIPMENT_STATUS_" + this.toString();
    }
}
