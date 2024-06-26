package com.airport.RevisionDetail.application.port.out;

import java.util.List;

import com.airport.RevisionDetail.domain.RevisionDetail;

/**
 * RevisionDetailRepositoryPort
 */
public interface RevisionDetailRepositoryPort {
    RevisionDetail save(RevisionDetail revisionDetail);
    List<RevisionDetail> findAll();
    RevisionDetail findById(Long id);
    void deleteById(Long id);
    RevisionDetail update(RevisionDetail revisionDetail);
}