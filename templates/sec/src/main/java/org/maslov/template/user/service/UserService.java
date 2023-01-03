package org.maslov.template.user.service;


import org.maslov.template.user.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
}
