package org.maslov.fts.service;

import org.maslov.fts.model.DocumentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    protected DirectoryProvider directoryProvider;

    public SearchServiceImpl(DirectoryProvider directoryProvider) {
        this.directoryProvider = directoryProvider;

    }

    @Override
    public void addDocument(DocumentDto documentDto) {

    }

    @Override
    public List<DocumentDto> search(String pattern, int limit) {
        return List.of();
    }
}
