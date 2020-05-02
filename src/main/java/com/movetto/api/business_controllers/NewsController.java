package com.movetto.api.business_controllers;

import com.movetto.api.daos.NewsDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsController {

    private final NewsDao newsDao;
    private final ModelMapper modelMapper;

    @Autowired
    public NewsController(NewsDao newsDao, ModelMapper modelMapper) {
        this.newsDao = newsDao;
        this.modelMapper = modelMapper;
    }
}
