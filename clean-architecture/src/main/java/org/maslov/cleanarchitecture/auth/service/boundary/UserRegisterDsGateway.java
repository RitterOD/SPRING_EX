package org.maslov.cleanarchitecture.auth.service.boundary;



public interface UserRegisterDsGateway {
    boolean existsByName(String identifier);

    void save(UserDsRequestModel requestModel);
}
