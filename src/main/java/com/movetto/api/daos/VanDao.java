package com.movetto.api.daos;

import com.movetto.api.entities.Van;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VanDao extends JpaRepository<Van,Integer> {

    Optional<List<Van>> findAllByIdTrue();
    Optional<Van> findVanById(int id);

}
