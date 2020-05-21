package com.movetto.api.entities;

public enum ShipmentStatus {

    SAVED, PREPARED, ACCEPTED, COLLECTED, TRANSIT, DETAINED, DELIVERED, DELETED;

    public String shipmentStatusName(){
        return "SHIPMENT_STATUS_" + this.toString();
    }

}
