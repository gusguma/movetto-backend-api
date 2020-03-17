package com.movetto.api.rest_controllers;

import com.movetto.api.dao.DirectionDao;
import com.movetto.api.entity.Direction;
import com.movetto.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DirectionResource.DIRECTION)
public class DirectionResource {
    public static final String DIRECTION = "/directions";

    public static final String ID = "/{id}";

    private final DirectionDao directionDao;

    @Autowired
    public DirectionResource(DirectionDao directionDao) {
        this.directionDao = directionDao;
    }

    @GetMapping
    public List<Direction> findAllDirections(){
        return directionDao.findAll();
    }

    @GetMapping(value = ID)
    public Direction findDirectionById(@PathVariable int id){
        Direction direction = directionDao.findDirectionById(id);
        if (direction == null) throw new RuntimeException("Direction id not found - " + id);
        return direction;
    }

    @PostMapping
    public Direction saveDirection(@RequestBody Direction direction){
        Direction directionDatabase = directionDao.findDirectionById(direction.getId());
        if (directionDatabase == null){
            directionDao.save(direction);
            return direction;
        } else {
            return directionDatabase;
        }
    }

    @PutMapping
    public Direction updateDirection(@RequestBody Direction direction){
        directionDao.save(direction);
        return direction;
    }

    @DeleteMapping(value = ID)
    public String deleteDirectionById(@PathVariable int id){
        Direction direction = directionDao.findDirectionById(id);
        if (direction == null) throw new RuntimeException("Direction id not found - " + id);
        directionDao.delete(direction);
        return "Deleted direction id - " + id;
    }

}
