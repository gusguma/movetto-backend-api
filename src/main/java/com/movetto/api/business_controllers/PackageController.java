package com.movetto.api.business_controllers;

import com.movetto.api.daos.PackageDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PackageController {

    private final PackageDao packageDao;
    private final ModelMapper modelMapper;

    @Autowired
    public PackageController(PackageDao packageDao, ModelMapper modelMapper) {
        this.packageDao = packageDao;
        this.modelMapper = modelMapper;
    }
}
