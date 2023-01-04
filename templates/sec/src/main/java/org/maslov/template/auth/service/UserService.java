package org.maslov.template.auth.service;


import org.maslov.template.auth.model.User;
import org.maslov.template.auth.model.UserRoleType;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);


    User createUser(String userLogin, String password, UserRoleType role);

}
