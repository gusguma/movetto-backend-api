package com.movetto.api.business_controllers;

import com.movetto.api.daos.DirectionDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.UserDto;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.DirectionType;
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
public class CustomerController extends UserController {

    private UserDao customerDao;
    private DirectionDao directionDao;

    @Autowired
    public CustomerController(UserDao userDao, DirectionDao directionDao) {
        super(userDao);
        this.customerDao = userDao;
        this.directionDao = directionDao;
    }

    public ResponseEntity<List<User>> readCustomers(){
        return this.customerDao.findUsersByRolesLike(Role.CUSTOMER)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> readCustomer(String uid, Role role){
        return this.customerDao.findUserByUidAndRolesLike(uid, role)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> saveCustomer(UserDto user){
        Optional<User> userExist = customerDao.findUserByUid(user.getUid());
        Optional<User> userCustomerExist = customerDao
                .findUserByUidAndRolesLike(user.getUid(),Role.CUSTOMER);
        if(userCustomerExist.isPresent()){
            return ResponseEntity
                    .status(HttpStatus.FOUND).build();
        } else if (userExist.isPresent()){
            User userCustomerNew = userExist.get();
            setCustomerData(userCustomerNew, user);
            userCustomerNew.getRoles().add(Role.CUSTOMER);
            customerDao.save(userCustomerNew);
            return ResponseEntity.ok(userCustomerNew);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updateCustomer(UserDto user){
        Optional<User> userExist = customerDao
                .findUserByUidAndRolesLike(user.getUid(),Role.CUSTOMER);
        if (userExist.isPresent()){
            User userCustomerUpdated = userExist.get();
            setCustomerData(userCustomerUpdated, user);
            customerDao.save(userCustomerUpdated);
            return ResponseEntity.ok(userCustomerUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteCustomer(String uid){
        Optional<User> userExist = customerDao.findUserByUidAndRolesLike(uid,Role.CUSTOMER);
        if (userExist.isPresent()){
            User userCustomerDeleted = userExist.get();
            userCustomerDeleted .getRoles().remove(Role.PARTNER);
            customerDao.save(userCustomerDeleted );
            return ResponseEntity.ok("El cliente " + userCustomerDeleted.getDisplayName() + "se ha eliminado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private User setCustomerData(User updateUser, UserDto userInput){
        updateUser.setDisplayName(userInput.getDisplayName());
        updateUser.setPhone(userInput.getPhone());
        updateUser.setCustomer(userInput.getCustomer());
        updateUser.setDirections(userInput.getDirections());
        return updateUser;
    }
}
