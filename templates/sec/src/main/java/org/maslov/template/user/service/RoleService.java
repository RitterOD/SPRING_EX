package org.maslov.template.user.service;

import org.maslov.template.user.model.UserRole;
import org.maslov.template.user.model.UserRoleType;

public interface RoleService {

    UserRole findByRoleType(UserRoleType type);
}
