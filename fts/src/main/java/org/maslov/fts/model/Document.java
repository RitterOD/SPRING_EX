package org.maslov.fts.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "document")
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}