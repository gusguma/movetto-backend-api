package com.movetto.api.daos;

import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserById(int id);
    User findUserByUid(String uid);
    List<User> findUsersByCustomerIdIsNotNull();
    List<User> findUsersByPartnerIdIsNotNull();
}
