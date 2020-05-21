package com.movetto.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Payment.class, name = "Payment"),
        @JsonSubTypes.Type(value = Deposit.class, name = "Deposit")
})
public abstract class Transaction {

    @Id
    @GeneratedValue
    private int id;
    private double amount;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;

    private LocalDateTime registrationDate;
    private boolean active;

    public Transaction(){
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Transaction(double amount) {
        this();
        this.status = TransactionStatus.CREATED;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
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
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", status=" + status +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
