package com.movetto.api.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Deposit extends Transaction {

    @ManyToOne
    private Card card;

    public Deposit(){
        super();
    }

    public Deposit(double amount, Card card){
        super(amount);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "card=" + card +
                '}';
    }
}
