package com.movetto.api.rest_controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PackageResource.PACKAGES)
public class PackageResource {

    public static final String PACKAGES = "/packages";
}
