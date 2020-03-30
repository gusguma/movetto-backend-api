package com.movetto.api.business_controllers;

import com.movetto.api.daos.DirectionDao;
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

    @Autowired
    public DirectionController(DirectionDao directionDao, UserController userController) {
        this.directionDao = directionDao;
    }

    public List<Direction> readDirections(){
        return directionDao.findAll();
    }

    public ResponseEntity<List<Direction>> findUserDirections(String uid) {
        return directionDao.findDirectionsByUserUid(uid).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<Direction> findDirectionByHash(int hash) {
        return directionDao.findDirectionByHash(hash).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<Direction> saveDirection(DirectionDto direction){
        if (findDirectionByHash(direction.getHash()).hasBody()) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .build();
        } else {
            Direction directionCreate = new Direction();
            setDataDirection(directionCreate,direction);
            directionCreate.setUser(direction.getUser());
            directionDao.save(directionCreate);
            return ResponseEntity.ok(directionCreate);
        }
    }

    public ResponseEntity<Direction> updateDirection(DirectionDto direction){
        Optional<Direction> directionStored = directionDao.findDirectionByHash(direction.getHash());
        if (directionStored.isPresent()){
            Direction directionUpdate = directionStored.get();
            setDataDirection(directionUpdate, direction);
            directionDao.save(directionUpdate);
            return ResponseEntity.ok(directionUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void setDataDirection(Direction newDirection, DirectionDto direction) {
        newDirection.setName(direction.getName());
        newDirection.setStreet(direction.getStreet());
        newDirection.setPostalCode(direction.getPostalCode());
        newDirection.setCity(direction.getCity());
        newDirection.setState(direction.getState());
        newDirection.setCountry(direction.getCountry());
        newDirection.setCoordinate(direction.getCoordinate());
    }

    public ResponseEntity<String> deleteDirection(int hash) {
        Optional<Direction> optionalDirection = directionDao.findDirectionByHash(hash);
        if (optionalDirection.isPresent() && optionalDirection.get().isActive()){
            Direction directionDelete = optionalDirection.get();
            directionDelete.setActive(false);
            directionDao.save(directionDelete);
            return ResponseEntity.ok("La direccion " + directionDelete.getName() + " se ha eliminado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
