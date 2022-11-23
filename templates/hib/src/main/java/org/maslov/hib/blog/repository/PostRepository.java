package org.maslov.hib.blog.repository;

import org.maslov.hib.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
