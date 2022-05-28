package org.maslov.antrl4demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    ModelAndView getMain() {
        return new ModelAndView("main");
    }

}
