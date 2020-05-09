package com.movetto.api.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(NewsResource.NEWS)
public class NewsResource {

    public static final String NEWS = "/news";
}
