package com.movetto.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import java.util.Set;

@JsonInclude(Include.NON_NULL)
public class UserDto extends UserMinimumDto {

    private String displayName;
    private String phone;
    private Set<Direction> directions;
    private Set<Role> roles;

    public UserDto(){
        //Empty for framework
    }

    public UserDto(User user) {
        super(user.getUid(),user.getEmail());
        this.displayName = user.getDisplayName();
        this.phone = user.getPhone();
        this.directions = user.getDirections();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public void setDirections(Set<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "displayName='" + displayName + '\'' +
                ", phone='" + phone + '\'' +
                ", directions=" + directions +
                '}';
    }
}
