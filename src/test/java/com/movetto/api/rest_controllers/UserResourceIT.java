package com.movetto.api.rest_controllers;

import com.movetto.api.dtos.UserMinimumDto;
import com.movetto.api.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class UserResourceIT {

    private static final String UID = "/t6bpbrIi8Ba8C0AxMYL8nWB1mqi2";
    private static final String EMAIL = "/gusguma@gmail.com";

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
        User user = this.webTestClient
                .get().uri(UserResource.USERS + "/564d")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(User.class)
                .returnResult().getResponseBody();
        assertNull(user);
    }

    @Test
    void testFindUserByEmailExist() {
        User user = this.webTestClient
                .get().uri(UserResource.USERS + UserResource.EMAIL + EMAIL)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .returnResult().getResponseBody();
        assertNotNull(user);
        assertEquals(8, user.getId());
    }

    @Test
    void testFindUserByEmailNotExist() {
        User user = this.webTestClient
                .get().uri(UserResource.USERS + UserResource.EMAIL + "/xxx@gmail.com")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(User.class)
                .returnResult().getResponseBody();
        assertNull(user);
    }

    @Test
    void testSaveUserOk() {
        String uid = String.valueOf(new Date().getTime());
        UserMinimumDto user = new UserMinimumDto("Test", "test@" + uid + ".com", "test" + uid);
        UserMinimumDto userResponse = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(user))
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserMinimumDto.class)
                .returnResult().getResponseBody();
        assertEquals(userResponse.getUid(), user.getUid());
    }

    @Test
    void testSaveUserConflict() {
        UserMinimumDto user = new UserMinimumDto("Gustavo", "xxx@gmail.com", "t6bpbrIi8Ba8C0AxMYL8nWB1mqi2");
        UserMinimumDto userResponse = this.webTestClient
                .post().uri(UserResource.USERS)
                .body(BodyInserters.fromObject(user))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT)
                .expectBody(UserMinimumDto.class)
                .returnResult().getResponseBody();
        assertNull(userResponse);
    }
}
