package com.airport.Employee.application.port.in;

import java.util.List;

import com.airport.Employee.domain.Employee;

/**
 * IEmployeeService
 */
public interface IEmployeeService {

    Employee createEmployee(Employee employee);
    void updateEmployee(String id, Employee employee);
    void deleteEmployee(String id);
    List<Employee> listEmployees();
    Employee findEmployeeById(String id);
}