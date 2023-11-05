package org.maslov.fts.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.springframework.stereotype.Service;

@Service
public class AnalyzerProviderImpl implements AnalyzerProvider{


    @Override
    public Analyzer getDefaultAnalyzer() {
        return new StandardAnalyzer();
    }
}
