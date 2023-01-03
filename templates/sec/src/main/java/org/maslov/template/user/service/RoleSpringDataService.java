package org.maslov.template.user.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.user.model.UserRole;
import org.maslov.template.user.model.UserRoleType;
import org.maslov.template.user.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleSpringDataService implements RoleService{

    private final UserRoleRepository userRoleRepository;

    public RoleSpringDataService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole findByRoleType(UserRoleType type) {
        return userRoleRepository.findByRole(type).get();
    }
}
