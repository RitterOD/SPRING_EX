package org.maslov.hib.blog.repository;

import org.maslov.hib.blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
