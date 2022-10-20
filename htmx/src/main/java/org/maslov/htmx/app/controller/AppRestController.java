package org.maslov.htmx.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {


    @PostMapping("/clicked")
    public String clicked() {
        return "<h1> Random number from server: " + Math.random() + "</h1>";
    }
}
