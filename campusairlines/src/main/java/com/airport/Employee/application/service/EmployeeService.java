package com.airport.Employee.application.service;

import java.util.List;

import com.airport.Employee.application.port.in.IEmployeeService;
import com.airport.Employee.domain.Employee;
import com.airport.Employee.infrastructure.adapter.out.EmployeeRepository;

/**
 * EmployeeService
 */
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
        try {
            employeeRepository.update(employee, id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(String id) {
        try {
            employeeRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> listEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee findEmployeeById(String id) {
        try {
            return employeeRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
}