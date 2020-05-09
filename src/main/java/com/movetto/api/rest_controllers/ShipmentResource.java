package com.movetto.api.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ShipmentResource.SHIPMENTS)
public class ShipmentResource {

    public static final String SHIPMENTS = "/shipments";
}
