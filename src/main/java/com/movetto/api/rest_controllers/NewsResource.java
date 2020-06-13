package com.movetto.api.rest_controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.movetto.api.business_controllers.NewsController;
import com.movetto.api.business_controllers.UserController;
import com.movetto.api.dtos.NewsDto;
import com.movetto.api.entities.Direction;
import com.movetto.api.entities.News;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(NewsResource.NEWS)
public class NewsResource {

    public static final String NEWS = "/news";
    public static final String UID = "/{uid}";

    private NewsController newsController;

    @Autowired
    public NewsResource(NewsController newsController) {
        this.newsController = newsController;
    }

    @GetMapping
    public List<NewsDto> findAllNews() throws IOException {
        return newsController.readNews();
    }

    @GetMapping(value = UID)
    public ResponseEntity<List<News>> findNewsByUser(@PathVariable String uid){
        return newsController.findNewsByUsers(uid);
    }

}
