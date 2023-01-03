package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "diagrams")
public class Diagram {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private DiagramStatus status;

    @OneToMany(mappedBy = "diagram")
    private List<DiagramEntry> entryList;

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private DiagramWorkspace workspace;
}
