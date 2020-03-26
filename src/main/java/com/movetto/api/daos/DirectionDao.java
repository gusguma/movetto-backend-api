package com.movetto.api.daos;

import com.movetto.api.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectionDao extends JpaRepository<Direction,Integer> {
    Direction findDirectionById(int id);
    List<Direction> findDirectionsById(int id);
}
