package org.maslov.fts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "document")
public class Document {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "title",  columnDefinition = "TEXT")
    private String title;

    @Column(name = "text",  columnDefinition = "TEXT")
    private String text;


    @Column(name = "author",  columnDefinition = "TEXT")
    private String author;
}