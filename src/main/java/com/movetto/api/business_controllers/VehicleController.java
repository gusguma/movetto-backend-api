package com.movetto.api.business_controllers;

import com.movetto.api.daos.VehicleDao;
import com.movetto.api.dtos.VehicleDto;
import com.movetto.api.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<Vehicle> saveVehicle(VehicleDto vehicle){
        if (vehicleDao.findVehicleById(vehicle.getId()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .build();
        } else {
            Vehicle vehicleCreate = selectVehicle(vehicle);
            setDataVehicle(vehicleCreate,vehicle);
            vehicleDao.save(vehicleCreate);
            return ResponseEntity.ok(vehicleCreate);
        }
    }

    private Vehicle selectVehicle(VehicleDto vehicle){
        Vehicle vehicleCreate;
        switch (vehicle.getVehicleType()) {
            case BIKE:
                vehicleCreate = new Bike(vehicle.getUser());
                break;
            case MOTORCYCLE:
                vehicleCreate = new Motorcycle(vehicle.getUser(), vehicle.getRegistration());
                break;
            case VAN:
                vehicleCreate = new Van(vehicle.getUser(), vehicle.getRegistration());
                break;
            default:
                vehicleCreate = new Car(vehicle.getUser(), vehicle.getRegistration());
                break;
        }
        return vehicleCreate;
    }

    public ResponseEntity<Vehicle> updateVehicle(VehicleDto vehicle){
        Optional<Vehicle> vehicleStored = vehicleDao.findVehicleById(vehicle.getId());
        if (vehicleStored.isPresent()){
            Vehicle vehicleUpdate = vehicleStored.get();
            setDataVehicle(vehicleUpdate, vehicle);
            vehicleDao.save(vehicleUpdate);
            return ResponseEntity.ok(vehicleUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void setDataVehicle(Vehicle newVehicle, VehicleDto vehicle) {
        newVehicle.setName(vehicle.getName());
        newVehicle.setRegistration(vehicle.getRegistration());
    }

    public ResponseEntity<String> deleteVehicle(int id) {
        Optional<Vehicle> optionalVehicle = vehicleDao.findVehicleById(id);
        if (optionalVehicle.isPresent() && optionalVehicle.get().isActive()){
            Vehicle vehicleDelete = optionalVehicle.get();
            vehicleDelete.setActive(false);
            vehicleDao.save(vehicleDelete);
            return ResponseEntity.ok("El Vehiculo " + vehicleDelete.getName() + " se ha eliminado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
