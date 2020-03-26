package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController extends UserController {

    private UserDao customerDao;
    private DirectionController directionController;

    @Autowired
    public CustomerController(UserDao userDao, DirectionController directionController) {
        super(userDao);
        this.customerDao = userDao;
        this.directionController = directionController;
    }

    public ResponseEntity<List<User>> readCustomers(){
        List<User> customers = customerDao.findUsersByCustomerIdIsNotNull();
        return ResponseEntity.ok(customers);
    }

    public ResponseEntity<User> addCustomerData(User user, Direction direction){
        Optional<User> userStored = customerDao.findUserByUid(user.getUid());
        if (userStored.isPresent()){
            User userCustomer = userStored.get();
            userCustomer.setCustomerId(user.getCustomerId());
            userCustomer.getRoles().add(Role.CUSTOMER);
            directionController.saveDirection(user.getUid(),direction);
            return ResponseEntity.ok(userCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
