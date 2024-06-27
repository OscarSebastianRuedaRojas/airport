package com.airport.RevEmployee.application.port.in;

import java.util.List;
import java.util.Optional;
import com.airport.RevEmployee.domain.RevEmployee;

/**
 * RevEmployeeService
 */
public interface IRevEmployeeService {

    RevEmployee save(RevEmployee revEmployee);
    Optional<RevEmployee> findById(Long id);
    List<RevEmployee> findAll();
    void deleteById(Long id);
    void update(RevEmployee revEmployee);
}