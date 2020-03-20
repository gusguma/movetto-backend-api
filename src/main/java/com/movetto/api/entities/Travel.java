package com.movetto.api.entities;

import javax.persistence.*;

@Entity
public class Travel {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Direction start;
    @OneToOne
    private Direction finish;
    @Column(nullable = false)
    private int people;
    @Column(nullable = false)
    private double price;

    public Travel(){
        //Empty for Framework
    }

    public Travel(Direction start, Direction finish, int people, double price){
        this.start = start;
        this.finish = finish;
        this.people = people;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Direction getStart() {
        return start;
    }

    public Direction getFinish() {
        return finish;
    }

    public int getPeople() {
        return people;
    }

    public double getPrice() {
        return price;
    }
}
