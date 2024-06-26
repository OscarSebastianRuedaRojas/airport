package com.airport.Revision.application.service;

import java.util.List;

import com.airport.Revision.application.port.in.IRevisionService;
import com.airport.Revision.application.port.out.RevisionRepositoryPort;
import com.airport.Revision.domain.Revision;
import com.airport.Revision.domain.RevisionDTO;
import com.airport.Revision.infrastructure.adapter.out.RevisionRepository;

public class RevisionService implements IRevisionService {

    private RevisionRepositoryPort revisionRepository;

    public RevisionService() {
        this.revisionRepository = new RevisionRepository();
    }

    public Revision createRevision(Revision revision) {
        try {
            
            return revisionRepository.save(revision);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Revision> getAllRevisions() {
        try {
            return revisionRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Revision getRevision(Long id) {
        try {
            return revisionRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRevision(Revision revision) {
        try {
            revisionRepository.update(revision);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRevision(Long id) {
        try {
            revisionRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<RevisionDTO> getRevisionByPlanePlate(String plate) {
        try {
            return revisionRepository.findByPlanePlate(plate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
