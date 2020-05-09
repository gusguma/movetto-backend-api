package com.movetto.api.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TravelResource.TRAVELS)
public class TravelResource {

    public static final String TRAVELS = "/travels";
}
