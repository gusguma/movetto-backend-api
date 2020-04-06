package com.movetto.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.movetto.api.entities.*;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Set;


@JsonInclude(Include.NON_NULL)
public class UserDto extends UserMinimumDto {

    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.MOBILE_NUMBER)
    private String phone;

    private Customer customer;
    private Partner partner;

    private Set<Role> roles;
    private Set<Direction> directions;

    private LocalDateTime registrationDate;
    private boolean active;

    public UserDto() {
        //Empty for Framework
    }

    public UserDto(User user) {
        super(user.getDisplayName(), user.getEmail(), user.getUid());
        this.phone = user.getPhone();
        this.customer = user.getCustomer();
        this.partner = user.getPartner();
        this.roles = user.getRoles();
        this.directions = user.getDirections();
        this.registrationDate = user.getRegistrationDate();
        this.active = user.isActive();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public void setDirections(Set<Direction> directions) {
        this.directions = directions;
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
        return "UserDto{" +
                "phone='" + phone + '\'' +
                ", customer=" + customer +
                ", partner=" + partner +
                ", roles=" + roles +
                ", directions=" + directions +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
