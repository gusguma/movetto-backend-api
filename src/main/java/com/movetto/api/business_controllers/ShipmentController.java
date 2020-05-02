package com.movetto.api.business_controllers;

import com.movetto.api.daos.ShipmentDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ShipmentController {

    private final ShipmentDao shipmentDao;
    private final ModelMapper modelMapper;

    @Autowired
    public ShipmentController(ShipmentDao shipmentDao, ModelMapper modelMapper) {
        this.shipmentDao = shipmentDao;
        this.modelMapper = modelMapper;
    }
}
