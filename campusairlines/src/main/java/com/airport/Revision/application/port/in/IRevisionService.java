package com.airport.Revision.application.port.in;

import java.util.List;

import com.airport.Revision.domain.Revision;
import com.airport.Revision.domain.RevisionDTO;

/**
 * RevisionService
 */
public interface IRevisionService {
    Revision createRevision(Revision revision);
    Revision getRevision(Long id);
    List<Revision> getAllRevisions();
    void updateRevision(Revision revision);
    void deleteRevision(Long id);
    List<RevisionDTO> getRevisionByPlanePlate(String plate);

}