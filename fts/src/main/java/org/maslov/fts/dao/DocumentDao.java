package org.maslov.fts.dao;

import org.maslov.fts.model.Document;

import java.util.List;

public interface DocumentDao {
    List<Document> findAll();

    Document save(Document document);
}
