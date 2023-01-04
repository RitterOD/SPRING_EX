package org.maslov.template.diagramapp.model.dto;

import lombok.*;
import org.maslov.template.diagramapp.model.DiagramWorkspaceStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DiagramWorkspaceDTO {
    private Long id;
    private String name;
    private DiagramWorkspaceStatus status;
}
