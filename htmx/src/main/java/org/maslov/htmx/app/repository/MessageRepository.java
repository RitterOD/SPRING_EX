package org.maslov.htmx.app.repository;

import org.maslov.htmx.app.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
