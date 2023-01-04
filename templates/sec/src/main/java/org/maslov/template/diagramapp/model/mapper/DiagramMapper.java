package org.maslov.template.diagramapp.model.mapper;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.model.dto.DiagramDTO;
import org.maslov.template.diagramapp.model.dto.DiagramWorkspaceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DiagramMapper {
    public DiagramDTO map(Diagram diagram, Object context) {
        return DiagramDTO.builder()
                .id(diagram.getId())
                .name(diagram.getName())
                .status(diagram.getStatus())
                .build();
    }

    public List<DiagramDTO> map(List<Diagram> diagrams, Object context) {
        return  diagrams.stream().map(e -> map(e, null)).collect(Collectors.toList());
    }
}
