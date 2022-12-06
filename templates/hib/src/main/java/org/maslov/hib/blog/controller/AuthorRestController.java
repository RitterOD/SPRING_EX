package org.maslov.hib.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.hib.blog.model.Author;
import org.maslov.hib.blog.model.dto.CreateAuthorDTO;
import org.maslov.hib.blog.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        return ResponseEntity.ok().body(authorService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorDTO dto) {
        var author = authorService.createAuthor(dto.getNickName());
        return ResponseEntity.ok().body(author);
    }
}
