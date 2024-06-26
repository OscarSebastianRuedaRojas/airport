package com.airport.Revision.application.port.out;

import java.util.List;

import com.airport.Revision.domain.Revision;

/**
 * RevisionRepositoryPort
 */
public interface RevisionRepositoryPort {
    Revision save(Revision revision);
    Revision findById(Long id);
    List<Revision> findAll();
    void update(Revision revision);
    void delete(Long id);
    
}