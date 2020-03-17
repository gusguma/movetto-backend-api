package com.movetto.api.entity;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Coordinate {
    @Id
    @GeneratedValue
    private int id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return id == that.id &&
                Double.compare(that.getLatitude(), getLatitude()) == 0 &&
                Double.compare(that.getLongitude(), getLongitude()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getLatitude(), getLongitude());
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
