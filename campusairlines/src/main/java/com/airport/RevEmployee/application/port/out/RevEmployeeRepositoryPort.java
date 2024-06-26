package com.airport.RevEmployee.application.port.out;

import java.util.List;
import java.util.Optional;

import com.airport.RevEmployee.domain.RevEmployee;

/**
 * RevEmployeeRepositoryPort
 */
public interface RevEmployeeRepositoryPort {

    RevEmployee save(RevEmployee revEmployee);
    Optional<RevEmployee> findById(Long id);
    List<RevEmployee> findAll();
    void deleteById(Long id);
    void update(RevEmployee revEmployee);
}