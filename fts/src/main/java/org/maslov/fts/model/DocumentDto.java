package org.maslov.fts.model;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DocumentDto {

    private String title;

    private String text;

    private String author;
}
