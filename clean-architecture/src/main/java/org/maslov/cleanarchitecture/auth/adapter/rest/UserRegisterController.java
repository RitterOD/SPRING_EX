package org.maslov.cleanarchitecture.auth.adapter.rest;

import org.maslov.cleanarchitecture.auth.service.boundary.UserInputBoundary;
import org.maslov.cleanarchitecture.auth.service.boundary.UserRequestModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {

    final UserInputBoundary userInput;

    UserRegisterController(UserInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    @PostMapping("/user")
    UserResponseModel create(@RequestBody UserRequestModel requestModel) {
        return userInput.create(requestModel);
    }
}
