package org.maslov.fts.service;

import org.maslov.fts.model.Document;
import org.maslov.fts.model.DocumentDto;

import java.util.List;

public interface SearchService {

    void addDocument(DocumentDto documentDto);


    List<DocumentDto> search(String pattern, int limit);
}
