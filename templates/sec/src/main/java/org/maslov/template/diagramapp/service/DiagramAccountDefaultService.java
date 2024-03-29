package org.maslov.template.diagramapp.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramAccountStatus;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.model.DiagramWorkspaceStatus;
import org.maslov.template.diagramapp.repository.DiagramAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.maslov.template.diagramapp.service.DiagramWorkspaceService.DEFAULT_WORKSPACE_NAME;

@Service
@Slf4j
public class DiagramAccountDefaultService implements DiagramAccountService{

    private final DiagramAccountRepository diagramAccountRepository;

    public DiagramAccountDefaultService(DiagramAccountRepository diagramAccountRepository) {
        this.diagramAccountRepository = diagramAccountRepository;
    }

    public DiagramAccount createDefaultDiagramAccount(Long ownerId, String ownerLogin) {
        var workspace = DiagramWorkspace.builder()
                .name(DEFAULT_WORKSPACE_NAME)
                .status(DiagramWorkspaceStatus.ACTIVE)
                .build();
        var account = DiagramAccount.builder()
                .ownerId(ownerId)
                .name(ownerLogin)
                .status(DiagramAccountStatus.ACTIVE)
                .workspaces(List.of(workspace))
                .build();
        workspace.setAccount(account);
        account = diagramAccountRepository.save(account);
        return account;
    }

    @Override
    public DiagramAccount getRefById(Long id) {
        return diagramAccountRepository.getReferenceById(id);
    }

    @Override
    public List<DiagramAccount> findAllByOwnerId(Long ownerId) {
        return diagramAccountRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public Optional<DiagramAccount> findById(Long id) {
        return diagramAccountRepository.findById(id);
    }

}
