package org.maslov.template.diagramapp.service;

import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.DiagramStatus;
import org.maslov.template.diagramapp.model.DiagramWorkspace;

import java.util.List;

public interface DiagramService {

    List<Diagram> findAllByOwnerId(Long ownerId);

    Diagram createDiagram(DiagramWorkspace workspace, String name, DiagramStatus status, Long ownerId);
}
