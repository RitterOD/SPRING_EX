package org.maslov.template.repository;

import org.maslov.template.model.DiagramEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagramEntryRepository extends JpaRepository<DiagramEntry, Long> {
}
