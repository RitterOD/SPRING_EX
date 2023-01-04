package org.maslov.template.diagramapp.repository;

import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagramWorkspaceRepository extends JpaRepository<DiagramWorkspace, Long> {

    List<DiagramWorkspace> findAllByAccount(DiagramAccount diagramAccount);
    List<DiagramWorkspace> findAllByOwnerId(Long ownerId);
}
