package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String displayName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String uid;
    @Column(unique = true)
    private String phone;

    @Embedded
    private Customer customer;
    @Embedded
    private Partner partner;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Direction> directions;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

    private LocalDateTime registrationDate;
    private Boolean active;

    public User() {
        this.roles = new HashSet<>();
        roles.add(Role.USER);
        this.directions = new HashSet<>();
        this.vehicles = new HashSet<>();
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public User(String displayName, String email, String uid) {
        this();
        this.displayName = displayName;
        this.email = email;
        this.uid = uid;
    }

    public Builder builder(){
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public void setDirections(Set<Direction> directions) {
        this.directions = directions;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getDisplayName().equals(user.getDisplayName()) &&
                getEmail().equals(user.getEmail()) &&
                getUid().equals(user.getUid()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getCustomer(), user.getCustomer()) &&
                Objects.equals(getPartner(), user.getPartner()) &&
                Objects.equals(getRoles(), user.getRoles()) &&
                Objects.equals(getDirections(), user.getDirections()) &&
                Objects.equals(getVehicles(), user.getVehicles()) &&
                Objects.equals(getRegistrationDate(), user.getRegistrationDate()) &&
                Objects.equals(active, user.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDisplayName(), getEmail(), getUid(), getPhone(),
                getCustomer(), getPartner(), getRoles(), getDirections(), getVehicles(),
                getRegistrationDate(), active);
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
                ", roles=" + roles +
                ", directions=" + directions +
                ", vehicles=" + vehicles +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }

    public static class Builder {

        private User user;

        private Builder(){
            this.user = new User();
        }

        public Builder displayName(String displayName){
            this.user.setDisplayName(displayName);
            return this;
        }

        public Builder email (String email){
            this.user.setEmail(email);
            return this;
        }

        public Builder uid (String uid){
            this.user.setEmail(uid);
            return this;
        }

        public Builder phone (String phone){
            this.user.setEmail(phone);
            return this;
        }

        public Builder customer (Customer customer){
            this.user.setCustomer(customer);
            return this;
        }

        public Builder partner (Partner partner){
            this.user.setPartner(partner);
            return this;
        }

        public Builder roles (Set<Role> roles){
            this.user.roles = roles;
            return this;
        }

        public Builder directions (Set<Direction> directions){
            this.user.directions = directions;
            return this;
        }

        public Builder vehicles (Set<Vehicle> vehicles){
            this.user.vehicles = vehicles;
            return this;
        }

        public Builder registrationDate(LocalDateTime registrationDate){
            this.user.registrationDate = registrationDate;
            return this;
        }

        public User build (){
            return this.user;
        }
    }
}
