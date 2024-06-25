package com.airport.Employee.application.port.out;

import java.util.List;

import com.airport.Employee.domain.Employee;

/**
 * EmployeeRepositoryPort
 */
public interface EmployeeRepositoryPort {

    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(String id);
    void delete(String id);
    Employee update(Employee employee, String id);
}