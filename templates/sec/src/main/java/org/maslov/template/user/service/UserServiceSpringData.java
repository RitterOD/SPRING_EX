package org.maslov.template.user.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.user.model.User;
import org.maslov.template.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceSpringData implements UserService{

    private final UserRepository userRepository;

    public UserServiceSpringData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
