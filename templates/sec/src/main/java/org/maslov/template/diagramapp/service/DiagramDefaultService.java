package org.maslov.template.diagramapp.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.DiagramStatus;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.repository.DiagramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiagramDefaultService implements DiagramService{

    private final DiagramRepository diagramRepository;

    public DiagramDefaultService(DiagramRepository diagramRepository) {
        this.diagramRepository = diagramRepository;
    }

    @Override
    public List<Diagram> findAllByOwnerId(Long ownerId) {
        return diagramRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public Diagram createDiagram(DiagramWorkspace workspace, String name, DiagramStatus status, Long ownerId) {
        Diagram diagram = Diagram.builder()
                .workspace(workspace)
                .name(name)
                .ownerId(ownerId)
                .status(status)
                .build();
        diagram = diagramRepository.save(diagram);
        return diagram;
    }
}
