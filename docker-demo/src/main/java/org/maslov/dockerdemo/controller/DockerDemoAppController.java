package org.maslov.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoAppController {
    @GetMapping("/")
    public String getMainPage() {
        return "Hello from Docker Demo!";
    }

}
