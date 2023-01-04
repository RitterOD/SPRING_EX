package org.maslov.template.auth.service;

import org.maslov.template.auth.model.UserRole;
import org.maslov.template.auth.model.UserRoleType;

public interface RoleService {

    UserRole findByRoleType(UserRoleType type);
}
