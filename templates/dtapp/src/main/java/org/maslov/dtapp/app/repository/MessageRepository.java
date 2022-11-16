package org.maslov.dtapp.app.repository;

import org.maslov.dtapp.app.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
