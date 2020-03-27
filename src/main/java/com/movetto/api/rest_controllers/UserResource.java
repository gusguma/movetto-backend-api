package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.*;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.User;
import com.movetto.api.entities.Vehicle;
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
    public static final String DIRECTIONS = "/directions";
    public static final String VEHICLES = "/vehicles";

    private UserController userController;
    private CustomerController customerController;
    private PartnerController partnerController;
    private DirectionController directionController;
    private VehicleController vehicleController;

    @Autowired
    public UserResource(UserController userController,
                        CustomerController customerController,
                        PartnerController partnerController,
                        DirectionController directionController,
                        VehicleController vehicleController) {
        this.userController = userController;
        this.customerController = customerController;
        this.partnerController = partnerController;
        this.directionController = directionController;
        this.vehicleController = vehicleController;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return userController.readUsers();
    }

    @GetMapping(value = UID)
    public ResponseEntity<User> findUserByUid(@PathVariable String uid){
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

    @DeleteMapping(value = UID)
    public String deleteUser(@PathVariable String uid){
        return userController.deleteUser(uid);
    }

    @GetMapping(value = CUSTOMERS)
    public ResponseEntity<List<User>> findAllCustomers(){
        return customerController.readCustomers();
    }

    @PostMapping(value = CUSTOMERS)
    public ResponseEntity<User> saveCustomer(@RequestBody User user){
        return customerController.saveCustomer(user);
    }

    @PutMapping(value = CUSTOMERS)
    public ResponseEntity<User> updateCustomer(@RequestBody User user){
        return customerController.updateCustomer(user);
    }

    @DeleteMapping(value = CUSTOMERS + UID)
    public String deleteCustomer(@PathVariable String uid){
        return customerController.deleteCustomer(uid);
    }

    @GetMapping(value = PARTNERS)
    public ResponseEntity<List<User>> findAllPartners(){
        return partnerController.readPartners();
    }

    @PostMapping(value = PARTNERS)
    public ResponseEntity<User> savePartner(@RequestBody User user){
        return partnerController.savePartner(user);
    }

    @PutMapping(value = PARTNERS)
    public ResponseEntity<User> updatePartner(@RequestBody User user){
        return partnerController.updatePartner(user);
    }

    @DeleteMapping(value = PARTNERS + UID)
    public String deletePartner(@PathVariable String uid){
        return partnerController.deletePartner(uid);
    }

    @GetMapping(value = UID + DIRECTIONS)
    public ResponseEntity<List<Direction>> findUserDirections(@PathVariable String uid){
        return directionController.findUserDirections(uid);
    }

    @GetMapping(value = UID + VEHICLES)
    public ResponseEntity<List<Vehicle>> findUserVehicles(@PathVariable String uid){
        return vehicleController.findUserVehicles(uid);
    }
}
