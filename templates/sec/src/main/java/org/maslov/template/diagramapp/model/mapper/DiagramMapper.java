package org.maslov.template.diagramapp.model.mapper;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.Diagram;
import org.maslov.template.diagramapp.model.dto.DiagramDTO;
import org.maslov.template.diagramapp.model.dto.NodeDTO;
import org.maslov.template.diagramapp.model.mapper.context.DiagramMapperContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DiagramMapper {

    private final NodeMapper nodeMapper;

    public DiagramMapper(NodeMapper nodeMapper) {
        this.nodeMapper = nodeMapper;
    }

    public DiagramDTO map(Diagram diagram, DiagramMapperContext context) {
        List<NodeDTO> nodeDTOs = null;
        if (context != null && context.isNodesAdded()) {
            nodeDTOs = nodeMapper.map(diagram.getEntryList(), null);
        }
        return DiagramDTO.builder()
                .id(diagram.getId())
                .name(diagram.getName())
                .status(diagram.getStatus())
                .nodes(nodeDTOs)
                .build();
    }

    public List<DiagramDTO> map(List<Diagram> diagrams, DiagramMapperContext context) {
        return  diagrams.stream().map(e -> map(e, null)).collect(Collectors.toList());
    }
}
