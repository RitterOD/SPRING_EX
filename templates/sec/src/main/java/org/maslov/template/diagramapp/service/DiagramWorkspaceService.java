package org.maslov.template.diagramapp.service;

import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramWorkspace;

import java.util.List;

public interface DiagramWorkspaceService {
    String DEFAULT_WORKSPACE_NAME = "default_workspace";

    public List<DiagramWorkspace> findAllByDiagramAccount(DiagramAccount diagramAccount);
    public List<DiagramWorkspace> findAllByOwnerId(Long ownerId);
}
