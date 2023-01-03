package org.maslov.template.diagramapp.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.repository.DiagramAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiagramAccountDefaultService implements DiagramAccountService{

    private final DiagramAccountRepository diagramAccountRepository;

    public DiagramAccountDefaultService(DiagramAccountRepository diagramAccountRepository) {
        this.diagramAccountRepository = diagramAccountRepository;
    }

    public DiagramAccount createDefaultDiagramAccount(Long ownerId, String ownerLogin) {
        var account = DiagramAccount.builder()
                .ownerId(ownerId)
                .name(ownerLogin)
                .workspaces(List.of())
                .build();
        account = diagramAccountRepository.save(account);
        return account;
    }

}
