package org.maslov.template.diagramapp.model.mapper;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.model.dto.DiagramWorkspaceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DiagramWorkspaceMapper {
    public DiagramWorkspaceDTO map(DiagramWorkspace diagramWorkspace, Object context) {
        return DiagramWorkspaceDTO.builder()
                .id(diagramWorkspace.getId())
                .name(diagramWorkspace.getName())
                .status(diagramWorkspace.getStatus())
                .build();
    }

    public List<DiagramWorkspaceDTO> map(List<DiagramWorkspace> workspaces, Object context) {
        return  workspaces.stream().map(e -> map(e, null)).collect(Collectors.toList());
    }

}
