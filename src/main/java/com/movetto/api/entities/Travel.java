package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Travel extends ServiceType {

    private int people;
    private LocalDateTime travelDatetime;

    public Travel(){
        super();
        this.people = 1;
        setServiceType(ServiceTypeEnum.TRAVEL);
        this.travelDatetime = LocalDateTime.now().plusDays(1);
    }

    public Travel(Direction startDirection, Direction endDirection,
                  Vehicle vehicle, Customer customer, Partner partner) {
        super(customer, partner, vehicle, startDirection, endDirection);
        this.people = 1;
        setServiceType(ServiceTypeEnum.TRAVEL);
        this.travelDatetime = LocalDateTime.now().plusDays(1);
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public LocalDateTime getTravelDatetime() {
        return travelDatetime;
    }

    public void setTravelDatetime(LocalDateTime travelDatetime) {
        this.travelDatetime = travelDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Travel)) return false;
        if (!super.equals(o)) return false;
        Travel travel = (Travel) o;
        return getPeople() == travel.getPeople() &&
                Objects.equals(getTravelDatetime(), travel.getTravelDatetime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPeople(), getTravelDatetime());
    }

    @Override
    public String toString() {
        return "Travel{" +
                "people=" + people +
                ", travelDatetime=" + travelDatetime +
                '}';
    }
}
