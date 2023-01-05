package org.maslov.template.diagramapp.service;

import org.maslov.template.diagramapp.model.DiagramAccount;

import java.util.List;
import java.util.Optional;

public interface DiagramAccountService {

   DiagramAccount createDefaultDiagramAccount(Long ownerId, String ownerLogin);

   DiagramAccount getRefById(Long id);

   List<DiagramAccount> findAllByOwnerId(Long ownerId);

   Optional<DiagramAccount> findById(Long id);
}
