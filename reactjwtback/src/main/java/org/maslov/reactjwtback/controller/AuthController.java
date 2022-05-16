package org.maslov.reactjwtback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/auth/signup")
    public String signUp() {
        return null;
    }

    @PostMapping("/api/auth/signin")
    public String signIn() {
        return null;
    }
}
