package org.maslov.hib.app.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.maslov.hib.app.model.listener.MessageListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
@EntityListeners({MessageListener.class})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    private String text;
}
