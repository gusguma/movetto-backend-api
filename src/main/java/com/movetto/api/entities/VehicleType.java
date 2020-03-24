package com.movetto.api.entities;

public enum VehicleType {
    BIKE,MOTORCYCLE,CAR,VAN;

    public String vehicleTypeName(){
        return "VEHICLE_TYPE_" + this.toString();
    }
}
