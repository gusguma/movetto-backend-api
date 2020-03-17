package com.movetto.api.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getDisplayName().equals(user.getDisplayName()) &&
                getEmail().equals(user.getEmail()) &&
                getUid().equals(user.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDisplayName(), getEmail(), getUid());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
