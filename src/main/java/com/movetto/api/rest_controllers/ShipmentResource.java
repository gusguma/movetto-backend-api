package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.ShipmentController;
import com.movetto.api.dtos.ShipmentDto;
import com.movetto.api.entities.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ShipmentResource.SHIPMENTS)
public class ShipmentResource {

    public static final String SHIPMENTS = "/shipments";
    public static final String UID = "/{uid}";
    public static final String ID = "/id/{id}";

    private final ShipmentController shipmentController;

    @Autowired
    public ShipmentResource(ShipmentController shipmentController) {
        this.shipmentController = shipmentController;
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> findAllShipments() {
        return shipmentController.readShipments();
    }

    @GetMapping(value = UID)
    public ResponseEntity<List<Shipment>> findShipmentsByUser(@PathVariable String uid){
        return shipmentController.readShipmentsByUserUid(uid);
    }

    @GetMapping(value = ID)
    public ResponseEntity<Shipment> findShipmentById(@PathVariable int id){
        return shipmentController.readShipmentById(id);
    }

    @PostMapping
    public ResponseEntity<Shipment> saveShipment (@RequestBody ShipmentDto shipment){
        return shipmentController.saveShipment(shipment);
    }

    @PutMapping
    public ResponseEntity<Shipment> updateShipment (@RequestBody ShipmentDto shipment){
        return shipmentController.updateShipment(shipment);
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<Shipment> deleteShipment (@PathVariable int id){
        return shipmentController.deleteShipment(id);
    }
}
