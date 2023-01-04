package org.maslov.template.diagramapp.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiagramNodeRequest {
    private Long diagramId;
    private String text;
}
