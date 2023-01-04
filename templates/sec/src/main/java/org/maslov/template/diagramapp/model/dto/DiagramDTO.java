package org.maslov.template.diagramapp.model.dto;

import lombok.*;
import org.maslov.template.diagramapp.model.DiagramStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DiagramDTO {
    private Long id;
    private String name;
    private DiagramStatus status;
}
