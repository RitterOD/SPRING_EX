package org.maslov.fts.service;

import org.apache.lucene.store.Directory;

public interface DirectoryProvider {
    Directory getDefaultDirectory();
}
