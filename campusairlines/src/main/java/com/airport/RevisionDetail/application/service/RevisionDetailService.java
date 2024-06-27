package com.airport.RevisionDetail.application.service;

import java.util.List;
import java.util.Optional;

import com.airport.RevisionDetail.application.port.in.IRevisionDetailService;
import com.airport.RevisionDetail.domain.RevisionDetail;
import com.airport.RevisionDetail.infrastructure.adapter.out.RevisionDetailRepository;

public class RevisionDetailService implements IRevisionDetailService  {
    private RevisionDetailRepository revisionDetailRepository;

    public RevisionDetailService() {
        this.revisionDetailRepository = new RevisionDetailRepository();
    }

    public RevisionDetail save(RevisionDetail revisionDetail) {
        return revisionDetailRepository.save(revisionDetail);
    }

    public List<RevisionDetail> findAll() {
        return revisionDetailRepository.findAll();
    }

    public Optional<RevisionDetail> findById(Long id) {
        return Optional.ofNullable(revisionDetailRepository.findById(id));
    }

    public void deleteById(Long id) {
        revisionDetailRepository.deleteById(id);
    }

    public RevisionDetail update(RevisionDetail revisionDetail) {
        return revisionDetailRepository.update(revisionDetail);
    }
}
