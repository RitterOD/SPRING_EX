package org.maslov.template.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagramEntry {
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
}
