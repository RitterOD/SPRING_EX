package org.maslov.cleanarchitecture.usercreation;

public interface UserInputBoundary {
    UserResponseModel create(UserRequestModel requestModel);
}
