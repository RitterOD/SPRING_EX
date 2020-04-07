package org.maslov.web.servingwebcontent;

import org.maslov.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.maslov.web.service.impl.UserServiceImpl;

@Controller
public class GreetingController {

    UserServiceImpl userService = new UserServiceImpl();
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/loginForm")
    public String loginForm(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "loginForm";
    }

/*
    @RequestMapping("/loginForm")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginForm.html");
        return modelAndView;
    }
*/

    @GetMapping("/registrationForm")
    String registrationForm(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "registrationForm";
    }

    @PostMapping("/loginForm")
    String login(@RequestParam String login, @RequestParam String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        //return userService.login(user);
        return "greeting";
    }

    @PostMapping("/registrationForm")
    String registration(@RequestParam String name,@RequestParam String surname, @RequestParam String login,@RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        //return userService.registration(user);
        return "greeting";
    }

}
