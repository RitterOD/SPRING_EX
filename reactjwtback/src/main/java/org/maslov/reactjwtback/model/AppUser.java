package org.maslov.reactjwtback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AppUser {
    @Id
    private Long id;

    @Column
    private String login;

    @Column
    private String password;
}
