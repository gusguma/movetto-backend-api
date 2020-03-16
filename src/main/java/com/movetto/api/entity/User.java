package com.movetto.api.entity;

import javax.persistence.*;
import java.util.Objects;

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
    private String phone;

    @Column(nullable = false)
    private String uid;

    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private String nif;

    public User() {
        //Empty for framework
    }

    public User(String displayName, String email, String phone, String uid) {
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public String getUid() {
        return uid;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getNif() {
        return nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getDisplayName().equals(user.getDisplayName()) &&
                getEmail().equals(user.getEmail()) &&
                getPhone().equals(user.getPhone()) &&
                getUid().equals(user.getUid()) &&
                Objects.equals(getStreet(), user.getStreet()) &&
                Objects.equals(getPostalCode(), user.getPostalCode()) &&
                Objects.equals(getCity(), user.getCity()) &&
                Objects.equals(getState(), user.getState()) &&
                Objects.equals(getCountry(), user.getCountry()) &&
                Objects.equals(getNif(), user.getNif());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDisplayName(), getEmail(), getPhone(),
                getUid(), getStreet(), getPostalCode(), getCity(), getState(),
                getCountry(), getNif());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", uid='" + uid + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}
