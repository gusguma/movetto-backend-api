package com.movetto.api.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/users";

    public static final String TOKEN = "/token";


}
