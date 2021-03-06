package com.movetto.api.daos;

import com.movetto.api.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleDao extends JpaRepository<Vehicle,Integer> {

    Optional<List<Vehicle>> findAllByActiveTrue();
    Optional<Vehicle> findVehicleById(int id);
}
