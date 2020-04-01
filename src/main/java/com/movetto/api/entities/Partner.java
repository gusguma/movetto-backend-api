package com.movetto.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Embeddable
public class Partner extends User {

    @Column(unique = true)
    private String partnerId;
    @Column(unique = true)
    private String driverId;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

}
