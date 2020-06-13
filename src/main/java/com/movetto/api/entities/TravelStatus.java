package com.movetto.api.entities;

public enum TravelStatus {

    SAVED, PAID, ACCEPTED, PICKED_UP, TRANSIT, DETAINED, FINISHED, DELETED;

    public String travelStatusName(){
        return "TRAVEL_STATUS_" + this.toString();
    }
}
