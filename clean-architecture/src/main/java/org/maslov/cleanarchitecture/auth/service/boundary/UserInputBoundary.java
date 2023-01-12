package org.maslov.cleanarchitecture.auth.service.boundary;

import org.maslov.cleanarchitecture.auth.adapter.rest.UserResponseModel;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel requestModel);
}
