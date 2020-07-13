package com.movetto.api.business_services;

import com.movetto.api.dtos.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    private static final String BLOGGER_BASE_URL = "https://www.googleapis.com/blogger/v3/blogs/";
    private static final String POSTS_URL = "/posts";

    private RestTemplate restTemplate;
    private Environment environment;

    @Autowired
    public NewsService(Environment environment) {
        this.restTemplate = new RestTemplate();
        this.environment = environment;
    }

    public List<NewsDto> getNews() {
        String blogId = environment.getProperty("BLOG_ID");
        String apiKey = environment.getProperty("BLOGGER_API_KEY");
        String uri = BLOGGER_BASE_URL + blogId + POSTS_URL + "?key=" + apiKey + "&fetchImages=true";
        ResponseEntity<NewsService.Adapter> response = restTemplate.getForEntity(uri, NewsService.Adapter.class);
        if (response.hasBody()) {
            NewsService.Adapter adapter = response.getBody();
            assert adapter != null;
            return adapter.items;
        }
        return new ArrayList<NewsDto>();
    }

    public static class Adapter {

        private String kind;
        private List<NewsDto> items;
        private String etag;

        @Autowired
        public Adapter(){
            this.kind = "";
            this.items = new ArrayList<NewsDto>();
            this.etag = "";
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public List<NewsDto> getItems() {
            return items;
        }

        public void setItems(List<NewsDto> items) {
            this.items = items;
        }

        public String getEtag() {
            return etag;
        }

        public void setEtag(String etag) {
            this.etag = etag;
        }
    }
}

