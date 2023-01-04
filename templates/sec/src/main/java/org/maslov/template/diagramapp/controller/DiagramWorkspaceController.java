package org.maslov.template.diagramapp.controller;

import org.maslov.template.auth.configuration.RestURL;
import org.maslov.template.diagramapp.model.dto.DiagramWorkspaceDTO;
import org.maslov.template.diagramapp.model.mapper.DiagramWorkspaceMapper;
import org.maslov.template.diagramapp.service.DiagramAccountService;
import org.maslov.template.diagramapp.service.DiagramWorkspaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestURL.API_V1_DIAG_WORKSPACES)
public class DiagramWorkspaceController {

    private final DiagramWorkspaceService diagramWorkspaceService;
    private final DiagramAccountService diagramAccountService;

    private final DiagramWorkspaceMapper diagramWorkspaceMapper;

    public DiagramWorkspaceController(DiagramWorkspaceService diagramWorkspaceService, DiagramAccountService diagramAccountService, DiagramWorkspaceMapper diagramWorkspaceMapper) {
        this.diagramWorkspaceService = diagramWorkspaceService;
        this.diagramAccountService = diagramAccountService;
        this.diagramWorkspaceMapper = diagramWorkspaceMapper;
    }

    @GetMapping("/all")
    public List<DiagramWorkspaceDTO> getAllByDiagramAccount(Long diagramAccountId) {
        var diagramAccount = diagramAccountService.getRefById(diagramAccountId);
        var workspaces = diagramWorkspaceService.findAllByDiagramAccount(diagramAccount);
        return diagramWorkspaceMapper.map(workspaces, null);
    }
}
