package com.movetto.api.business_controllers;

import com.movetto.api.daos.VehicleDao;
import com.movetto.api.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehicleController {

    private VehicleDao vehicleDao;

    @Autowired
    public VehicleController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public ResponseEntity<List<Vehicle>> readVehicles(){
        return vehicleDao.findAllByActiveTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Vehicle> findVehicleById(int id) {
        return vehicleDao.findVehicleById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<String> deleteVehicleById(int id) {
        ResponseEntity<Vehicle> vehicleResponseEntity = findVehicleById(id);
        if (vehicleResponseEntity.hasBody()){
           Vehicle vehicle = vehicleResponseEntity.getBody();
           assert vehicle != null;
           vehicleDao.delete(vehicle);
           return ResponseEntity.ok("Vehiculo Borrado");
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
