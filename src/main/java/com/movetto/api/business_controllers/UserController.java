package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.UserDto;
import com.movetto.api.dtos.UserMinimumDto;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    public List<UserMinimumDto> readUsers(){
        return userDao.findAllUsers();
    }

    public ResponseEntity<User> readUserByUid(String uid){
        return userDao.findUserByUid(uid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> readUserByEmail(String email){
        return userDao.findUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> readUserByUidAndRolesLike(String uid, Role role){
        return userDao.findUserByUidAndRolesLike(uid, role)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UserMinimumDto> saveUser(UserMinimumDto user){
        Optional<User> userExist = userDao.findUserByUid(user.getUid());
        if (userExist.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            User userCreate = new User();
            userCreate.setDisplayName(user.getDisplayName());
            userCreate.setEmail(user.getEmail());
            userCreate.setUid(user.getUid());
            userDao.save(userCreate);
            return ResponseEntity.ok(new UserMinimumDto(
                    userCreate.getDisplayName(),
                    userCreate.getEmail(),
                    userCreate.getUid()
            ));
        }
    }

    public ResponseEntity<User> saveUserByEmail(UserDto user){
        Optional<User> userExist = userDao.findUserByEmail(user.getEmail());
        if (userExist.isPresent()){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        } else {
            User userCreate = new User();
            userCreate.setDisplayName(user.getDisplayName());
            userCreate.setPhone(user.getPhone());
            userCreate.setEmail(user.getEmail());
            userCreate.setUid(user.getUid());
            userCreate.setDirections(user.getDirections());
            userDao.save(userCreate);
            return ResponseEntity.ok(userCreate);
        }
    }

    public ResponseEntity<User> updateUser(UserDto user){
        Optional<User> userExist = userDao.findById(user.getId());
        if (userExist.isPresent()){
            User userUpdated = userExist.get();
            userUpdated.setDisplayName(user.getDisplayName());
            userUpdated.setPhone(user.getPhone());
            userDao.save(userUpdated);
            return ResponseEntity.ok(userUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteUser(String uid){
        Optional<User> userExist = userDao.findUserByUid(uid);
        if (userExist.isPresent() && userExist.get().isActive()){
            User user = userExist.get();
            user.setActive(false);
            userDao.save(user);
            return ResponseEntity.ok("El usuario " + user.getDisplayName() + " se ha eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Set<Direction>> findUserDirectionsByUid(String  uid){
        Optional<User> user = userDao.findUserByUid(uid);
        if (user.isPresent()){
            Set<Direction> directions = user.get().getDirections();
            return ResponseEntity.ok(directions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
