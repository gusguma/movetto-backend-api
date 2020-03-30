package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.UserDto;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController extends UserController {

    private UserDao customerDao;

    @Autowired
    public CustomerController(UserDao userDao) {
        super(userDao);
        this.customerDao = userDao;
    }

    public ResponseEntity<List<User>> readCustomers(){
        return customerDao.findUsersByRolesLike(Role.CUSTOMER).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> saveCustomer(UserDto user){
        ResponseEntity<User> userExist = readUserByUid(user.getUid());
        ResponseEntity<User> userCustomer = readUserByUidRolesLike(user.getUid(),Role.CUSTOMER);
        if(userCustomer.hasBody()){
            return ResponseEntity
                    .status(HttpStatus.FOUND).build();
        } else if (userExist.hasBody()){
            User userCustomerNew = userExist.getBody();
            assert userCustomerNew != null;
            userCustomerNew.setCustomerId(user.getCustomerId());
            userCustomerNew.getRoles().add(Role.CUSTOMER);
            userCustomerNew.setDirections(user.getDirections());
            customerDao.save(userCustomerNew);
            return ResponseEntity.ok(userCustomerNew);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updateCustomer(UserDto user){
        Optional<User> userStored = customerDao.findUserByUidAndRolesLike(user.getUid(),Role.CUSTOMER);
        if (userStored.isPresent()){
            User userCustomer = userStored.get();
            userCustomer.setCustomerId(user.getCustomerId());
            customerDao.save(userCustomer);
            return ResponseEntity.ok(userCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteCustomer(String uid){
        Optional<User> userStored = customerDao.findUserByUidAndRolesLike(uid,Role.CUSTOMER);
        if (userStored.isPresent()){
            User userCustomer = userStored.get();
            userCustomer.getRoles().remove(Role.PARTNER);
            customerDao.save(userCustomer);
            return ResponseEntity.ok("El cliente " + userCustomer.getDisplayName() + "se ha eliminado.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
