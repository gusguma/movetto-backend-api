package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Payment extends Transaction {

    @ManyToOne
    private Service service;

    public Payment(){
        super();
    }

    public Payment(double amount, Service service){
        super(amount * -1);
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
        return "Payment{" +
                "service=" + service +
                '}';
    }
}
