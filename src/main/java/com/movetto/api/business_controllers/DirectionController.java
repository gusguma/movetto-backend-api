package com.movetto.api.business_controllers;

import com.movetto.api.daos.DirectionDao;
import com.movetto.api.entities.Coordinate;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DirectionController {

    private DirectionDao directionDao;
    private UserController userController;

    @Autowired
    public DirectionController(DirectionDao directionDao, UserController userController) {
        this.directionDao = directionDao;
        this.userController = userController;
    }

    public ResponseEntity <List<Direction>> findUserDirections(String uid) {
        Optional<List<Direction>> directions = directionDao.findDirectionsByUserUid(uid);
        if (directions.isPresent()){
            List<Direction> directionList = directions.get();
            return ResponseEntity.ok(directionList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Direction> saveDirection(String uid, Direction direction){
        ResponseEntity<User> user = userController.readUserByUid(uid);
        if (user != null){
            Direction newDirection = new Direction();
            newDirection.setName(direction.getName());
            newDirection.setStreet(direction.getStreet());
            newDirection.setPostalCode(direction.getPostalCode());
            newDirection.setCity(direction.getCity());
            newDirection.setState(direction.getState());
            newDirection.setCountry(direction.getCountry());
            newDirection.setCoordinate(new Coordinate());
            newDirection.setUser(user.getBody());
            directionDao.save(newDirection);
            System.out.println("Direccion guardada correctamente");
            return ResponseEntity.ok(newDirection);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
