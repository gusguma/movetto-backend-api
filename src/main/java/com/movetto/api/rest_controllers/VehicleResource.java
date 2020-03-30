package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.VehicleController;
import com.movetto.api.dtos.VehicleDto;
import com.movetto.api.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(VehicleResource.VEHICLE)
public class VehicleResource {

    public static final String VEHICLE = "/vehicles";

    public static final String HASH = "/{hash}";

    private VehicleController vehicleController;

    @Autowired
    public VehicleResource(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    @GetMapping
    public List<Vehicle> findAllVehicles(){
        return vehicleController.readVehicles();
    }

    @GetMapping(value = HASH)
    public ResponseEntity<Vehicle> findVehicleByHash(@PathVariable int hash){
        return vehicleController.findVehicleByHash(hash);
    }

    @PostMapping
    public ResponseEntity<Vehicle> saveDirection(@RequestBody VehicleDto vehicle){
        return vehicleController.saveVehicle(vehicle);
    }

    @PutMapping
    public ResponseEntity<Vehicle> updateDirection(@RequestBody VehicleDto vehicle){
        return vehicleController.updateVehicle(vehicle);
    }

    @DeleteMapping(value = HASH)
    public ResponseEntity<String> deleteDirectionByHash(@PathVariable int hash){
        return vehicleController.deleteVehicle(hash);
    }
}
