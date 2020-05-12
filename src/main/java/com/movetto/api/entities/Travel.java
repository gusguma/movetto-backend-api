package com.movetto.api.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Travel extends Service {

    private int people;
    private double distance;
    private double minimumPrice;
    private double priceHour;
    private double priceKm;
    private double priceTravel;
    private Date start;
    private Date end;

    @Enumerated(value = EnumType.STRING)
    private ShipmentStatus status;

    public Travel(){
        super();
        this.minimumPrice = 2.40;
        this.priceHour = 20.50;
        this.priceKm = 1.05;
        this.people = 1;
    }

    public Travel(Customer customer,Direction startDirection, Direction endDirection) {
        super(customer, startDirection, endDirection);
        this.people = 1;
    }

    public double getTravelDuration(){
        double diference = end.getTime() - start.getTime();
        diference /= 3600000;
        return diference;
    }

    public double getTravelPriceHours(){
        return getTravelDuration() * priceHour;
    }

    public double getTravelPriceDistance(){
        return distance * priceKm;
    }

    public void setTravelPrice(){
        priceTravel = Math.max(getTravelPriceDistance(), getTravelPriceHours());
    }

    public void setPriceTravel(double priceTravel) {
        this.priceTravel = priceTravel;
    }

    public double getPriceTravel() {
        return priceTravel;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(double priceHour) {
        this.priceHour = priceHour;
    }

    public double getPriceKm() {
        return priceKm;
    }

    public void setPriceKm(double priceKm) {
        this.priceKm = priceKm;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "people=" + people +
                ", distance=" + distance +
                ", minimumPrice=" + minimumPrice +
                ", priceHour=" + priceHour +
                ", priceKm=" + priceKm +
                ", priceTravel=" + priceTravel +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                '}';
    }
}
