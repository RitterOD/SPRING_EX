package org.maslov.liquibaseapp.repository;

import org.maslov.liquibaseapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
