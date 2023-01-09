package org.maslov.controller;

import org.maslov.model.Otp;
import org.maslov.model.OtpDTO;
import org.maslov.model.User;
import org.maslov.model.UserDTO;
import org.maslov.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {


    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/add")
    public String check() {
        return "CheckAuthController";
    }


    @PostMapping("/user/add")
    public String addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        userService.addUser(user);
        return "User added";
    }

    @PostMapping("/user/auth")
    public void auth(@RequestBody User user) {
        userService.auth(user);
    }


    @PostMapping("/otp/check")
    public void check(@RequestBody OtpDTO dto, HttpServletResponse response) {
        if (userService.check(dto)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

