package com.movetto.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Package implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private double weight;
    private double width;
    private double lenght;
    private double high;
    private double pricePackage;
    private double weightVolume;

    @Enumerated(value = EnumType.STRING)
    private PackageStatus status;

    private LocalDateTime registrationDate;
    private boolean active;

    public Package() {
        this.status = PackageStatus.SAVED;
        this.weightVolume = 333;
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Package(double weight, double width, double lenght, double high){
        this();
        this.weight = weight;
        this.width = width;
        this.lenght = lenght;
        this.high = high;
        this.setPackagePrice();
    }

    public double getPackageVolume(){
       return (width * lenght * high) / 1000000;
    }

    public double getPackageWeightVolume(){
        return getPackageVolume() * weightVolume;
    }

    public void setPackagePrice(){
        if (getPackageWeightVolume() > weight){
            pricePackage = 0.3 * getPackageWeightVolume();
        } else {
            pricePackage = 0.3 * weight;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getPricePackage() {
        return pricePackage;
    }

    public void setPricePackage(double price) {
        this.pricePackage = price;
    }

    public double getWeightVolume() {
        return weightVolume;
    }

    public void setWeightVolume(double weightVolume) {
        this.weightVolume = weightVolume;
    }

    public PackageStatus getStatus() {
        return status;
    }

    public void setStatus(PackageStatus status) {
        this.status = status;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", weight=" + weight +
                ", width=" + width +
                ", lenght=" + lenght +
                ", high=" + high +
                ", price=" + pricePackage +
                ", weightVolume=" + weightVolume +
                ", status=" + status +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
