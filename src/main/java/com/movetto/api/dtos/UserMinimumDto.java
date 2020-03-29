package com.movetto.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserMinimumDto {

    @NotNull
    private String displayName;
    @NotNull @Email
    private String email;
    @NotNull
    private String uid;

    public UserMinimumDto(){
        this("","","");
    }

    public UserMinimumDto(@NotNull String displayName, @NotNull String email, @NotNull String uid) {
        this.displayName = displayName;
        this.email = email;
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserMinimumDto{" +
                "displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
