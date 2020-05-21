package com.movetto.api.daos;

import com.movetto.api.entities.Card;
import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardDao extends JpaRepository<Card, Integer> {

    Optional<List<Card>> findAllByUserAndActiveIsTrue(User user);

}
