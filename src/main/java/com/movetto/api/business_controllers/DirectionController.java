package com.movetto.api.business_controllers;

import com.movetto.api.daos.DirectionDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.DirectionDto;
import com.movetto.api.entities.Direction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DirectionController {

    private DirectionDao directionDao;
    private UserDao userDao;

    @Autowired
    public DirectionController(DirectionDao directionDao, UserDao userDao) {
        this.directionDao = directionDao;
        this.userDao = userDao;
    }

    public ResponseEntity<List<Direction>> readDirections(){
        return directionDao.findAllByActiveTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Direction> findDirectionById(int id) {
        return directionDao.findDirectionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Direction> saveDirection(DirectionDto direction){
        if (directionDao.findDirectionById(direction.getId()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .build();
        } else {
            Direction directionCreate = new Direction();
            setDataDirection(directionCreate,direction);
            directionDao.save(directionCreate);
            return ResponseEntity.ok(directionCreate);
        }
    }

    public ResponseEntity<Direction> updateDirection(DirectionDto direction) {
        Optional<Direction> directionStored = directionDao.findDirectionById(direction.getId());
        if (directionStored.isPresent()) {
            Direction directionUpdate = directionStored.get();
            setDataDirection(directionUpdate, direction);
            directionDao.save(directionUpdate);
            return ResponseEntity.ok(directionUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void setDataDirection (Direction newDirection, DirectionDto direction) {
        newDirection.setDirectionType(direction.getDirectionType());
        newDirection.setStreet(direction.getStreet());
        newDirection.setPostalCode(direction.getPostalCode());
        newDirection.setCity(direction.getCity());
        newDirection.setState(direction.getState());
        newDirection.setCountry(direction.getCountry());
        newDirection.setCoordinate(direction.getCoordinate());
    }

    public ResponseEntity<String> deleteDirection(int id) {
        Optional<Direction> directionStored = directionDao.findDirectionById(id);
        if (directionStored.isPresent() && directionStored.get().isActive()) {
            Direction directionDelete = directionStored.get();
            directionDelete.setActive(false);
            directionDao.save(directionDelete);
            return ResponseEntity.ok("La direccion se ha eliminado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
