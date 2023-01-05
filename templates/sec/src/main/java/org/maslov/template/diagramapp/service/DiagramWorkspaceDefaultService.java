package org.maslov.template.diagramapp.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.model.DiagramWorkspaceStatus;
import org.maslov.template.diagramapp.repository.DiagramWorkspaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DiagramWorkspaceDefaultService implements DiagramWorkspaceService{

    private final DiagramWorkspaceRepository diagramWorkspaceRepository;

    private final DiagramAccountService diagramAccountService;

    public DiagramWorkspaceDefaultService(DiagramWorkspaceRepository diagramWorkspaceRepository, DiagramAccountService diagramAccountService) {
        this.diagramWorkspaceRepository = diagramWorkspaceRepository;
        this.diagramAccountService = diagramAccountService;
    }

    public List<DiagramWorkspace> findAllByDiagramAccount(DiagramAccount diagramAccount) {
        return diagramWorkspaceRepository.findAllByAccount(diagramAccount);
    }

    @Override
    public List<DiagramWorkspace> findAllByOwnerId(Long ownerId) {
        return diagramWorkspaceRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public Optional<DiagramWorkspace> findById(Long id) {
        return diagramWorkspaceRepository.findById(id);
    }

    @Override
    public DiagramWorkspace createDiagramWorkspace(String name, DiagramWorkspaceStatus status, Long diagramAccountId, Long ownerId) {
        var diagramAccountOpt = diagramAccountService.findById(diagramAccountId);
        if (diagramAccountOpt.isPresent()) {
            var diagramAccount = diagramAccountOpt.get();
            if (diagramAccount.getOwnerId().equals(ownerId)) {
                DiagramWorkspace workspace = DiagramWorkspace.builder()
                        .name(name)
                        .status(status)
                        .ownerId(ownerId)
                        .account(diagramAccount)
                        .build();
                return diagramWorkspaceRepository.save(workspace);
            } else {
                throw new RuntimeException("DiagramAccount.id: " + diagramAccountId + " is not owned by account.id" + ownerId);
            }
        } else {
            throw new RuntimeException("DiagramAccount.id: " + diagramAccountId + " not found");
        }
    }
}
