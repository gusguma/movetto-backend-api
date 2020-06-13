package com.movetto.api.daos;

import com.movetto.api.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BikeDao extends JpaRepository<Bike,Integer> {

    Optional<List<Bike>> findAllByIdTrue();
    Optional<Bike> findBikeById(int id);

}
