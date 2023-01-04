package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = DiagramEntry.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagramEntry {


    public static final String TABLE_NAME = "diagram_entries";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private Long text;

    @OneToMany(mappedBy = "father")
    private List<DiagramEntry> entries;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private DiagramEntry father;

    @ManyToOne
    @JoinColumn(name = "diagram_id")
    private Diagram diagram;
}
