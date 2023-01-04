package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.DiagramNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagramNodeRepository extends JpaRepository<DiagramNode, Long> {
}
