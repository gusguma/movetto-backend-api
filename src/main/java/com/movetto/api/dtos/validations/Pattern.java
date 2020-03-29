package com.movetto.api.dtos.validations;

public final class Pattern {

    public static final String MOBILE_NUMBER = "\\d{9}";
    public static final String REGISTER_ID = "/^[a-z]{3}[0-9]{6}[a-z]?$/i";


    private Pattern(){
        //Nothing to Do
    }
}
