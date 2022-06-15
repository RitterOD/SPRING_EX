package org.maslov.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @GetMapping("/trolo")
    public String getTrollo() {
        return "APP REST CONTROLLER";
    }
}
