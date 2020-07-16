package com.movetto.api.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToDoubleFunction;

@Entity
public class Wallet {

    @Id
    @GeneratedValue
    private int id;
    private double balance;

    @OneToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    private LocalDateTime registrationDate;
    private boolean active;

    public Wallet () {
        this.balance = 0;
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Wallet(User user) {
        this();
        this.user = user;
        this.transactions = new HashSet<>();
    }

    public void calculateBalance(){
        this.balance = transactions.stream()
                .mapToDouble(Transaction::getAmount).sum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
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
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", balance=" + balance +
                ", user=" + user +
                ", transactions=" + transactions +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
