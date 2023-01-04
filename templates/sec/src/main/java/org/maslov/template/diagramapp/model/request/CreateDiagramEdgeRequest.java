package org.maslov.template.diagramapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiagramEdgeRequest {
    private Long fromId;
    private Long toId;
}
