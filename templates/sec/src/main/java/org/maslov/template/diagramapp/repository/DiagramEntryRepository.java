package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.DiagramEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagramEntryRepository extends JpaRepository<DiagramEntry, Long> {
}
