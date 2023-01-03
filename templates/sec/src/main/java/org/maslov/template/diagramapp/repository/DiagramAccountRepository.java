package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.DiagramAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagramAccountRepository extends JpaRepository<DiagramAccount, Long> {
}
