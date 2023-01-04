package org.maslov.template.diagramapp.service;

import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramWorkspace;

import java.util.List;
import java.util.Optional;

public interface DiagramWorkspaceService {
    String DEFAULT_WORKSPACE_NAME = "default_workspace";

    List<DiagramWorkspace> findAllByDiagramAccount(DiagramAccount diagramAccount);
    List<DiagramWorkspace> findAllByOwnerId(Long ownerId);

    Optional<DiagramWorkspace> findById(Long id);


}
