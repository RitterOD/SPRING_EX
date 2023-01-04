package org.maslov.template.auth.repository;

import org.maslov.template.auth.model.UserRole;
import org.maslov.template.auth.model.UserRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByRole(UserRoleType type);
}
