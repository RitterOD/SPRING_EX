package org.maslov.hib.blog.service;

import org.maslov.hib.blog.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author createAuthor(String nickName);

    List<Author> findAll();

    Optional<Author> findById(Long id);
}
