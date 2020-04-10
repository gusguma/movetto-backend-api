package com.movetto.api.business_controllers;

import com.movetto.api.daos.MotorcycleDao;
import com.movetto.api.daos.VehicleDao;
import com.movetto.api.dtos.MotorcycleDto;
import com.movetto.api.entities.Motorcycle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class MotorcycleController extends VehicleController {

    public MotorcycleDao motorcycleDao;
    public ModelMapper modelMapper;

    @Autowired
    public MotorcycleController(VehicleDao vehicleDao, MotorcycleDao motorcycleDao) {
        super(vehicleDao);
        this.motorcycleDao = motorcycleDao;
        modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Motorcycle>> readMotorcycles() {
        return motorcycleDao.findAllByIdTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Motorcycle> readMotorcycle(int id){
        return motorcycleDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Motorcycle> saveMotorcycle(MotorcycleDto motorcycleDto){
        if (motorcycleDao.findMotorcycleById(motorcycleDto.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Motorcycle motorcycle = modelMapper.map(motorcycleDto,Motorcycle.class);
            motorcycleDao.save(motorcycle);
            return ResponseEntity.ok(motorcycle);
        }
    }

    public ResponseEntity<Motorcycle> updateMotorcycle(MotorcycleDto motorcycleDto){
        if (motorcycleDao.findMotorcycleById(motorcycleDto.getId()).isPresent()){
            Motorcycle motorcycle = modelMapper.map(motorcycleDto,Motorcycle.class);
            motorcycleDao.save(motorcycle);
            return ResponseEntity.ok(motorcycle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteMotorcycle(int id){
        Optional<Motorcycle> motorcycle = motorcycleDao.findMotorcycleById(id);
        if (motorcycle.isPresent()){
            Motorcycle motorcycleDeleted = motorcycle.get();
            motorcycleDeleted.setActive(false);
            motorcycleDao.save(motorcycleDeleted);
            return ResponseEntity.ok("Motorcycle Deleted" + motorcycleDeleted.getName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
