package org.maslov.htmx.app.repository;

import org.maslov.htmx.app.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByMessageContaining(String pattern);
}
