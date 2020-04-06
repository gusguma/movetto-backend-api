package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Travel extends ServiceType {

    private int people;
    private LocalDateTime travelDatetime;

    public Travel(){
        this.people = 1;
        setServiceType(ServiceTypeEnum.TRAVEL);
    }

    public Travel(int people, LocalDateTime travelDatetime){
        this();
        this.people = people;
        this.travelDatetime = travelDatetime;
    }

    public Travel(Direction startDirection, Direction endDirection,
                  Vehicle vehicle, Customer customer, Partner partner) {
        super(customer, partner, vehicle);
        setStartDirection(startDirection);
        setEndDirection(endDirection);
    }


}
