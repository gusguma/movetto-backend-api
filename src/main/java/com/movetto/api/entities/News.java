package com.movetto.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class News {

    @Id
    @GeneratedValue
    private int id;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;







}
