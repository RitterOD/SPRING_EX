package org.maslov.template.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.repository.DiagramEntryRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiagramEntryServiceImpl implements DiagramEntryService{
    private final DiagramEntryRepository diagramEntryRepository;

    public DiagramEntryServiceImpl(DiagramEntryRepository diagramEntryRepository) {
        this.diagramEntryRepository = diagramEntryRepository;
    }
}
