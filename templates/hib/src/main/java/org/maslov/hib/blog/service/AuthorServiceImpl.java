package org.maslov.hib.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.hib.blog.model.Author;
import org.maslov.hib.blog.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(String nickName) {
        long ts = System.currentTimeMillis();
        var author = Author.builder().nickName(nickName).createdAt(ts).updatedAt(ts).build();
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long  id) {
        return authorRepository.findById(id);
    }
}
