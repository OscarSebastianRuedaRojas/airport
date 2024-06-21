package com.airport.Airlines.application.port.out;

import java.util.List;

import com.airport.Airlines.domain.Airlines;

/**
 * AirlinesRepositoryPort
 */
public interface AirlinesRepositoryPort {
    Airlines findById(Long id); 
    List<Airlines> findAll();
}