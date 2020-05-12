package com.movetto.api.business_controllers;

import com.movetto.api.daos.ShipmentDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class ShipmentController {

    private final ShipmentDao shipmentDao;
    private final UserDao userDao;

    @Autowired
    public ShipmentController(ShipmentDao shipmentDao, UserDao userDao) {
        this.shipmentDao = shipmentDao;
        this.userDao = userDao;
    }

    public ResponseEntity<List<Shipment>> readShipments() {
        Optional<List<Shipment>> shipmentsStored = shipmentDao.findAllByActiveIsTrue();
        if (shipmentsStored.isPresent()){
            List<Shipment> shipments = shipmentsStored.get();
            return ResponseEntity.ok(shipments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Shipment>> findShipmentsByUserUid(String uid) {
        List<Shipment> shipment = new ArrayList<>();
        Optional<User> userStored = userDao.findUserByUidAndRolesLike(uid, Role.CUSTOMER);
        if (userStored.isPresent()){
            Customer customer = userStored.get().getCustomer();
            shipment = getShipmentsByCustomer(customer);
        }
        if (shipment.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(shipment);
        }
    }

    public List<Shipment> getShipmentsByCustomer(Customer customer){
        return shipmentDao.findAllByCustomerIs(customer);
    }
}
