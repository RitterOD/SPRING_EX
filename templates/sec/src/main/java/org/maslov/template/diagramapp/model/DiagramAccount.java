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
public class DiagramAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private DiagramAccountStatus status;

    @OneToMany(mappedBy = "account")
    private List<DiagramWorkspace> workspaces;

    @Column(name = "owner_id")
    private Long ownerId;
}
