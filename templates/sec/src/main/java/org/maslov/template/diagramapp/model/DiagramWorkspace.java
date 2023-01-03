package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
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
