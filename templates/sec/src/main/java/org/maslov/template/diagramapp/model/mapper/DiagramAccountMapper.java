package org.maslov.template.diagramapp.model.mapper;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.model.DiagramAccount;
import org.maslov.template.diagramapp.model.DiagramWorkspace;
import org.maslov.template.diagramapp.model.dto.DiagramAccountDTO;
import org.maslov.template.diagramapp.model.dto.DiagramWorkspaceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DiagramAccountMapper {
    public DiagramAccountDTO map(DiagramAccount diagramAccount, Object context) {
        return DiagramAccountDTO.builder()
                .id(diagramAccount.getId())
                .name(diagramAccount.getName())
                .status(diagramAccount.getStatus())
                .ownerId(diagramAccount.getOwnerId())
                .build();
    }

    public List<DiagramAccountDTO> map(List<DiagramAccount> accounts, Object context) {
        return  accounts.stream().map(e -> map(e, null)).collect(Collectors.toList());
    }
}
