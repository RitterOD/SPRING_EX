package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.Diagram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagramRepository extends JpaRepository<Diagram, Long> {
}
