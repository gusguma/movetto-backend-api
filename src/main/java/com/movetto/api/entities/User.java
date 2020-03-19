package com.movetto.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String displayName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String uid;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String customerId;

    @Column(unique = true)
    private String partnerId;

    @Column(unique = true)
    private String driverId;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private List<Direction> directions;

    public User() {
        //Empty for framework
    }

    public User(String displayName, String email, String uid) {
        this.displayName = displayName;
        this.email = email;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }

    public String getPhone() {
        return phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getDriverId() {
        return driverId;
    }

    public List<Direction> getDirections() {
        return directions;
    }

}
