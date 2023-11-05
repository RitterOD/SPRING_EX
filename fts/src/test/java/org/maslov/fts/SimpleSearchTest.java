package org.maslov.fts;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.junit.jupiter.api.Test;
import org.maslov.fts.service.FtsIndex;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSearchTest {





    @Test
    public void simpleSearch() {
        FtsIndex inMemoryLuceneIndex = new FtsIndex(new  ByteBuffersDirectory(), new StandardAnalyzer());
        inMemoryLuceneIndex.indexDocument("Hello world", "Some hello world ");

        List<Document> documents = inMemoryLuceneIndex.searchIndex("body", "world", 10);

        assertEquals("Hello world", documents.get(0).get("title"));
    }

    @Test
    public void termQuery() {
        FtsIndex inMemoryLuceneIndex = new FtsIndex(new  ByteBuffersDirectory(), new StandardAnalyzer());
        inMemoryLuceneIndex.indexDocument("MCU", "MCUs usually run embedded software");
        inMemoryLuceneIndex.indexDocument("CPU", "CPUs usually run business applications");
        // note put lowcase text in term constructor
        var term = new Term("title", "cpu");
        var query = new TermQuery(term);
        List<Document> docs = inMemoryLuceneIndex.searchIndex(query, 10);
        assertEquals("CPUs usually run business applications", docs.get(0).get("body"));

    }

    @Test
    public void prefixQuery() {
        FtsIndex inMemoryLuceneIndex = new FtsIndex(new  ByteBuffersDirectory(), new StandardAnalyzer());
        inMemoryLuceneIndex.indexDocument("network", "host local");
        inMemoryLuceneIndex.indexDocument("local network", "local host");
        // note put lowcase text in term constructor
        var term = new Term("body", "local");
        var query = new TermQuery(term);
        List<Document> docs = inMemoryLuceneIndex.searchIndex(query, 10);
        assertEquals(2, docs.size());


    }
}
