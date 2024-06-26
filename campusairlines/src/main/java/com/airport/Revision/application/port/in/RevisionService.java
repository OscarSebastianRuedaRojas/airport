package com.airport.Revision.application.port.in;

import java.util.List;

import com.airport.Revision.domain.Revision;

/**
 * RevisionService
 */
public interface RevisionService {
    Revision cretaRevision(Revision revision);
    Revision getRevision(Long id);
    List<Revision> getAllRevisions();
    void updateRevisiom(Revision revision);
    void deleteRevision(Long id);
    Revision getRevisionByPlanePlate(String plate);

}