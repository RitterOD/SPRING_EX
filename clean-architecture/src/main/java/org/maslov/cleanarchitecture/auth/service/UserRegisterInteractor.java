package org.maslov.cleanarchitecture.auth.service;

import java.time.LocalDateTime;
import org.maslov.cleanarchitecture.auth.service.boundary.UserDsRequestModel;
import org.maslov.cleanarchitecture.auth.service.boundary.UserInputBoundary;
import org.maslov.cleanarchitecture.auth.adapter.rest.UserPresenter;
import org.maslov.cleanarchitecture.auth.service.boundary.UserRegisterDsGateway;
import org.maslov.cleanarchitecture.auth.service.boundary.UserRequestModel;
import org.maslov.cleanarchitecture.auth.adapter.rest.UserResponseModel;
import org.maslov.cleanarchitecture.auth.entity.User;
import org.maslov.cleanarchitecture.auth.entity.UserFactory;

public class UserRegisterInteractor implements UserInputBoundary {

    final UserRegisterDsGateway userDsGateway;
    final UserPresenter userPresenter;
    final UserFactory userFactory;

    public UserRegisterInteractor(UserRegisterDsGateway userRegisterDfGateway, UserPresenter userPresenter,
        UserFactory userFactory) {
        this.userDsGateway = userRegisterDfGateway;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserResponseModel create(UserRequestModel requestModel) {
        if (userDsGateway.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("User already exists.");
        }
        User user = userFactory.create(requestModel.getName(), requestModel.getPassword());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }
        LocalDateTime now = LocalDateTime.now();
        UserDsRequestModel userDsModel = new UserDsRequestModel(user.getName(), user.getPassword(), now);

        userDsGateway.save(userDsModel);

        UserResponseModel accountResponseModel = new UserResponseModel(user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}