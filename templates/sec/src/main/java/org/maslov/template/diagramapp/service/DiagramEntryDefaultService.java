package org.maslov.template.diagramapp.service;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.diagramapp.repository.DiagramEntryRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiagramEntryDefaultService implements DiagramEntryService{
    private final DiagramEntryRepository diagramEntryRepository;

    public DiagramEntryDefaultService(DiagramEntryRepository diagramEntryRepository) {
        this.diagramEntryRepository = diagramEntryRepository;
    }
}
