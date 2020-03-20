package com.movetto.api.entities;

public enum VehicleType {
    BIKE(1),MOTORCYCLE(2),CAR(3),VAN(4);
    private int vehicleType;

    private VehicleType (int vehicleType){
        this.vehicleType = vehicleType;
    }
}
