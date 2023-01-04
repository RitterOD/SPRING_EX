package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = DiagramAccount.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DiagramAccount {

    public static final String TABLE_NAME = "diagram_accounts";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DiagramAccountStatus status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<DiagramWorkspace> workspaces;

    @Column(name = "owner_id")
    private Long ownerId;
}
