package com.movetto.api.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class ServiceType extends Service {

    private String description;
    private double price;

    @Enumerated(value = EnumType.STRING)
    private ServiceTypeEnum serviceTypeEnum;

    public ServiceType() {
        super();
        this.description = "";
        this.price = 0.0;
    }

    public ServiceType(Customer customer, Partner partner, Vehicle vehicle,
                       Direction start, Direction finish) {
        super(customer, partner, vehicle, start, finish);
        this.description = "";
        this.price = 0.0;
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

    public ServiceTypeEnum getServiceType() {
        return serviceTypeEnum;
    }

    public void setServiceType(ServiceTypeEnum serviceTypeEnum) {
        this.serviceTypeEnum = serviceTypeEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceType)) return false;
        if (!super.equals(o)) return false;
        ServiceType that = (ServiceType) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getServiceType() == that.getServiceType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDescription(),
                getPrice(), getServiceType());
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", serviceType=" + serviceTypeEnum +
                '}';
    }
}
