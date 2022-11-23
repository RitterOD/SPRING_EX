package org.maslov.hib.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;


    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "created_at")
    @CreatedDate
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id", nullable=false)
    private List<Post> post;
}
