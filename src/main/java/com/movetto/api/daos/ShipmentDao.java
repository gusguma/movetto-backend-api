package com.movetto.api.daos;

import com.movetto.api.entities.Shipment;
import com.movetto.api.entities.ShipmentStatus;
import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShipmentDao extends JpaRepository<Shipment,Integer> {

    Optional<List<Shipment>> findAllByActiveIsTrue();
    Optional<List<Shipment>> findAllByCustomerIsAndActiveTrue(User user);
    Optional<List<Shipment>> findAllByPartnerAndActiveIsTrue(User partner);
    Optional<List<Shipment>> findShipmentsByCustomerIsNotLikeAndStatusLike(User customer, ShipmentStatus status);
    Optional<List<Shipment>> findShipmentsByPartnerAndStatusIsNotLikeAndStatusIsNotLike(
            User partner, ShipmentStatus status, ShipmentStatus status2);
    Optional<List<Shipment>> findShipmentsByPartnerAndStatusIsLike(User partner, ShipmentStatus status);
}
