package com.movetto.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.TravelStatus;
import com.movetto.api.entities.User;

import java.time.Duration;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TravelDto extends ServiceDto {

    private int people;
    private double distance;
    private double minimumPrice;
    private double priceHour;
    private double priceKm;
    private double priceTravel;
    private LocalDateTime start;
    private LocalDateTime end;
    private TravelStatus status;

    public TravelDto(){
        super();
        this.minimumPrice = 2.40;
        this.priceHour = 20.50;
        this.priceKm = 1.05;
        this.people = 1;
        this.status = TravelStatus.SAVED;
    }

    public TravelDto(User customer,Direction startDirection, Direction endDirection) {
        super(customer, startDirection, endDirection);
        this.minimumPrice = 2.40;
        this.priceHour = 20.50;
        this.priceKm = 1.05;
        this.people = 1;
        this.status = TravelStatus.SAVED;
    }

    private long getTravelDuration(){
        return Duration.between(start,end).toHours();
    }

    private double getTravelPriceHours(){
        return getTravelDuration() * priceHour;
    }

    private double getTravelPriceDistance(){
        return distance * priceKm;
    }

    public void setTravelPrice(){
        priceTravel = Math.max(getTravelPriceDistance(), getTravelPriceHours());
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

    public double getPriceTravel() {
        return priceTravel;
    }

    public void setPriceTravel(double priceTravel) {
        this.priceTravel = priceTravel;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public TravelStatus getStatus() {
        return status;
    }

    public void setStatus(TravelStatus status) {
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
