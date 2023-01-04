package org.maslov.template.diagramapp.model.dto;


import lombok.*;
import org.maslov.template.diagramapp.model.DiagramWorkspaceStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NodeDTO {
    private Long id;
    private String text;
    private Long fatherId;
}
