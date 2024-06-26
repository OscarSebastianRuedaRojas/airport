package com.airport.TripCrew.application.port.out;

import java.util.List;

import com.airport.TripCrew.domain.TripCrew;

/**
 * TripCrewRepositoryPort
 */
public interface TripCrewRepositoryPort {

    TripCrew save(TripCrew tripCrew);
    TripCrew findById(String employeeId, Long connectionId);
    List<TripCrew> findAll();
}