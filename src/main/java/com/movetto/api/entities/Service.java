package com.movetto.api.entities;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Service {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Direction startDirection;
    @ManyToOne
    private Direction endDirection;
    @Embedded
    private Customer customer;
    @Embedded
    private Partner partner;
    @OneToOne
    private Vehicle vehicle;

    private LocalDateTime registrationDate;
    private Boolean active;

    public Service() {
        //Empty for Framework
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Service(Customer customer, Partner partner, Vehicle vehicle){
        this();
        this.customer = customer;
        this.partner = partner;
        this.vehicle = vehicle;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direction getStartDirection() {
        return startDirection;
    }

    public void setStartDirection(Direction startDirection) {
        this.startDirection = startDirection;
    }

    public Direction getEndDirection() {
        return endDirection;
    }

    public void setEndDirection(Direction endDirection) {
        this.endDirection = endDirection;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return getId() == service.getId() &&
                getStartDirection().equals(service.getStartDirection()) &&
                getEndDirection().equals(service.getEndDirection()) &&
                getCustomer().equals(service.getCustomer()) &&
                getPartner().equals(service.getPartner()) &&
                getVehicle().equals(service.getVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDirection(), getEndDirection(),
                getCustomer(), getPartner(), getVehicle());
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", startDirection=" + startDirection +
                ", endDirection=" + endDirection +
                ", customer=" + customer +
                ", partner=" + partner +
                ", vehicle=" + vehicle +
                '}';
    }
}
