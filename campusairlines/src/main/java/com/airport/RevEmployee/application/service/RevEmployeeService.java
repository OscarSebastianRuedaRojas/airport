package com.airport.RevEmployee.application.service;

import java.util.List;
import java.util.Optional;

import com.airport.RevEmployee.application.port.in.IRevEmployeeService;
import com.airport.RevEmployee.domain.RevEmployee;
import com.airport.RevEmployee.infrastructure.adapter.out.RevEmployeeRepository;

/**
 * RevEmployeeService
 */
public class RevEmployeeService implements IRevEmployeeService {
    private RevEmployeeRepository revEmployeeRepository;
    
    public RevEmployeeService() {
        this.revEmployeeRepository = new RevEmployeeRepository();
    }

    @Override
    public void deleteById(Long id) {
        try {
            revEmployeeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<RevEmployee> findAll() {
        try {
            return revEmployeeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<RevEmployee> findById(Long id) {
        try {
            return revEmployeeRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public RevEmployee save(RevEmployee revEmployee) {
        try {
            return revEmployeeRepository.save(revEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(RevEmployee revEmployee) {
        try {
            revEmployeeRepository.update(revEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
}