package org.maslov.fts;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.maslov.fts.service.InMemoryLuceneIndex;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSearchTest {

    InMemoryLuceneIndex inMemoryLuceneIndex = new InMemoryLuceneIndex(new  ByteBuffersDirectory(), new StandardAnalyzer());



    @Test
    public void simpleSearch() {
        inMemoryLuceneIndex.indexDocument("Hello world", "Some hello world ");

        List<Document> documents = inMemoryLuceneIndex.searchIndex("body", "world", 10);

        assertEquals("Hello world", documents.get(0).get("title"));
    }
}
