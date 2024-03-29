package org.maslov.services.security.proxy;

import org.maslov.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationServerProxy {


    private final RestTemplate rest;
    private final String baseUrl;

    public AuthenticationServerProxy(RestTemplate rest, @Value("${auth.server.base.url}") String baseUrl) {
        this.rest = rest;
        this.baseUrl = baseUrl;
    }


    public void sendAuth(String username,
                         String password) {
        String url = baseUrl + "/user/auth";

        var body = new User();
        body.setUsername(username);
        body.setPassword(password);
        var request = new HttpEntity<>(body);
        rest.postForEntity(url, request, Void.class);
    }


    public boolean sendOTP(String username,
                           String code) {
        String url = baseUrl + "/otp/check";
        var body = new User();
        body.setUsername(username);
        body.setCode(code);

        var request = new HttpEntity<>(body);
        var response = rest.postForEntity(url, request, Void.class);
        return response
                .getStatusCode()
                .equals(HttpStatus.OK);

    }
}

