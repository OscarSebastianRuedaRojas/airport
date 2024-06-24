package com.airport.FlightFare.application.port.out;

import java.util.List;

import com.airport.FlightFare.domain.FlightFare;

/**
 * FlightFareRepositoryPort
 */
public interface FlightFareRepositoryPort {
    FlightFare save(FlightFare flightFare);
    List<FlightFare> findAll();
    
}