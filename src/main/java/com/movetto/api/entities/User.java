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

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private LocalDateTime registrationDate;
    private Boolean active;

    public User() {
        this.registrationDate = LocalDateTime.now();
        this.active = true;
        this.roles = new HashSet<>();
        roles.add(Role.USER);
    }

    public User(String displayName, String email, String uid) {
        this();
        this.displayName = displayName;
        this.email = email;
        this.uid = uid;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
                Objects.equals(getCustomerId(), user.getCustomerId()) &&
                Objects.equals(getPartnerId(), user.getPartnerId()) &&
                Objects.equals(getDriverId(), user.getDriverId()) &&
                Objects.equals(getRoles(), user.getRoles()) &&
                Objects.equals(getRegistrationDate(), user.getRegistrationDate()) &&
                Objects.equals(isActive(), user.isActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDisplayName(), getEmail(), getUid(),
                getPhone(), getCustomerId(), getPartnerId(), getDriverId(),
                getRoles(), getRegistrationDate(), isActive());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", customerId='" + customerId + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", roles=" + roles +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
