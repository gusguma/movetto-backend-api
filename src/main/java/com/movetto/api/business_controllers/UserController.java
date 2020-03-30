package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.UserDto;
import com.movetto.api.dtos.UserMinimumDto;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    public List<UserMinimumDto> readUsers(){
        return userDao.findAllUsers();
    }

    public ResponseEntity<User> readUserByUid(String uid){
        return userDao.findUserByUid(uid).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> readUserByEmail(String email){
        return userDao.findUserByEmail(email).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> readUserByUidRolesLike(String uid, Role role){
        return userDao.findUserByUidAndRolesLike(uid, role).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> saveUser(UserMinimumDto user){
        if (readUserByUid(user.getUid()).hasBody()){
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .build();
        } else {
            User userCreate = new User();
            userCreate.setDisplayName(user.getDisplayName());
            userCreate.setEmail(user.getEmail());
            userCreate.setUid(user.getUid());
            userDao.save(userCreate);
            return ResponseEntity.ok(userCreate);
        }
    }

    public ResponseEntity<User> updateUser(UserDto user){
        ResponseEntity<User> userStored = readUserByUid(user.getUid());
        if (userStored.hasBody()){
            User userUpdated = userStored.getBody();
            assert userUpdated != null;
            userUpdated.setDisplayName(user.getDisplayName());
            userUpdated.setPhone(user.getPhone());
            userDao.save(userUpdated);
            return ResponseEntity.ok(userUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteUser(String uid){
        Optional<User> optionalUser = userDao.findUserByUid(uid);
        if (optionalUser.isPresent() && optionalUser.get().isActive()){
            User user = optionalUser.get();
            user.setActive(false);
            userDao.save(user);
            return ResponseEntity.ok("El usuario " + user.getDisplayName() + " se ha eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
