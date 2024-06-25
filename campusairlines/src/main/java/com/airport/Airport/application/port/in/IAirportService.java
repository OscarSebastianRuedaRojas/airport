package com.airport.Airport.application.port.in;

import java.util.List;

import com.airport.Airport.domain.Airport;

/**
 * AirportService
 */
public interface IAirportService {

    Airport createAirport(Airport airport);
    List<Airport> listAirports();
    Airport getAirportInformation(String Id);
    void updateAirportInformation(Airport airport);
    void deleteAirport(Airport airport);
    
    
}