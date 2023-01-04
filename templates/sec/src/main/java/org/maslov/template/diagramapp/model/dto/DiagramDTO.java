package org.maslov.template.diagramapp.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.maslov.template.diagramapp.model.DiagramStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DiagramDTO {
    private Long id;
    private String name;
    private DiagramStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<NodeDTO> nodes;
}
