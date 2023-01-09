package org.maslov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "authority")
@Entity
public class Authority {
    @Id
    Long id;

    String name;

    @JoinColumn(name = "User")
    @ManyToOne
    User user;
}