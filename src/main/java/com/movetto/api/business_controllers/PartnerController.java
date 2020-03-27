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
public class PartnerController extends UserController {

    private UserDao partnerDao;

    @Autowired
    public PartnerController(UserDao userDao) {
        super(userDao);
        this.partnerDao = userDao;
    }

    public ResponseEntity<List<User>> readPartners(){
        List<User> partners = partnerDao.findUsersByRolesLike(Role.PARTNER);
        return ResponseEntity.ok(partners);
    }

    public ResponseEntity<User> savePartner(User user){
        Optional<User> userStored = partnerDao.findUserByUid(user.getUid());
        if (userStored.isPresent()){
            User userPartner = userStored.get();
            if (userPartner.getRoles().contains(Role.PARTNER)){
                ResponseEntity.badRequest().body("Partner Exist");
            } else {
                userPartner.setPartnerId(user.getPartnerId());
                userPartner.setDriverId(user.getDriverId());
                userPartner.getRoles().add(Role.PARTNER);
                userPartner.setDirections(user.getDirections());
                partnerDao.save(userPartner);
            }
            return ResponseEntity.ok(userPartner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updatePartner(User user){
        Optional<User> userStored = partnerDao.findUserByUidAndRolesLike(user.getUid(),Role.PARTNER);
        if (userStored.isPresent()){
            User userPartner = userStored.get();
            userPartner.setPartnerId(user.getPartnerId());
            userPartner.setDriverId(user.getDriverId());
            userPartner.setDirections(user.getDirections());
            partnerDao.save(userPartner);
            return ResponseEntity.ok(userPartner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String deletePartner(String uid){
        Optional<User> userStored = partnerDao.findUserByUidAndRolesLike(uid,Role.PARTNER);
        if (userStored.isPresent()){
            User userPartner = userStored.get();
            userPartner.getRoles().remove(Role.PARTNER);
            partnerDao.save(userPartner);
            return "Partner Deleted";
        } else {
            return ResponseEntity.notFound().build().toString();
        }
    }
}
