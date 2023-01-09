package org.maslov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    @GetMapping
    ModelAndView getMainPage() {
        return new ModelAndView("main");
    }
}
