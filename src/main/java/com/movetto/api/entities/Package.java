package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Package {

    @Id
    @GeneratedValue
    private int id;
    private double weight;
    private double width;
    private double lenght;
    private double high;

    @Enumerated(value = EnumType.STRING)
    private PackageStatus status;

    private LocalDateTime registrationDate;
    private boolean active;

    public Package() {
        this.status = PackageStatus.PREPARED;
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Package(double weight, double width, double lenght, double high){
        this();
        this.weight = weight;
        this.width = width;
        this.lenght = lenght;
        this.high = high;
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

    public double getVolume(){
        return width * lenght * high;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Package)) return false;
        Package aPackage = (Package) o;
        return getId() == aPackage.getId() &&
                Double.compare(aPackage.getWeight(), getWeight()) == 0 &&
                Double.compare(aPackage.getWidth(), getWidth()) == 0 &&
                Double.compare(aPackage.getLenght(), getLenght()) == 0 &&
                Double.compare(aPackage.getHigh(), getHigh()) == 0 &&
                getStatus() == aPackage.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWeight(), getWidth(), getLenght(),
                getHigh(), getStatus());
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", weight=" + weight +
                ", width=" + width +
                ", lenght=" + lenght +
                ", high=" + high +
                ", status=" + status +
                '}';
    }
}
