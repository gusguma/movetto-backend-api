package com.movetto.api.business_controllers;

import com.movetto.api.daos.TravelDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.TravelDto;
import com.movetto.api.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TravelController {

    private final TravelDao travelDao;
    private final UserDao userDao;

    @Autowired
    public TravelController(TravelDao travelDao, UserDao userDao) {
        this.travelDao = travelDao;
        this.userDao = userDao;
    }

    public ResponseEntity<List<Travel>> readTravels() {
        return travelDao.findAllByActiveIsTrue()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Travel>> readTravelsByUserUid(String uid) {
        Optional<User> userStored = userDao.findUserByUidAndRolesLike(uid, Role.CUSTOMER);
        return userStored.map(user -> travelDao.findAllByCustomerIsAndActiveTrue(user)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Travel> readTravelById(int id) {
        return travelDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Travel>> readTravelsByPartnerUid(String uid) {
        Optional<User> userStored = userDao.findUserByUidAndRolesLike(uid, Role.PARTNER);
        return userStored.map(user -> travelDao.findAllByPartnerAndActiveIsTrue(user)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Travel>> readTravelsAvailable(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        return userStored.map(user ->
                travelDao.findTravelsByCustomerIsNotLikeAndStatusLike(user, TravelStatus.PAID)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Travel>> readTravelsPending(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        return userStored.map(user ->
                travelDao.findTravelsByPartnerAndStatusIsNotLikeAndStatusIsNotLike(
                        user, TravelStatus.PAID, TravelStatus.FINISHED)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Travel>> readTravelsFinished(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        return userStored.map(user ->
                travelDao.findTravelsByPartnerAndStatusIsLike(user, TravelStatus.FINISHED)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Travel> saveTravel(TravelDto travelDto) {
        if (readTravelById(travelDto.getId()).hasBody()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Travel travel = setNewTravelData(travelDto);
            travelDao.save(travel);
            return ResponseEntity.ok(travel);
        }
    }

    public ResponseEntity<Travel> updateTravel(TravelDto travelDto) {
        return travelDao.findById(travelDto.getId())
                .map(travel -> {
                    travel.setStartDirection(travelDto.getStartDirection());
                    travel.setEndDirection(travelDto.getEndDirection());
                    travel.setPeople(travelDto.getPeople());
                    travel.setDistance(travelDto.getDistance());
                    travel.setStart(travelDto.getStart());
                    travel.setEnd(travelDto.getEnd());
                    travel.setPriceTravel(travelDto.getPriceTravel());
                    travel.setStatus(travelDto.getStatus());
                    travel.setPartner(travelDto.getPartner());
                    travel.setVehicle(travelDto.getVehicle());
                    travelDao.save(travel);
                    return ResponseEntity.ok(travel);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Travel> deleteTravel(int id){
        return travelDao.findById(id)
                .map(shipment -> {
                    shipment.setActive(false);
                    shipment.setStatus(TravelStatus.DELETED);
                    travelDao.save(shipment);
                    return ResponseEntity.ok(shipment);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Travel setNewTravelData(TravelDto travelDto) {
        Travel travel = new Travel(
                travelDto.getCustomer(),
                travelDto.getStartDirection(),
                travelDto.getEndDirection()
        );
        travel.setPeople(travelDto.getPeople());
        travel.setStart(travelDto.getStart());
        travel.setEnd(travelDto.getEnd());
        travel.setDistance(travelDto.getDistance());
        travel.setPriceTravel(travelDto.getPriceTravel());
        travel.setStatus(travelDto.getStatus());
        return travel;
    }
}
