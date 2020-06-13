package com.movetto.api.daos;

import com.movetto.api.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PackageDao extends JpaRepository<Package,Integer> {
    Optional<List<Package>> findAllByActiveTrue();

}
