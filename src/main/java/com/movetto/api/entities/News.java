package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class News {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String subtitle;
    private String shortDescription;
    private String largeDescription;
    private String urlImage;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Tag> labels;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;

    private LocalDateTime registrationDate;
    private boolean active;

    public News() {
        title = "";
        subtitle = "";
        shortDescription = "";
        largeDescription = "";
        urlImage = "";
        labels = new HashSet<Tag>();
        users = new HashSet<User>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLargeDescription() {
        return largeDescription;
    }

    public void setLargeDescription(String largeDescription) {
        this.largeDescription = largeDescription;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<Tag> getLabels() {
        return labels;
    }

    public void setLabels(Set<Tag> labels) {
        this.labels = labels;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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



}
