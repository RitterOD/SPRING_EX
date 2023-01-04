package org.maslov.template.auth.controller;

import org.junit.jupiter.api.Test;
import org.maslov.template.auth.configuration.RestURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(value = AuthController.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    private static final String createUserDTO = "{\"login\":\"user2\", \"password\": \"password\", \"roleType\": \"ROLE_USER\"}";

    @Test
    void authByLoginPassword() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post(RestURL.API_V1_AUTH_CREATE)
                .accept(MediaType.APPLICATION_JSON)
                .content(createUserDTO)
                .contentType(MediaType.APPLICATION_JSON);
            mvc.perform(request).andExpect(status().isOk()).andReturn();

    }
}