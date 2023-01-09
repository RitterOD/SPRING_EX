package org.maslov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String greeting(){
        return "hello from spring security! custom \n userdetails service!";
    }
}
