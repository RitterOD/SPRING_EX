package org.maslov.template.diagramapp.service;

import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.DiagramNode;
import org.maslov.template.diagramapp.model.DiagramStatus;
import org.maslov.template.diagramapp.model.DiagramWorkspace;

import java.util.List;
import java.util.Optional;

public interface DiagramService {

    List<Diagram> findAllByOwnerId(Long ownerId);

    Diagram createDiagram(DiagramWorkspace workspace, String name, DiagramStatus status, Long ownerId);

    Optional<Diagram> findById(Long id);

    DiagramNode createDiagramNode(Diagram diagram, String text);

    List<DiagramNode> createDiagramEdge(Long from, Long to, Long ownerId);

    List<DiagramNode> getAdjacentNode(Long nodeId, Long ownerId);
}
