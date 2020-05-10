package com.movetto.api.business_controllers;

import com.movetto.api.daos.TravelDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TravelController {

    private final TravelDao travelDao;

    @Autowired
    public TravelController(TravelDao travelDao) {
        this.travelDao = travelDao;
    }
}
