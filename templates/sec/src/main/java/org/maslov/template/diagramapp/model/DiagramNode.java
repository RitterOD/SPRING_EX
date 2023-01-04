package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = DiagramNode.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DiagramNode {


    public static final String TABLE_NAME = "diagram_entries";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @OneToMany(mappedBy = "father")
    private List<DiagramNode> entries;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private DiagramNode father;

    @ManyToOne
    @JoinColumn(name = "diagram_id")
    private Diagram diagram;
}
