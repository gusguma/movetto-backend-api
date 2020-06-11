package com.movetto.api.daos;

import com.movetto.api.entities.Travel;
import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TravelDao extends JpaRepository<Travel,Integer> {

    Optional<List<Travel>> findAllByActiveIsTrue();
    Optional<List<Travel>> findAllByCustomerIsAndActiveTrue(User user);

}
