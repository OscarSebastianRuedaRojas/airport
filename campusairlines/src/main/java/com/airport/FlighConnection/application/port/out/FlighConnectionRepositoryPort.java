package com.airport.FlighConnection.application.port.out;

import java.util.List;

import com.airport.FlighConnection.domain.FlightConnection;

/**
 * FlighConnectionRepositoryPort
 */
public interface FlighConnectionRepositoryPort {
    FlightConnection save(FlightConnection flightConnection);
    List<FlightConnection> findAll();
    FlightConnection findById(Long id);
    void delete(Long id);
    FlightConnection update(FlightConnection flightConnection, Long id);
}