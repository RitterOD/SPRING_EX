package org.maslov.template.auth.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.DiagramAppService;
import org.maslov.template.auth.model.User;
import org.maslov.template.auth.model.UserRole;
import org.maslov.template.auth.model.UserRoleType;
import org.maslov.template.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserServiceSpringData implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    private final DiagramAppService diagramAppService;

    public UserServiceSpringData(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService, DiagramAppService diagramAppService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.diagramAppService = diagramAppService;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User createUser(String userLogin, String password, UserRoleType role) {
        UserRole userRole = roleService.findByRoleType(role);
        Set<UserRole> roleSet = new HashSet<>();
        roleSet.add(userRole);
        var user = User.builder()
                .username(userLogin)
                .password(passwordEncoder.encode(password))
                .roles(roleSet)
                .build();
        user = userRepository.save(user);
        diagramAppService.createDefaultWorkaround(user.getId(), user.getUsername());
        return user;
    }
}
