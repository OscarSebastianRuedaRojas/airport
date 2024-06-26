package com.airport.TripCrew.application.port.in;

import java.util.List;

import com.airport.TripCrew.domain.TripCrew;

/**
 * TripCrewService
 */
public interface ITripCrewService {

    TripCrew save(TripCrew tripCrew);
    TripCrew findById(String employeeId, Long connectionId);
    List<TripCrew> findAll();
}