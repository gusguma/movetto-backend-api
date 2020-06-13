package com.movetto.api.entities;

public enum ShipmentStatus {

    SAVED, ACCEPTED, PAID, COLLECTED, TRANSIT, DETAINED, DELIVERED, DELETED, FINISHED;

    public String shipmentStatusName(){
        return "SHIPMENT_STATUS_" + this.toString();
    }

}
