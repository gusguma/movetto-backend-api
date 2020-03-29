package com.movetto.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import com.movetto.api.entities.Vehicle;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Set;

@JsonInclude(Include.NON_NULL)
public class UserDto extends UserMinimumDto {

    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.MOBILE_NUMBER)
    private String phone;
    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.REGISTER_ID )
    private String customerId;
    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.REGISTER_ID )
    private String partnerId;
    @Pattern(regexp = com.movetto.api.dtos.validations.Pattern.REGISTER_ID )
    private String driverId;

    private Set<Role> roles;
    private Set<Direction> directions;
    private Set<Vehicle> vehicles;

    private LocalDateTime registrationDate;
    private boolean active;

    public UserDto() {
        //Empty for Framework
    }

    public UserDto(User user) {
        super(user.getDisplayName(), user.getEmail(), user.getUid());
        this.phone = user.getPhone();
        this.customerId = user.getCustomerId();
        this.partnerId = user.getPartnerId();
        this.driverId = user.getDriverId();
        this.roles = user.getRoles();
        this.directions = user.getDirections();
        this.vehicles = user.getVehicles();
        this.registrationDate = user.getRegistrationDate();
        this.active = user.isActive();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
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
                ", customerId='" + customerId + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", roles=" + roles +
                ", directions=" + directions +
                ", vehicles=" + vehicles +
                ", registrationDate=" + registrationDate +
                ", active=" + active +
                '}';
    }
}
