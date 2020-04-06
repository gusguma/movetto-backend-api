package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Shipment extends ServiceType {

    private LocalDateTime shipmentDatetimeLimit;

    @OneToMany(mappedBy = "shipment", fetch = FetchType.EAGER)
    private Set<Package> packages;



}
