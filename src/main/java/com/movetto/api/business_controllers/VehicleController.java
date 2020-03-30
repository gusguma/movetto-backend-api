package com.movetto.api.business_controllers;

import com.movetto.api.daos.VehicleDao;
import com.movetto.api.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    private VehicleDao vehicleDao;

    @Autowired
    public VehicleController(VehicleDao vehicleDao, UserController userController) {
        this.vehicleDao = vehicleDao;
    }

    public ResponseEntity<List<Vehicle>> findUserVehicles(String uid) {
        return vehicleDao.findVehiclesByUserUid(uid).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<Vehicle> findVehicleById(int id) {
        return vehicleDao.findVehiclesById(id).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }


}
