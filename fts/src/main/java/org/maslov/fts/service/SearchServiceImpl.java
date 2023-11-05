package org.maslov.fts.service;

import org.maslov.fts.dao.DocumentDao;
import org.maslov.fts.model.Document;
import org.maslov.fts.model.DocumentDto;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SearchServiceImpl implements SearchService{

    protected DirectoryProvider directoryProvider;

    protected AnalyzerProvider analyzerProvider;

    protected DocumentDao documentDao;

    protected FtsIndex currentIndex;

    public SearchServiceImpl(DirectoryProvider directoryProvider, AnalyzerProvider analyzerProvider, DocumentDao documentDao) {
        this.directoryProvider = directoryProvider;
        this.analyzerProvider = analyzerProvider;
        this.documentDao = documentDao;
        currentIndex = new FtsIndex(directoryProvider.getDefaultDirectory(), analyzerProvider.getDefaultAnalyzer());
    }

    @Override
    public void addDocument(DocumentDto documentDto) {
        Document document = new Document();
        document.setText(documentDto.getText());
        document.setTitle(documentDto.getTitle());
        document.setAuthor(documentDto.getAuthor());
        document = documentDao.save(document);
        currentIndex.indexDocument(document.getTitle(), document.getText(), document.getId());
    }

    @Override
    public List<DocumentDto> search(String pattern, int limit) {
        var luceneDocs = currentIndex.searchIndex("body", pattern, limit);
        var rv = new ArrayList<DocumentDto>();
        for(var ld: luceneDocs) {
            // TODO check
            rv.add(new DocumentDto(ld.get("title"), ld.get("body"), ld.get("author")));
        }
        return rv;
    }
}
