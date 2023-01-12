package org.maslov.cleanarchitecture.auth.adapter.jpa.repository;

import org.maslov.cleanarchitecture.auth.adapter.jpa.model.UserDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDataMapper, String> {
}
