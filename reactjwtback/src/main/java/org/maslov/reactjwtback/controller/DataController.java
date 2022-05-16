package org.maslov.reactjwtback.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {


    @GetMapping("/api/test/all")
    String retrievePublicContent() {
        return null;
    }

    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    String retrieveUserContent() {
        return "User Content.";
    }

    @GetMapping("/api/test/mod")
    String retrieveModeratorContent() {
        return null;
    }

    @GetMapping("/api/test/admin")
    String retrieveAdminContent() {
        return null;
    }
}
