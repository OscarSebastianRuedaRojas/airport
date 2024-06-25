package com.airport.FlighConnection.application.port.in;

import java.util.List;

import com.airport.FlighConnection.domain.FlightConnection;

/**
 * FlighConnectionService
 */
public interface IFlighConnectionService {

    FlightConnection createFlightConnection(FlightConnection flightConnection);
    void updateFlightConnection(Long id, FlightConnection flightConnection);
    void deleteFlightConnection(Long id);
    List<FlightConnection> listFlightConnections();
    FlightConnection findFlightConnectionById(Long id);
}