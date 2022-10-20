package org.maslov.htmx.app.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MessageView {
    private Long id;

    private String message;
}
