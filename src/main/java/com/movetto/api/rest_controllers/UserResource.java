package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.*;
import com.movetto.api.dtos.UserDto;
import com.movetto.api.dtos.UserMinimumDto;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import com.movetto.api.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {

    public static final String USERS = "/users";

    public static final String USER_UID = "/{uid}";
    public static final String CUSTOMERS = "/customers";
    public static final String PARTNERS = "/partners";
    public static final String DIRECTIONS = "/directions";
    public static final String VEHICLES = "/vehicles";

    private final UserController userController;
    private final CustomerController customerController;
    private final PartnerController partnerController;

    @Autowired
    public UserResource(UserController userController,
                        CustomerController customerController,
                        PartnerController partnerController) {
        this.userController = userController;
        this.customerController = customerController;
        this.partnerController = partnerController;
    }

    @GetMapping
    public List<UserMinimumDto> findAllUsers(){
        return userController.readUsers();
    }

    @GetMapping(value = USER_UID)
    public ResponseEntity<User> findUserByUid(@PathVariable String uid){
        return userController.readUserByUid(uid);
    }

    @PostMapping
    public ResponseEntity<UserMinimumDto> saveUser(@RequestBody UserMinimumDto user){
        return userController.saveUser(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto user){
        return userController.updateUser(user);
    }

    @DeleteMapping(value = USER_UID)
    public ResponseEntity<String> deleteUser(@PathVariable String uid){
        return userController.deleteUser(uid);
    }

    @GetMapping(value = CUSTOMERS)
    public ResponseEntity<List<User>> findAllCustomers(){
        return customerController.readCustomers();
    }

    @GetMapping(value = CUSTOMERS + USER_UID)
    public ResponseEntity<User> findUserCustomer(@PathVariable String uid){
        return customerController.readCustomer(uid, Role.CUSTOMER);
    }

    @PostMapping(value = CUSTOMERS)
    public ResponseEntity<User> saveCustomer(@RequestBody UserDto user){
        return customerController.saveCustomer(user);
    }

    @PutMapping(value = CUSTOMERS)
    public ResponseEntity<User> updateCustomer(@RequestBody UserDto user){
        return customerController.updateCustomer(user);
    }

    @DeleteMapping(value = CUSTOMERS + USER_UID)
    public ResponseEntity<String> deleteCustomer(@PathVariable String uid){
        return customerController.deleteCustomer(uid);
    }

    @GetMapping(value = PARTNERS)
    public ResponseEntity<List<User>> findAllPartners(){
        return partnerController.readPartners();
    }

    @GetMapping(value = PARTNERS + USER_UID)
    public ResponseEntity<User> findUserPartner(@PathVariable String uid){
        return partnerController.readPartner(uid, Role.PARTNER);
    }

    @PostMapping(value = PARTNERS)
    public ResponseEntity<User> savePartner(@RequestBody UserDto user){
        return partnerController.savePartner(user);
    }

    @PutMapping(value = PARTNERS)
    public ResponseEntity<User> updatePartner(@RequestBody UserDto user){
        return partnerController.updatePartner(user);
    }

    @DeleteMapping(value = PARTNERS + USER_UID)
    public ResponseEntity<String> deletePartner(@PathVariable String uid){
        return partnerController.deletePartner(uid);
    }

    @GetMapping(value = USER_UID + DIRECTIONS)
    public ResponseEntity<Set<Direction>> findUserDirections(@PathVariable String uid){
        return userController.findUserDirectionsByUid(uid);
    }

    @GetMapping(value = USER_UID + VEHICLES)
    public ResponseEntity<Set<Vehicle>> findUserVehicles(@PathVariable String uid){
        return partnerController.findUserVehiclesByUid(uid);
    }
}
