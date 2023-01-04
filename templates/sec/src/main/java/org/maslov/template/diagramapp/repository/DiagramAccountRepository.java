package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.DiagramAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagramAccountRepository extends JpaRepository<DiagramAccount, Long> {

    List<DiagramAccount> findAllByOwnerId(Long ownerId);
}
