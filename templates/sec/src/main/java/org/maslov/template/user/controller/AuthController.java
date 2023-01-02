package org.maslov.template.user.controller;

import org.maslov.template.user.configuration.RestURL;
import org.maslov.template.user.model.JWTTokenDTO;
import org.maslov.template.user.model.LoginPasswordDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestURL.API_V1_AUTH)
public class AuthController {

    public ResponseEntity<JWTTokenDTO> authByLoginPassword(@RequestBody LoginPasswordDTO loginPasswordDTO) {
        return ResponseEntity.badRequest().build();
    }
}
