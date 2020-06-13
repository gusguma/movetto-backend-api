package com.movetto.api.business_controllers;

import com.movetto.api.daos.ShipmentDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.ShipmentDto;
import com.movetto.api.entities.Role;
import com.movetto.api.entities.Shipment;
import com.movetto.api.entities.ShipmentStatus;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

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
        return shipmentDao.findAllByActiveIsTrue()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Shipment>> readShipmentsByUserUid(String uid) {
        Optional<User> userStored = userDao.findUserByUidAndRolesLike(uid, Role.CUSTOMER);
        return userStored.map(user -> shipmentDao.findAllByCustomerIsAndActiveTrue(user)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Shipment> readShipmentById(int id) {
        return shipmentDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Shipment>> readShipmentsByPartnerUid(String uid) {
        Optional<User> userStored = userDao.findUserByUidAndRolesLike(uid, Role.PARTNER);
        return userStored.map(user -> shipmentDao.findAllByPartnerAndActiveIsTrue(user)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Shipment>> readShipmentsAvailable(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        return userStored.map(user ->
                shipmentDao.findShipmentsByCustomerIsNotLikeAndStatusLike(user, ShipmentStatus.PAID)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Shipment>> readShipmentsPending(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        return userStored.map(user ->
                shipmentDao.findShipmentsByPartnerAndStatusIsNotLikeAndStatusIsNotLike(
                        user, ShipmentStatus.PAID, ShipmentStatus.FINISHED)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Shipment>> readShipmentsFinished(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        return userStored.map(user ->
                shipmentDao.findShipmentsByPartnerAndStatusIsLike(user, ShipmentStatus.FINISHED)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Shipment> saveShipment(ShipmentDto shipmentDto) {
        if (readShipmentById(shipmentDto.getId()).hasBody()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Shipment shipment = setNewShipmentData(shipmentDto);
            shipmentDao.save(shipment);
            return ResponseEntity.ok(shipment);
        }
    }

    public ResponseEntity<Shipment> updateShipment(ShipmentDto shipmentDto) {
        return shipmentDao.findById(shipmentDto.getId())
                .map(shipment -> {
                    shipment.setStartDirection(shipmentDto.getStartDirection());
                    shipment.setEndDirection(shipmentDto.getEndDirection());
                    shipment.setDestinationUser(shipmentDto.getDestinationUser());
                    shipment.setPackages(shipmentDto.getPackages());
                    shipment.setStatus(shipmentDto.getStatus());
                    shipment.setPartner(shipmentDto.getPartner());
                    shipment.setVehicle(shipmentDto.getVehicle());
                    shipmentDao.save(shipment);
                    return ResponseEntity.ok(shipment);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Shipment> deleteShipment(int id){
        return shipmentDao.findById(id)
                .map(shipment -> {
                    shipment.setActive(false);
                    shipment.setStatus(ShipmentStatus.DELETED);
                    shipmentDao.save(shipment);
                    return ResponseEntity.ok(shipment);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Shipment setNewShipmentData(ShipmentDto shipmentDto) {
        Shipment shipment = new Shipment(
                shipmentDto.getCustomer(),
                shipmentDto.getStartDirection(),
                shipmentDto.getEndDirection(),
                shipmentDto.getDestinationUser()
        );
        shipment.setPackages(shipmentDto.getPackages());
        return shipment;
    }

}
