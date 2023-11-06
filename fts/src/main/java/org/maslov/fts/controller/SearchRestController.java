package org.maslov.fts.controller;

import org.maslov.fts.model.DocumentDto;
import org.maslov.fts.model.SearchDto;
import org.maslov.fts.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchRestController {

    protected SearchService searchService;


    public SearchRestController(SearchService searchService) {
        this.searchService = searchService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> addDocument(@RequestBody DocumentDto documentDto) {
        searchService.addDocument(documentDto);
        return ResponseEntity.ok("OK");
    }


    @PostMapping("/search")
    public ResponseEntity<List<DocumentDto>> searchDocument(@RequestBody SearchDto searchDto) {
        List<DocumentDto> rv = searchService.search(searchDto.getPattern(), searchDto.getLimit());
        return ResponseEntity.ok(rv);
    }


}
