package com.airport.FlightFare.application.service;

import java.util.List;
import com.airport.FlightFare.application.port.in.IFlightFareService;
import com.airport.FlightFare.domain.FlightFare;
import com.airport.FlightFare.infrastructure.adapter.out.FlightFareRepository;

/**
 * FlightFareService
 */
public class FlightFareService implements IFlightFareService {
    private FlightFareRepository flightFareRepository;
    

    public FlightFareService() {
        this.flightFareRepository = new FlightFareRepository();
    }

    @Override
    public FlightFare createFlightFare(FlightFare flightFare) {
        try {
            FlightFare createdFlightFare = flightFareRepository.save(flightFare);
            return createdFlightFare;
        } catch (Exception e) {
            System.out.println("Error: Fallo al registrar tarifa.");
            e.printStackTrace();
        }
        return new FlightFare();
    }

    @Override
    public List<FlightFare> listFlighFares() { 
        try {
            List<FlightFare> flightFares = flightFareRepository.findAll();
            return flightFares;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
} 