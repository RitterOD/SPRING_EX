package org.maslov.fts.service;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class DirectoryProviderImpl implements DirectoryProvider{


    private String directoryLocation;


    public DirectoryProviderImpl(@Value("fts.directory.location") String directoryLocation) {
        this.directoryLocation = directoryLocation;
    }

    @Override
    public Directory getDefaultDirectory() {
        try {
            return new NIOFSDirectory(Path.of(directoryLocation));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
