package com.movetto.api.dtos;

import com.movetto.api.entities.Transaction;
import com.movetto.api.entities.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class WalletDto {

    private int id;
    private double balance;
    private User user;
    private Set<Transaction> transactions;
    private LocalDateTime registrationDate;
    private boolean active;

    public WalletDto () {
        this.balance = 0;
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public WalletDto(User user) {
        this();
        this.user = user;
        this.transactions = new HashSet<Transaction>();
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
        return "WalletDto{" +
                "id=" + id +
                ", balance=" + balance +
                ", user=" + user +
                ", transactions=" + transactions +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
