package org.maslov.template.diagramapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = Diagram.TABLE_NAME)
public class Diagram {

    public static final String TABLE_NAME = "diagrams";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DiagramStatus status;

    @OneToMany(mappedBy = "diagram")
    private List<DiagramNode> entryList;

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private DiagramWorkspace workspace;

    @Column(name = "owner_id")
    private Long ownerId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
