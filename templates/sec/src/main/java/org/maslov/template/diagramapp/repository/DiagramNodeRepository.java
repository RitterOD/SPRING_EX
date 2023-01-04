package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.DiagramNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagramNodeRepository extends JpaRepository<DiagramNode, Long> {

    List<DiagramNode> findAllByIdIn(Iterable<Long> ids);
}
