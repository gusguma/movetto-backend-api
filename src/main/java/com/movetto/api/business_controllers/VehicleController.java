package com.movetto.api.business_controllers;

import com.movetto.api.daos.VehicleDao;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.User;
import com.movetto.api.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    private VehicleDao vehicleDao;
    private UserController userController;

    @Autowired
    public VehicleController(VehicleDao vehicleDao, UserController userController) {
        this.vehicleDao = vehicleDao;
        this.userController = userController;
    }

    public ResponseEntity<List<Vehicle>> findUserVehicles(String uid) {
        Optional<List<Vehicle>> vehicles = vehicleDao.findVehiclesByUserUid(uid);
        if (vehicles.isPresent()){
            List<Vehicle> vehiclesList = vehicles.get();
            return ResponseEntity.ok(vehiclesList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
