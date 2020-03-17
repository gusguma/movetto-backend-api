package com.movetto.api.dao;

import com.movetto.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserById(int id);
    User findUserByUid(String uid);
}
