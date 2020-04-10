package com.movetto.api.daos;

import com.movetto.api.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarDao extends JpaRepository<Car,Integer> {

    Optional<List<Car>> findAllByIdTrue();
    Optional<Car> findCarById(int id);

}
