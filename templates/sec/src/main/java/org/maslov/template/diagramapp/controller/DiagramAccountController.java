package org.maslov.template.diagramapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.auth.AuthService;
import org.maslov.template.auth.configuration.RestURL;
import org.maslov.template.auth.model.SecurityUser;
import org.maslov.template.auth.model.User;
import org.maslov.template.diagramapp.model.dto.DiagramAccountDTO;
import org.maslov.template.diagramapp.model.mapper.DiagramAccountMapper;
import org.maslov.template.diagramapp.service.DiagramAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(RestURL.API_V1_DIAG_ACCOUNTS)
public class DiagramAccountController {
    private final DiagramAccountService diagramAccountService;
    private final DiagramAccountMapper diagramAccountMapper;
    private final AuthService authService;

    public DiagramAccountController(DiagramAccountService diagramAccountService, DiagramAccountMapper diagramAccountMapper, AuthService authService) {
        this.diagramAccountService = diagramAccountService;
        this.diagramAccountMapper = diagramAccountMapper;
        this.authService = authService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DiagramAccountDTO>> getAllByOwnerId() {
        SecurityUser user = authService.getUser();
        var diagramAccounts = diagramAccountService.findAllByOwnerId(user.getId());
        var rv = diagramAccounts.stream().map(e -> diagramAccountMapper.map(e, null)).collect(Collectors.toList());
        return ResponseEntity.ok().body(rv);
    }
}
