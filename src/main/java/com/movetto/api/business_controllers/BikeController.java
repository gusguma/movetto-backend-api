package com.movetto.api.business_controllers;

import com.movetto.api.daos.BikeDao;
import com.movetto.api.daos.VehicleDao;
import com.movetto.api.dtos.BikeDto;
import com.movetto.api.entities.Bike;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BikeController extends VehicleController {

    private final BikeDao bikeDao;
    private final ModelMapper modelMapper;

    @Autowired
    public BikeController(VehicleDao vehicleDao, BikeDao bikeDao) {
        super(vehicleDao);
        this.bikeDao = bikeDao;
        modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Bike>> readBikes() {
        return bikeDao.findAllByIdTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Bike> readBike(int id){
        return bikeDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Bike> saveBike(BikeDto bikeDto){
        if (bikeDao.findBikeById(bikeDto.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Bike bike = modelMapper.map(bikeDto,Bike.class);
            bikeDao.save(bike);
            return ResponseEntity.ok(bike);
        }
    }

    public ResponseEntity<Bike> updateBike(BikeDto bikeDto){
        if (bikeDao.findBikeById(bikeDto.getId()).isPresent()){
            Bike bike = modelMapper.map(bikeDto,Bike.class);
            bikeDao.save(bike);
            return ResponseEntity.ok(bike);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteBike(int id){
        Optional<Bike> bike = bikeDao.findBikeById(id);
        if (bike.isPresent()){
            Bike bikeDeleted = bike.get();
            bikeDeleted.setActive(false);
            bikeDao.save(bikeDeleted);
            return ResponseEntity.ok("Bike Deleted" + bikeDeleted.getName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
