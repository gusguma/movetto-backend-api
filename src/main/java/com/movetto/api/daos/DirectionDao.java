package com.movetto.api.daos;

import com.movetto.api.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectionDao extends JpaRepository<Direction,Integer> {
    Optional<List<Direction>> findDirectionsByUserUid(String uid);
    Direction findDirectionById(int id);
    List<Direction> findDirectionsById(int id);
}
