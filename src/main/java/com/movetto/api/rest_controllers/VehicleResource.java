package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.*;
import com.movetto.api.dtos.BikeDto;
import com.movetto.api.dtos.CarDto;
import com.movetto.api.dtos.MotorcycleDto;
import com.movetto.api.dtos.VanDto;
import com.movetto.api.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(VehicleResource.VEHICLE)
public class VehicleResource {

    public static final String VEHICLE = "/vehicles";

    public static final String BIKE = "/bike";
    public static final String MOTORCYCLE = "/motorbike";
    public static final String CAR = "/car";
    public static final String VAN = "/van";
    public static final String ID = "/{id}";

    private final VehicleController vehicleController;
    private final BikeController bikeController;
    private final CarController carController;
    private final MotorcycleController motorcycleController;
    private final VanController vanController;

    @Autowired
    public VehicleResource(VehicleController vehicleController, BikeController bikeController,
                           CarController carController, MotorcycleController motorcycleController,
                           VanController vanController) {
        this.vehicleController = vehicleController;
        this.bikeController = bikeController;
        this.carController = carController;
        this.motorcycleController = motorcycleController;
        this.vanController = vanController;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAllVehicles(){
        return vehicleController.readVehicles();
    }

    @GetMapping(value = ID)
    public ResponseEntity<Vehicle> findVehicleById(@PathVariable int id){
        return vehicleController.findVehicleById(id);
    }
    @DeleteMapping(value = ID)
    public ResponseEntity<String> deleteVehicle(@PathVariable int id){
        return vehicleController.deleteVehicleById(id);
    }

    //BIKE
    @PostMapping(value = BIKE)
    public ResponseEntity<Bike> saveBike(@RequestBody BikeDto bikeDto){
        return bikeController.saveBike(bikeDto);
    }

    @PutMapping(value = BIKE)
    public ResponseEntity<Bike> updateBike(@RequestBody BikeDto bikeDto){
        return bikeController.updateBike(bikeDto);
    }

    //CAR
    @PostMapping(value = CAR)
    public ResponseEntity<Car> saveCar(@RequestBody CarDto carDto){
        return carController.saveCar(carDto);
    }

    @PutMapping(value = CAR)
    public ResponseEntity<Car> updateCar(@RequestBody CarDto carDto){
        return carController.updateCar(carDto);
    }

    //MOTORCYCLE
    @PostMapping(value = MOTORCYCLE)
    public ResponseEntity<Motorcycle> saveMotorcycle(@RequestBody MotorcycleDto motorcycleDto){
        return motorcycleController.saveMotorcycle(motorcycleDto);
    }

    @PutMapping(value = MOTORCYCLE)
    public ResponseEntity<Motorcycle> updateMotorcycle(@RequestBody MotorcycleDto motorcycleDto){
        return motorcycleController.updateMotorcycle(motorcycleDto);
    }

    //VAN
    @PostMapping(value = VAN)
    public ResponseEntity<Van> saveVan(@RequestBody VanDto vanDto){
        return vanController.saveVan(vanDto);
    }

    @PutMapping(value = VAN)
    public ResponseEntity<Van> updateVan(@RequestBody VanDto vanDto){
        return vanController.updateVan(vanDto);
    }

}
