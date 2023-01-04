package org.maslov.template.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.auth.model.UserRole;
import org.maslov.template.auth.model.UserRoleType;
import org.maslov.template.auth.repository.UserRoleRepository;
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
