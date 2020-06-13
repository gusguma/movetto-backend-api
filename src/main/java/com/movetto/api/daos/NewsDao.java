package com.movetto.api.daos;

import com.movetto.api.entities.News;
import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface NewsDao extends JpaRepository<News,Integer> {

    Optional<List<News>> findAllByActiveIsTrue();
    Optional<List<News>> findAllByUsers(Set<User> users);

}
