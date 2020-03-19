package com.movetto.api.rest_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/users";

    public static final String ID = "/id/{id}";
    public static final String EMAIL = "/email/{email}";
    public static final String UID = "/uid/{uid}";
    public static final String CUSTOMERS = "/customers";
    public static final String PARTNERS = "/partners";

    private final UserDao userDao;

    @Autowired
    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userDao.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = CUSTOMERS)
    public ResponseEntity<List<User>> findAllCustomers(){
        List<User> customers = userDao.findUsersByCustomerIdIsNotNull();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = PARTNERS)
    public ResponseEntity<List<User>> findAllPartners(){
        List<User> partners = userDao.findUsersByPartnerIdIsNotNull();
        return ResponseEntity.ok(partners);
    }

    @GetMapping(value = ID)
    public ResponseEntity<User> findUserById(@PathVariable int id){
        Optional<User> user = userDao.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping(value = EMAIL)
    public ResponseEntity<User> findUserByEmail(@PathVariable String email){
        Optional<User> user = Optional.ofNullable(userDao.findUserByEmail(email));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping(value = UID)
    public ResponseEntity<User> findUserByUid(@PathVariable String uid){
        Optional<User> user = Optional.ofNullable(userDao.findUserByUid(uid));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User existUser = userDao.findUserByEmail(user.getEmail());
        if (existUser == null){
            User newUser = userDao.save(user);
            return ResponseEntity.ok(newUser);
        } else{
            return ResponseEntity.ok(existUser);
        }
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        userDao.save(user);
        return user;
    }

    @DeleteMapping(value = ID)
    public String deleteUserById(@PathVariable int id){
        User user = userDao.findUserById(id);
        if (user == null) throw new RuntimeException("User id not found - " + id);
        userDao.delete(user);
        return "Deleted user id - " + id;
    }
}
