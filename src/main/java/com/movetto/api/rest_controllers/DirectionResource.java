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

    public static final String HASH = "/{hash}";

    private DirectionController directionController;

    @Autowired
    public DirectionResource(DirectionController directionController) {
        this.directionController = directionController;
    }

    @GetMapping
    public ResponseEntity<List<Direction>> findAllDirections(){
        return directionController.readDirections();
    }



    @GetMapping(value = HASH)
    public ResponseEntity<Direction> findDirectionByHash(@PathVariable int hash){
        return directionController.findDirectionByHash(hash);
    }

    @PostMapping
    public ResponseEntity<Direction> saveDirection(@RequestBody DirectionDto direction){
        return directionController.saveDirection(direction);
    }

    @PutMapping
    public ResponseEntity<Direction> updateDirection(@RequestBody DirectionDto direction){
        return directionController.updateDirection(direction);
    }

    @DeleteMapping(value = HASH)
    public ResponseEntity<String> deleteDirectionByHash(@PathVariable int hash){
        return directionController.deleteDirection(hash);
    }
}
