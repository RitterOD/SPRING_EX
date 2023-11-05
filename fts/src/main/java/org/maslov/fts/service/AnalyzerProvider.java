package org.maslov.fts.service;

import org.apache.lucene.analysis.Analyzer;

public interface AnalyzerProvider {
    Analyzer getDefaultAnalyzer();
}
