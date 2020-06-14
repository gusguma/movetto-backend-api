package com.movetto.api.business_controllers;

import com.movetto.api.business_services.NewsService;
import com.movetto.api.daos.NewsDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.NewsDto;
import com.movetto.api.entities.News;
import com.movetto.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class NewsController {

    private final NewsDao newsDao;
    private final UserDao userDao;
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsDao newsDao, UserDao userDao, NewsService newsService) {
        this.newsDao = newsDao;
        this.userDao = userDao;
        this.newsService = newsService;
    }

    public List<NewsDto> readNews() throws IOException {
        return newsService.getNews();
    }

    public ResponseEntity<List<News>> findNewsByUsers(String uid) {
        Optional<User> userStored = userDao.findUserByUid(uid);
        Set<User> users = new HashSet<>();
        if (userStored.isPresent()){
            User user = userStored.get();
            users.add(user);
            return newsDao.findAllByUsers(users)
                    .map(ResponseEntity::ok)
                    .orElseGet(()->ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
