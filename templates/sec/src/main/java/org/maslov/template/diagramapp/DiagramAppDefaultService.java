package org.maslov.template.diagramapp;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.service.DiagramAccountService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiagramAppDefaultService implements DiagramAppService{

    private final DiagramAccountService diagramAccountService;

    public DiagramAppDefaultService(DiagramAccountService diagramAccountService) {
        this.diagramAccountService = diagramAccountService;
    }

    public void createDefaultWorkaround(Long ownerId, String ownerLogin) {
        diagramAccountService.createDefaultDiagramAccount(ownerId, ownerLogin);
    }
}
