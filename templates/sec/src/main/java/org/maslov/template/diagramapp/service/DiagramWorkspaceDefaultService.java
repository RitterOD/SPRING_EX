package org.maslov.template.diagramapp.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.repository.DiagramWorkspaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiagramWorkspaceDefaultService implements DiagramWorkspaceService{

    private final DiagramWorkspaceRepository diagramWorkspaceRepository;

    public DiagramWorkspaceDefaultService(DiagramWorkspaceRepository diagramWorkspaceRepository) {
        this.diagramWorkspaceRepository = diagramWorkspaceRepository;
    }

    public List<DiagramWorkspace> findAllByDiagramAccount(DiagramAccount diagramAccount) {
        return diagramWorkspaceRepository.findAllByAccount(diagramAccount);
    }

    @Override
    public List<DiagramWorkspace> findAllByOwnerId(Long ownerId) {
        return diagramWorkspaceRepository.findAllByOwnerId(ownerId);
    }
}
