package com.movetto.api.business_controllers;

import com.movetto.api.daos.VanDao;
import com.movetto.api.daos.VehicleDao;
import com.movetto.api.dtos.VanDto;
import com.movetto.api.entities.Van;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VanController extends VehicleController {

    public VanDao vanDao;
    public ModelMapper modelMapper;

    @Autowired
    public VanController(VehicleDao vehicleDao, VanDao vanDao) {
        super(vehicleDao);
        this.vanDao = vanDao;
        modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Van>> readVans() {
        return vanDao.findAllByIdTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Van> readVan(int id){
        return vanDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Van> saveVan(VanDto vanDto){
        if (vanDao.findVanById(vanDto.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Van van = modelMapper.map(vanDto,Van.class);
            vanDao.save(van);
            return ResponseEntity.ok(van);
        }
    }

    public ResponseEntity<Van> updateVan(VanDto vanDto){
        if (vanDao.findVanById(vanDto.getId()).isPresent()){
            Van van = modelMapper.map(vanDto,Van.class);
            vanDao.save(van);
            return ResponseEntity.ok(van);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteVan(int id){
        Optional<Van> van = vanDao.findVanById(id);
        if (van.isPresent()){
            Van vanDeleted = van.get();
            vanDeleted.setActive(false);
            vanDao.save(vanDeleted);
            return ResponseEntity.ok("Van Deleted" + vanDeleted.getName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
