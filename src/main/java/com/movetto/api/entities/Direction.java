package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Direction {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private int hash;

    @Embedded
    private Coordinate coordinate;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Service> services;

    private LocalDateTime registrationDate;
    private boolean active;

    public Direction() {
        this.name = "default";
        this.hash = hashCode();
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Direction(String street, String postalCode, String city,
                     String state, String country, Coordinate coordinate,
                     User user) {
        this();
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.coordinate = coordinate;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return getId() == direction.getId() &&
                getHash() == direction.getHash() &&
                isActive() == direction.isActive() &&
                getName().equals(direction.getName()) &&
                Objects.equals(getStreet(), direction.getStreet()) &&
                Objects.equals(getPostalCode(), direction.getPostalCode()) &&
                Objects.equals(getCity(), direction.getCity()) &&
                Objects.equals(getState(), direction.getState()) &&
                Objects.equals(getCountry(), direction.getCountry()) &&
                Objects.equals(getCoordinate(), direction.getCoordinate()) &&
                Objects.equals(getUser(), direction.getUser()) &&
                Objects.equals(getServices(), direction.getServices()) &&
                Objects.equals(getRegistrationDate(), direction.getRegistrationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getPostalCode(), getCity(),
                getState(), getCountry(), getHash(), getCoordinate(), getUser(),
                getServices(), getRegistrationDate(), isActive());
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", hash=" + hash +
                ", coordinate=" + coordinate +
                ", user=" + user +
                ", services=" + services +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
