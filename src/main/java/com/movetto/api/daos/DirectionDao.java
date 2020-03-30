package com.movetto.api.daos;

import com.movetto.api.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectionDao extends JpaRepository<Direction,Integer> {
    Optional<Direction> findDirectionByHash(int hash);
    Optional<List<Direction>> findDirectionsByUserUid(String uid);
}
