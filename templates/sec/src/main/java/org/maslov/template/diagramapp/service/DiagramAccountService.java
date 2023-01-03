package org.maslov.template.diagramapp.service;

import org.maslov.template.diagramapp.model.DiagramAccount;

public interface DiagramAccountService {

    public DiagramAccount createDefaultDiagramAccount(Long ownerId, String ownerLogin);
}
