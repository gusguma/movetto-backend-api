package com.movetto.api.daos;

import com.movetto.api.entities.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MotorcycleDao extends JpaRepository<Motorcycle,Integer> {

    Optional<List<Motorcycle>> findAllByIdTrue();
    Optional<Motorcycle> findMotorcycleById(int id);

}
