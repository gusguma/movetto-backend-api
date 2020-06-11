package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.TravelController;
import com.movetto.api.dtos.ShipmentDto;
import com.movetto.api.dtos.TravelDto;
import com.movetto.api.entities.Shipment;
import com.movetto.api.entities.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TravelResource.TRAVELS)
public class TravelResource {

    public static final String TRAVELS = "/travels";
    public static final String UID = "/{uid}";
    public static final String ID = "/id/{id}";

    private final TravelController travelController;

    @Autowired
    public TravelResource(TravelController travelController) {
        this.travelController = travelController;
    }

    @GetMapping
    public ResponseEntity<List<Travel>> findAllShipments() {
        return travelController.readTravels();
    }

    @GetMapping(value = UID)
    public ResponseEntity<List<Travel>> findTravelsByUser(@PathVariable String uid){
        return travelController.readTravelsByUserUid(uid);
    }

    @GetMapping(value = ID)
    public ResponseEntity<Travel> findTravelById(@PathVariable int id){
        return travelController.readTravelById(id);
    }

    @PostMapping
    public ResponseEntity<Travel> saveTravel (@RequestBody TravelDto travel){
        return travelController.saveTravel(travel);
    }

    @PutMapping
    public ResponseEntity<Travel> updateTravel (@RequestBody TravelDto travel){
        return travelController.updateTravel(travel);
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<Travel> deleteTravel (@PathVariable int id){
        return travelController.deleteTravel(id);
    }
}
