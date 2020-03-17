package com.movetto.api.rest_controllers;

import com.movetto.api.dao.UserDao;
import com.movetto.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/users";

    public static final String ID = "/{id}";
    public static final String EMAIL = "/{email}";
    public static final String UID = "/{uid}";

    private final UserDao userDao;

    @Autowired
    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userDao.findAll();
    }

    @GetMapping(value = ID)
    public User findUserById(@PathVariable int id){
        User user = userDao.findUserById(id);
        if (user == null) throw new RuntimeException("User id not found - " + id);
        return user;
    }

    @GetMapping(value = EMAIL)
    public User findUserByEmail(@PathVariable String email){
        User user = userDao.findUserByEmail(email);
        if (user == null) throw new RuntimeException("User id not found - " + email);
        return user;
    }

    @GetMapping(value = UID)
    public User findUserByUid(@PathVariable String uid){
        User user = userDao.findUserByUid(uid);
        if (user == null) throw new RuntimeException("User id not found - " + uid);
        return user;
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        User userDataBase = userDao.findUserByEmail(user.getEmail());
        if (userDataBase == null){
            userDao.save(user);
            return user;
        } else {
            return userDataBase;
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
