package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.TravelController;
import com.movetto.api.dtos.TravelDto;
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
    public static final String PARTNER_ID = "/partners/{uid}";
    public static final String AVAILABLE = "/available/{uid}";
    public static final String PENDING = "/pending/{uid}";
    public static final String FINISHED = "/finished/{uid}";

    private final TravelController travelController;

    @Autowired
    public TravelResource(TravelController travelController) {
        this.travelController = travelController;
    }

    @GetMapping
    public ResponseEntity<List<Travel>> findAllTravels() {
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

    @GetMapping(value = PARTNER_ID)
    public ResponseEntity<List<Travel>> findTravelsByPartnerUid(@PathVariable String uid){
        return travelController.readTravelsByPartnerUid(uid);
    }

    @GetMapping(value = AVAILABLE)
    public ResponseEntity<List<Travel>> findTravelsAvailable(@PathVariable String uid){
        return travelController.readTravelsAvailable(uid);
    }

    @GetMapping(value = PENDING)
    public ResponseEntity<List<Travel>> findTravelsPending(@PathVariable String uid){
        return travelController.readTravelsPending(uid);
    }

    @GetMapping(value = FINISHED)
    public ResponseEntity<List<Travel>> findTravelsFinished(@PathVariable String uid){
        return travelController.readTravelsFinished(uid);
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
