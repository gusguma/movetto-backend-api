package com.movetto.api.daos;

import com.movetto.api.entities.Customer;
import com.movetto.api.entities.Shipment;
import com.movetto.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShipmentDao extends JpaRepository<Shipment,Integer> {

    Optional<List<Shipment>> findAllByActiveIsTrue();
    Optional<List<Shipment>> findAllByCustomerIsAndActiveTrue(User user);

}
