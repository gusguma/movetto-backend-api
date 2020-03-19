package com.movetto.api.entities;

import javax.persistence.*;

@Embeddable
public class Coordinate {

    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;

    public Coordinate(){
        //Empty for Framework
    }

    public Coordinate(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
