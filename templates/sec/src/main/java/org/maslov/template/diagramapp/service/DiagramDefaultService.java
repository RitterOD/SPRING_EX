package org.maslov.template.diagramapp.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.DiagramNode;
import org.maslov.template.diagramapp.model.DiagramStatus;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.repository.DiagramNodeRepository;
import org.maslov.template.diagramapp.repository.DiagramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class DiagramDefaultService implements DiagramService{

    private final DiagramRepository diagramRepository;
    private final DiagramNodeRepository diagramNodeRepository;

    public DiagramDefaultService(DiagramRepository diagramRepository, DiagramNodeRepository diagramNodeRepository) {
        this.diagramRepository = diagramRepository;
        this.diagramNodeRepository = diagramNodeRepository;
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

    @Override
    public Optional<Diagram> findById(Long id) {
        return diagramRepository.findById(id);
    }

    @Override
    public DiagramNode createDiagramNode(Diagram diagram, String text) {
        DiagramNode node = DiagramNode.builder()
                .diagram(diagram)
                .text(text)
                .build();
        return diagramNodeRepository.save(node);
    }

    @Override
    @Transactional
    public List<DiagramNode> createDiagramEdge(Long from, Long to, Long ownerId) {
        List<DiagramNode> nodes = diagramNodeRepository.findAllByIdIn(List.of(from, to));
        if (nodes.size() != 2) {
            throw new IllegalStateException("Edge can connect only two nodes. Db query return:" + nodes.size() + " for id: " + from + " id: " + to);
        }
        if (!Objects.equals(nodes.get(0).getDiagram().getId(), nodes.get(1).getDiagram().getId())) {
            throw new IllegalStateException("Nodes from different diagrams");
        }
        if (!nodes.get(0).getDiagram().getOwnerId().equals(ownerId)) {
            throw new IllegalStateException("User not owned diagram");
        }
        DiagramNode nodeFrom = nodes.get(0).getId().equals(from) ? nodes.get(0) : nodes.get(1);
        DiagramNode nodeTo = nodes.get(0).getId().equals(to) ? nodes.get(0) : nodes.get(1);
        nodeTo.setFather(nodeFrom);
        diagramNodeRepository.save(nodeTo);
        return nodes;
    }
}
