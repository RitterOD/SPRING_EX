package org.maslov.dockercomposedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;

@Controller
public class ComposeDemoAppController {

    @GetMapping
    public ModelAndView getMainPage() {
        return new ModelAndView("main");
    }
}
