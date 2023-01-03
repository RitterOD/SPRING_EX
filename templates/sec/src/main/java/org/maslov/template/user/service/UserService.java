package org.maslov.template.user.service;


import org.maslov.template.user.model.User;
import org.maslov.template.user.model.UserRoleType;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);


    User createUser(String userLogin, String password, UserRoleType role);
}
