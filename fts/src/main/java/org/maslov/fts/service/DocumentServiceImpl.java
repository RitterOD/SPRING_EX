package org.maslov.fts.service;

import org.maslov.fts.dao.DocumentDao;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService{
    public DocumentServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    private DocumentDao documentDao;
}
