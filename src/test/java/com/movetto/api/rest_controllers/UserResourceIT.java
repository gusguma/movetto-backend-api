package com.movetto.api.rest_controllers;

import com.movetto.api.dtos.UserMinimumDto;
import com.movetto.api.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class UserResourceIT {

    private static final String UID = "/t6bpbrIi8Ba8C0AxMYL8nWB1mqi2";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindAllUsers() {
        List<UserMinimumDto> users = this.webTestClient
                .get().uri(UserResource.USERS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UserMinimumDto.class)
                .returnResult().getResponseBody();
        assertNotNull(users);
        assertNotEquals(0, users.size());
    }

    @Test
    void testFindUserByUidExist() {
        User user = this.webTestClient
                .get().uri(UserResource.USERS + UID)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .returnResult().getResponseBody();
        assertNotNull(user);
        assertEquals(8, user.getId());
    }

    @Test
    void testFindUserByUidNotExist() {
        this.webTestClient
                .get().uri(UserResource.USERS + "/564d")
                .exchange()
                .expectStatus()
                .isNotFound();
    }

}
