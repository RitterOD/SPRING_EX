package org.maslov.fts.dao;

import org.maslov.fts.model.Document;
import org.maslov.fts.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentDaoImpl implements DocumentDao{
    private DocumentRepository documentRepository;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public DocumentDaoImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
}
