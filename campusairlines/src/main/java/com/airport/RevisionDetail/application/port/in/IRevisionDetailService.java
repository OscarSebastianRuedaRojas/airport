package com.airport.RevisionDetail.application.port.in;

import java.util.List;
import java.util.Optional;

import com.airport.RevisionDetail.domain.RevisionDetail;

/**
 * RevisionDetailService
 */
public interface IRevisionDetailService {

    RevisionDetail save(RevisionDetail revisionDetail);
    List<RevisionDetail> findAll();
    Optional<RevisionDetail> findById(Long id);
    void deleteById(Long id);
    RevisionDetail update(RevisionDetail revisionDetail);
}