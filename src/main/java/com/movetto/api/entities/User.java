package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Direction> directions;

    @ManyToMany
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private LocalDateTime registrationDate;
    private Boolean active;

    public User() {
        this.registrationDate = LocalDateTime.now();
        this.active = true;
        this.directions = new HashSet<>();
        directions.add(new Direction
                ("","","","","","")
        );
        this.roles = new HashSet<>();
        roles.add(Role.USER);
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

    public Set<Direction> getDirections() {
        return directions;
    }

}
