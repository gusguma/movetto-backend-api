package com.movetto.api.entities;

import javax.persistence.*;

@Entity
public class Package {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private double width;
    @Column(nullable = false)
    private double lenght;
    @Column(nullable = false)
    private double high;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PackageStatus status;

    public Package() {
        //Empty for Framework
    }

    public Package(double weight, double width, double lenght, double high){
        this.weight = weight;
        this.width = width;
        this.lenght = lenght;
        this.high = high;
        this.status = PackageStatus.PREPARED;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getWidth() {
        return width;
    }

    public double getLenght() {
        return lenght;
    }

    public double getHigh() {
        return high;
    }

    public PackageStatus getStatus() {
        return status;
    }
}
