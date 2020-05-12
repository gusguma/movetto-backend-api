package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.NewsController;
import com.movetto.api.business_controllers.ShipmentController;
import com.movetto.api.dtos.NewsDto;
import com.movetto.api.entities.News;
import com.movetto.api.entities.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(ShipmentResource.SHIPMENTS)
public class ShipmentResource {

    public static final String SHIPMENTS = "/shipments";
    public static final String UID = "/{uid}";

    private ShipmentController shipmentController;

    @Autowired
    public ShipmentResource(ShipmentController shipmentController) {
        this.shipmentController = shipmentController;
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> findAllNews() {
        return shipmentController.readShipments();
    }

    @GetMapping(value = UID)
    public ResponseEntity<List<Shipment>> findNewsByUser(@PathVariable String uid){
        return shipmentController.findShipmentsByUserUid(uid);
    }

}
