package com.movetto.api.entities;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Service {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private double price;

    @Embedded
    private Customer customer;
    @Embedded
    private Partner partner;

    @ManyToOne
    private Direction startDirection;
    @ManyToOne
    private Direction endDirection;
    @ManyToOne
    private Vehicle vehicle;

    private LocalDateTime registrationDate;
    private boolean active;

    public Service() {
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public Service(Customer customer
            ,Direction startDirection,Direction endDirection){
        this();
        this.customer = customer;
        this.startDirection = startDirection;
        this.endDirection = endDirection;
    }

    public void calculateServicePrice(Service service){
        if (service.getClass() == Shipment.class){
            calculateShipmentPrice((Shipment)service);
        }
        if (service.getClass() == Travel.class){
            calculateTravelPrice((Travel) service);
        }
    }

    private void calculateShipmentPrice(Shipment shipment){
        shipment.setShipmentPrice();
        price = shipment.getPriceShipment();
    }

    private void calculateTravelPrice(Travel travel){
        travel.setTravelPrice();
        price = travel.getPriceTravel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        return "Service{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", customer=" + customer +
                ", partner=" + partner +
                ", startDirection=" + startDirection +
                ", endDirection=" + endDirection +
                ", vehicle=" + vehicle +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
