package com.movetto.api.dao;

import com.movetto.api.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateDao extends JpaRepository<Coordinate,Integer> {

}
