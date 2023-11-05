package org.maslov.fts.dao;

import org.maslov.fts.model.Document;
import org.maslov.fts.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentDaoImpl implements DocumentDao{
    private DocumentRepository documentRepository;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document save(Document document) {
        if (document.getId() == null) {
            document.setId(UUID.randomUUID());
        }
        return documentRepository.save(document);
    }

    public DocumentDaoImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
}
