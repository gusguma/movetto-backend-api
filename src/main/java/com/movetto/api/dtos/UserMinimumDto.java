package com.movetto.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserMinimumDto {

    @NotNull(message = "uid no puede ser nulo")
    private String uid;
    @Email(message = "Debe introducir un Email Válido")
    private String email;

    public UserMinimumDto(){
        this("","");
    }

    public UserMinimumDto(String uid, String email){
        this.uid = uid;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserMinimumDto{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
