package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.CustomerController;
import com.movetto.api.business_controllers.PartnerController;
import com.movetto.api.business_controllers.UserController;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/users";

    public static final String UID = "/{uid}";
    public static final String CUSTOMERS = "/customers";
    public static final String PARTNERS = "/partners";

    private UserController userController;
    private CustomerController customerController;
    private PartnerController partnerController;

    @Autowired
    public UserResource(UserController userController,
                        CustomerController customerController, PartnerController partnerController) {
        this.userController = userController;
        this.customerController = customerController;
        this.partnerController = partnerController;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return userController.readUsers();
    }

    @GetMapping(value = CUSTOMERS)
    public ResponseEntity<List<User>> findAllCustomers(){
        return customerController.readCustomers();
    }

    @GetMapping(value = PARTNERS)
    public ResponseEntity<List<User>> findAllPartners(){
        return partnerController.readPartners();
    }

    @GetMapping(value = UID)
    public ResponseEntity<User> findUserById(@PathVariable String uid){
        return userController.readUserByUid(uid);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return userController.saveUser(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return userController.updateUser(user);
    }

    @PutMapping
    public ResponseEntity<User> updateCustomer(@RequestBody User user){
        return customerController.addCustomerData(user, new Direction());
    }

    @DeleteMapping(value = UID)
    public String deleteUserById(@PathVariable String uid){
        userController.deleteUser(uid);
        return "Deleted user id - " + uid;
    }
}
