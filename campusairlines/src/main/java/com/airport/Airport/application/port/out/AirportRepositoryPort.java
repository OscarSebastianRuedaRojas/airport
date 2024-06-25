package com.airport.Airport.application.port.out;

import java.util.List;
import com.airport.Airport.domain.Airport;

/**
 * AirportRepositoryPort
 */
public interface AirportRepositoryPort {
    List<Airport> findAll();
    Airport save(Airport airport);
    Airport findById(String id);
    void update(Airport airport);
    void delete(Airport airport);
    

}