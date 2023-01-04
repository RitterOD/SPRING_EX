package org.maslov.template.diagramapp.model.mapper;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramNode;
import org.maslov.template.diagramapp.model.dto.NodeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NodeMapper {

    public NodeDTO map(DiagramNode diagramEntry, Object context) {
        return NodeDTO.builder()
                .id(diagramEntry.getId())
                .fatherId(diagramEntry.getFather() != null ? diagramEntry.getFather().getId(): null)
                .text(diagramEntry.getText())
                .build();
    }

    public List<NodeDTO> map(List<DiagramNode> nodes, Object context) {
        return  nodes.stream().map(e -> map(e, null)).collect(Collectors.toList());
    }
}
