package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.Diagram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagramRepository extends JpaRepository<Diagram, Long> {
    List<Diagram> findAllByOwnerId(Long ownerId);
}
