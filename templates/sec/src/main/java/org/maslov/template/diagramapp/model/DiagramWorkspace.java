package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "diagram_worksapce")
public class DiagramWorkspace {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private DiagramWorkspaceStatus status;

    @OneToMany(mappedBy = "workspace")
    private List<Diagram> diagrams;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private DiagramAccount account;
}
