package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ResponseEntity<List<User>> readUsers(){
        List<User> users = userDao.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<User> readUserByUid(String uid){
        Optional<User> optionalUser = userDao.findUserByUid(uid);
        return optionalUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> readUserByEmail(String email){
        Optional<User> optionalUser = userDao.findUserByEmail(email);
        return optionalUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public Optional<User> readUserByUidRolesLike(String uid, Role role){
        return userDao.findUserByUidAndRolesLike(uid, role);
    }

    public ResponseEntity<User> saveUser(User user){
       ResponseEntity<User> existUserUid = readUserByUid(user.getUid());
       ResponseEntity<User> existUserEmail = readUserByEmail(user.getEmail());
       if (!existUserUid.hasBody() && !existUserEmail.hasBody()){
           userDao.save(user);
           System.out.println("El Usuario " + user.getUid() + " se ha guardado correctamente.");
           return ResponseEntity.ok(user);
       } else {
           System.out.println("El Usuario " + user.getUid() + " ya existe.");
           return existUserUid;
       }
    }

    public ResponseEntity<User> updateUser(User user){
        Optional<User> optionalUser = userDao.findUserByUid(user.getUid());
        if (optionalUser.isPresent()){
            User oldUser = optionalUser.get();
            oldUser.setDisplayName(user.getDisplayName());
            oldUser.setActive(user.isActive());
            oldUser.setRoles(user.getRoles());
            oldUser.setEmail(user.getEmail());
            oldUser.setPhone(user.getPhone());
            userDao.save(oldUser);
            return ResponseEntity.ok(oldUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String deleteUser(String uid){
        Optional<User> optionalUser = userDao.findUserByUid(uid);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setActive(false);
            userDao.save(user);
            return "El Usuario " + user.getUid() + " se ha eliminado.";
        } else {
            return "User uid not found - " + uid;
        }
    }
}
