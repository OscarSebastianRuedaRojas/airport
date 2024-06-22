package com.airport.Airlines.application.port.in;

import java.util.List;

import com.airport.Airlines.domain.Airlines;

/**
 * AirlinesService
 */
public interface IAirlinesService {
    Airlines createAirlines(Airlines airline);
    void updateAirline(Long id, String newAirlineNamw);
    void deleteAirline(Long id);
    List<Airlines> listAirlines();
    Airlines findAirlineById(Long id);
    Airlines findAirlineByName(String airlineName);
}