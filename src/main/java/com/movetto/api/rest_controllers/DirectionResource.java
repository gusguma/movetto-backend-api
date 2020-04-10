package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.DirectionController;
import com.movetto.api.dtos.DirectionDto;
import com.movetto.api.entities.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DirectionResource.DIRECTION)
public class DirectionResource {

    public static final String DIRECTION = "/directions";

    public static final String ID = "/{id}";

    private DirectionController directionController;

    @Autowired
    public DirectionResource(DirectionController directionController) {
        this.directionController = directionController;
    }

    @GetMapping
    public ResponseEntity<List<Direction>> findAllDirections(){
        return directionController.readDirections();
    }

    @GetMapping(value = ID)
    public ResponseEntity<Direction> findDirectionById(@PathVariable int id){
        return directionController.findDirectionById(id);
    }

    @PostMapping
    public ResponseEntity<Direction> saveDirection(@RequestBody DirectionDto direction){
        return directionController.saveDirection(direction);
    }

    @PutMapping
    public ResponseEntity<Direction> updateDirection(@RequestBody DirectionDto direction){
        return directionController.updateDirection(direction);
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<String> deleteDirectionById(@PathVariable int id){
        return directionController.deleteDirection(id);
    }
}
