package com.movetto.api.dao;

import com.movetto.api.entity.Direction;
import com.movetto.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionDao extends JpaRepository<Direction,Integer> {
    Direction findDirectionById(int id);
}
