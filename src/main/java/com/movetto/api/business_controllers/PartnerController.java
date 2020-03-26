package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PartnerController extends UserController {

    private UserDao partnerDao;

    @Autowired
    public PartnerController(UserDao userDao) {
        super(userDao);
        this.partnerDao = userDao;
    }

    public ResponseEntity<List<User>> readPartners(){
        List<User> partners = partnerDao.findUsersByPartnerIdIsNotNull();
        return ResponseEntity.ok(partners);
    }
}
