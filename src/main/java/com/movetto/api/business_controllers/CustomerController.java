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
        List<User> customers = customerDao.findUsersByRolesLike(Role.CUSTOMER);
        return ResponseEntity.ok(customers);
    }

    public ResponseEntity<User> saveCustomer(User user){
        Optional<User> userStored = customerDao.findUserByUid(user.getUid());
        if (userStored.isPresent()){
            User userCustomer = userStored.get();
            if (userCustomer.getRoles().contains(Role.CUSTOMER)){
                ResponseEntity.badRequest().body("Customer Exist");
            } else {
                userCustomer.setCustomerId(user.getCustomerId());
                userCustomer.getRoles().add(Role.CUSTOMER);
                userCustomer.setDirections(user.getDirections());
                customerDao.save(userCustomer);
            }
            return ResponseEntity.ok(userCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updateCustomer(User user){
        Optional<User> userStored = customerDao.findUserByUidAndRolesLike(user.getUid(),Role.CUSTOMER);
        if (userStored.isPresent()){
            User userCustomer = userStored.get();
            userCustomer.setCustomerId(user.getCustomerId());
            userCustomer.setDirections(user.getDirections());
            customerDao.save(userCustomer);
            return ResponseEntity.ok(userCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String deleteCustomer(String uid){
        Optional<User> userStored = customerDao.findUserByUidAndRolesLike(uid,Role.CUSTOMER);
        if (userStored.isPresent()){
            User userCustomer = userStored.get();
            userCustomer.getRoles().remove(Role.PARTNER);
            customerDao.save(userCustomer);
            return "Customer Deleted";
        } else {
            return ResponseEntity.notFound().build().toString();
        }
    }


}
