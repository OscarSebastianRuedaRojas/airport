package com.airport.FlightFare.application.port.in;

import java.util.List;

import com.airport.FlightFare.domain.FlightFare;

/**
 * FlightFareService
 */
public interface IFlightFareService {
    FlightFare createFlightFare(FlightFare flightFare);
    List<FlightFare> listFlighFares();
}