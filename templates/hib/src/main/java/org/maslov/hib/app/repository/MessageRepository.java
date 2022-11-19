package org.maslov.hib.app.repository;

import org.maslov.hib.app.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
