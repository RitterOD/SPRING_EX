package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = DiagramWorkspace.TABLE_NAME)
public class DiagramWorkspace {


    public static final String TABLE_NAME = "diagram_workspaces";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status",  nullable = false)
    private DiagramWorkspaceStatus status;

    @OneToMany(mappedBy = "workspace")
    private List<Diagram> diagrams;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private DiagramAccount account;

    @Column(name = "owner_id")
    private Long ownerId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
