package org.maslov.template.diagramapp.controller;

import org.maslov.template.auth.AuthService;
import org.maslov.template.auth.configuration.RestURL;
import org.maslov.template.diagramapp.model.DiagramStatus;
import org.maslov.template.diagramapp.model.dto.DiagramDTO;
import org.maslov.template.diagramapp.model.mapper.DiagramMapper;
import org.maslov.template.diagramapp.model.request.CreateDiagramRequest;
import org.maslov.template.diagramapp.model.response.CreateDiagramResponse;
import org.maslov.template.diagramapp.service.DiagramService;
import org.maslov.template.diagramapp.service.DiagramWorkspaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RestURL.API_V1_DIAG)
public class DiagramController {

    private final DiagramService diagramService;
    private final DiagramWorkspaceService diagramWorkspaceService;
    private final AuthService authService;

    private final DiagramMapper diagramMapper;

    public DiagramController(DiagramService diagramService, DiagramWorkspaceService diagramWorkspaceService, AuthService authService, DiagramMapper diagramMapper) {
        this.diagramService = diagramService;
        this.diagramWorkspaceService = diagramWorkspaceService;
        this.authService = authService;
      this.diagramMapper = diagramMapper;
    }

    @GetMapping("/all/by_owner_id")
    public ResponseEntity<List<DiagramDTO>> getAllDiagrams() {
      var user = authService.getUser();
      var diagrams = diagramService.findAllByOwnerId(user.getId());
      var dtos = diagrams.stream().map(e -> diagramMapper.map(e, null)).collect(Collectors.toList());
      return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/create")
    public ResponseEntity<DiagramDTO> processCreateDiagramResponse(@RequestBody CreateDiagramRequest createDiagramRequest) {
        var user = authService.getUser();
        var workSpaceOpt = diagramWorkspaceService.findById(createDiagramRequest.getWorkspaceId());
        if (workSpaceOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else if (!Objects.equals(workSpaceOpt.get().getOwnerId(), user.getId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
           var diagram =  diagramService.createDiagram(workSpaceOpt.get(), createDiagramRequest.getDiagramName(), DiagramStatus.ACTIVE, user.getId());
           return ResponseEntity.ok().body(diagramMapper.map(diagram, null));
        }
    }
}
