package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Charge extends Transaction{

    @ManyToOne
    private Service service;

    public Charge(){
        super();
    }

    public Charge(double amount, Service service){
        super(amount);
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "service=" + service +
                '}';
    }
}
