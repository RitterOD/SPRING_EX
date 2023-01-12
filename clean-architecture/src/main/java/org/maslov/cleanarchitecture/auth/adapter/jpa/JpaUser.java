package org.maslov.cleanarchitecture.auth.adapter.jpa;

import org.maslov.cleanarchitecture.auth.adapter.jpa.model.UserDataMapper;
import org.maslov.cleanarchitecture.auth.adapter.jpa.repository.JpaUserRepository;
import org.maslov.cleanarchitecture.auth.service.boundary.UserDsRequestModel;
import org.maslov.cleanarchitecture.auth.service.boundary.UserRegisterDsGateway;

public class JpaUser implements UserRegisterDsGateway {

    final JpaUserRepository repository;

    JpaUser(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsById(name);
    }

    @Override
    public void save(UserDsRequestModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getName(), requestModel.getPassword(), requestModel.getCreationTime());
        repository.save(accountDataMapper);
    }
}
