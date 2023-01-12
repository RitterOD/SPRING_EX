package org.maslov.cleanarchitecture.auth.adapter.rest;

public interface UserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);
}
