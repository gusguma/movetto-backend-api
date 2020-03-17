package com.movetto.api.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    @Embedded
    private Customer customer;

    @Embedded
    private Partner partner;

    @OneToMany
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

    public Customer getCustomer() {
        return customer;
    }

    public Partner getPartner() {
        return partner;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                displayName.equals(user.displayName) &&
                email.equals(user.email) &&
                uid.equals(user.uid) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(customer, user.customer) &&
                Objects.equals(partner, user.partner) &&
                Objects.equals(directions, user.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, email, uid, phone, customer, partner, directions);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", customer=" + customer +
                ", partner=" + partner +
                ", directions=" + directions +
                '}';
    }
}
