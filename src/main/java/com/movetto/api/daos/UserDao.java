package com.movetto.api.daos;

import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findUserByUid(String uid);
    Optional<User> findUserByEmail(String email);
    List<User> findUsersByCustomerIdIsNotNull();
    List<User> findUsersByPartnerIdIsNotNull();
}
