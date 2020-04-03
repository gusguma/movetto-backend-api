package com.movetto.api.entities;

import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Service extends AbstractAuditable {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Direction startDirection;
    @OneToOne
    private Direction endDirection;
    @Embedded
    private Customer customer;
    @Embedded
    private Partner partner;
    @OneToOne
    private Vehicle vehicle;

    public Service() {
        //Empty for Framework
    }

}
