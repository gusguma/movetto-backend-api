package com.movetto.api.daos;

import com.movetto.api.dtos.UserDto;
import com.movetto.api.dtos.UserMinimumDto;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "select new com.movetto.api.dtos.UserMinimumDto(u.displayName,u.email,u.uid) from User u")
    List<UserMinimumDto> findAllUsers();
    Optional<User> findUserByUid(String uid);
    Optional<User> findUserByEmail(String email);

    Optional<List<User>> findUsersByRolesLike(Role role);
    Optional<User> findUserByUidAndRolesLike(String uid, Role role);

}
