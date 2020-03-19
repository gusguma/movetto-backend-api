package com.movetto.api.daos;

import com.movetto.api.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionDao extends JpaRepository<Direction,Integer> {
    Direction findDirectionById(int id);
}
