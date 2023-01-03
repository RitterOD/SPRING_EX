package org.maslov.template.user.repository;

import org.maslov.template.user.model.UserRole;
import org.maslov.template.user.model.UserRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByRole(UserRoleType type);
}
