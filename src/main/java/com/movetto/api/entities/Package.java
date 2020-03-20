package com.movetto.api.entities;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public Package() {
        //Empty for Framework
    }

    public Package(double weight, double width, double lenght, double high){
        this.weight = weight;
        this.width = width;
        this.lenght = lenght;
        this.high = high;
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
}
