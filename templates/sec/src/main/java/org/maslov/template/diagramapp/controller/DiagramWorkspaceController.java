package org.maslov.template.diagramapp.controller;

import org.maslov.template.auth.AuthService;
import org.maslov.template.auth.configuration.RestURL;
import org.maslov.template.diagramapp.model.dto.DiagramWorkspaceDTO;
import org.maslov.template.diagramapp.model.mapper.DiagramWorkspaceMapper;
import org.maslov.template.diagramapp.service.DiagramWorkspaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestURL.API_V1_DIAG_WORKSPACES)
public class DiagramWorkspaceController {

    private final DiagramWorkspaceService diagramWorkspaceService;


    private final DiagramWorkspaceMapper diagramWorkspaceMapper;

    private final AuthService authService;

    public DiagramWorkspaceController(DiagramWorkspaceService diagramWorkspaceService, DiagramWorkspaceMapper diagramWorkspaceMapper, AuthService authService) {
        this.diagramWorkspaceService = diagramWorkspaceService;
        this.diagramWorkspaceMapper = diagramWorkspaceMapper;
        this.authService = authService;
    }

    @GetMapping("/all/owner_id")
    public List<DiagramWorkspaceDTO> getAllByDiagramAccount() {
        var user = authService.getUser();
        var workspaces = diagramWorkspaceService.findAllByOwnerId(user.getId());
        return diagramWorkspaceMapper.map(workspaces, null);
    }
}
