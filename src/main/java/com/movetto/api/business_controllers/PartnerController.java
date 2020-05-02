package com.movetto.api.business_controllers;

import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.UserDto;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.User;

import com.movetto.api.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class PartnerController extends UserController {

    private UserDao partnerDao;

    @Autowired
    public PartnerController(UserDao userDao) {
        super(userDao);
        this.partnerDao = userDao;
    }

    public ResponseEntity<List<User>> readPartners(){
        return partnerDao.findUsersByRolesLike(Role.PARTNER)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<User> readPartner(String uid, Role role){
        return this.partnerDao.findUserByUidAndRolesLike(uid, role)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> savePartner(UserDto user){
        Optional<User> userExist = partnerDao.findUserByUid(user.getUid());
        Optional<User> userPartnerExist = partnerDao
                .findUserByUidAndRolesLike(user.getUid(),Role.PARTNER);
        if(userPartnerExist.isPresent()){
            return ResponseEntity
                    .status(HttpStatus.FOUND).build();
        } else if (userExist.isPresent()){
            User userPartnerNew = userExist.get();
            userPartnerNew.setPartner(user.getPartner());
            userPartnerNew.getRoles().add(Role.PARTNER);
            userPartnerNew.setDirections(user.getDirections());
            partnerDao.save(userPartnerNew);
            return ResponseEntity.ok(userPartnerNew);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updatePartner(UserDto user){
        Optional<User> userStored = partnerDao
                .findUserByUidAndRolesLike(user.getUid(),Role.PARTNER);
        if (userStored.isPresent()){
            User userPartnerUpdated = userStored.get();
            userPartnerUpdated.setPartner(user.getPartner());
            userPartnerUpdated.setDirections(user.getDirections());
            partnerDao.save(userPartnerUpdated);
            return ResponseEntity.ok(userPartnerUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deletePartner(String uid){
        Optional<User> userStored = partnerDao.findUserByUidAndRolesLike(uid,Role.PARTNER);
        if (userStored.isPresent()){
            User userPartner = userStored.get();
            userPartner.getRoles().remove(Role.PARTNER);
            partnerDao.save(userPartner);
            return ResponseEntity.ok("El colaborador " + userPartner.getDisplayName() + "se ha eliminado.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Set<Vehicle>> findUserVehiclesByUid(String  uid){
        Optional<User> user = partnerDao.findUserByUidAndRolesLike(uid, Role.PARTNER);
        if (user.isPresent()){
            Set<Vehicle> vehicles = user.get().getPartner().getVehicles();
            return ResponseEntity.ok(vehicles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
