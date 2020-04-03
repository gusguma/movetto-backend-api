package com.movetto.api.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ServiceType extends Service {

    private String description;

}
