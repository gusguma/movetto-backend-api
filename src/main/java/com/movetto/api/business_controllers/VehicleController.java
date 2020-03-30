package com.movetto.api.business_controllers;

import com.movetto.api.daos.VehicleDao;
import com.movetto.api.dtos.VehicleDto;
import com.movetto.api.entities.Vehicle;
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

    public List<Vehicle> readVehicles(){
        return vehicleDao.findAll();
    }

    public ResponseEntity<List<Vehicle>> findUserVehicles(String uid) {
        return vehicleDao.findVehiclesByUserUid(uid).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<Vehicle> findVehicleByHash(int hash) {
        return vehicleDao.findVehicleByHash(hash).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<Vehicle> saveVehicle(VehicleDto vehicle){
        if (findVehicleByHash(vehicle.getHash()).hasBody()) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .build();
        } else {
            Vehicle vehicleCreate = new Vehicle();
            setDataVehicle(vehicleCreate,vehicle);
            vehicleCreate.setUser(vehicle.getUser());
            vehicleCreate.setHash(vehicleCreate.hashCode());
            vehicleDao.save(vehicleCreate);
            return ResponseEntity.ok(vehicleCreate);
        }
    }

    public ResponseEntity<Vehicle> updateVehicle(VehicleDto vehicle){
        Optional<Vehicle> vehicleStored = vehicleDao.findVehicleByHash(vehicle.getHash());
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
        newVehicle.setVehicleType(vehicle.getVehicleType());
        newVehicle.setRegistration(vehicle.getRegistration());
        newVehicle.setMaxVolume(vehicle.getMaxVolume());
        newVehicle.setMaxWeight(vehicle.getMaxWeight());
        newVehicle.setMaxLenght(vehicle.getMaxLenght());
        newVehicle.setMaxWidth(vehicle.getMaxWidth());
        newVehicle.setMaxHigh(vehicle.getMaxHigh());
    }

    public ResponseEntity<String> deleteVehicle(int hash) {
        Optional<Vehicle> optionalVehicle = vehicleDao.findVehicleByHash(hash);
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
