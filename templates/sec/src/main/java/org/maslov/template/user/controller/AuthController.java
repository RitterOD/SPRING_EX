package org.maslov.template.user.controller;

import org.maslov.template.user.configuration.RestURL;
import org.maslov.template.user.model.CreateUserDTO;
import org.maslov.template.user.model.JWTTokenDTO;
import org.maslov.template.user.model.LoginPasswordDTO;
import org.maslov.template.user.service.JWTUtils;
import org.maslov.template.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestURL.API_V1_AUTH)
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JWTUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<JWTTokenDTO> authByLoginPassword(@RequestBody LoginPasswordDTO loginPasswordDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginPasswordDTO.getLogin(), loginPasswordDTO.getPassword());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = jwtUtils.generateToken(loginPasswordDTO.getLogin());
        return ResponseEntity.ok().body(new JWTTokenDTO(token));
    }

    @PostMapping(RestURL.API_V1_CREATE_REL)
    public ResponseEntity<String> createAccount(@RequestBody CreateUserDTO dto) {
        userService.createUser(dto.getLogin(), dto.getPassword(), dto.getRoleType());
        return ResponseEntity.ok().body("OK");
    }
}
