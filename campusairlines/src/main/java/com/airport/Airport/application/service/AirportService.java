package com.airport.Airport.application.service;

import java.util.List;
import com.airport.Airport.application.port.in.IAirportService;
import com.airport.Airport.domain.Airport;
import com.airport.Airport.infrastructure.adapter.out.AirportRepository;

/**
 * AirportService
 */
public class AirportService implements IAirportService {
    private AirportRepository airportRepository;
    

    public AirportService( ) {
        this.airportRepository = new AirportRepository();
    }

    @Override
    public Airport createAirport(Airport airport) {
        try {
            Airport createdAirport = airportRepository.save(airport);
            return createdAirport;
        } catch (Exception e) {
           System.out.println("Error al guardar el aeropuerto.");
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Airport> listAirports() {
        try {
            List<Airport> airportList = airportRepository.findAll();
            return airportList;
        } catch (Exception e) {
            System.out.println("Error al recuperar los aeropuertos.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airport getAirportInformation(String Id) {
        try {
            Airport airport = airportRepository.findById(Id);
            return airport;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAirportInformation(Airport airport) {
        try {
            airportRepository.update(airport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAirport(Airport airport) {
        try {
            airportRepository.delete(airport);
            System.out.println("Aeropuerto eliminado");
        } catch (Exception e) {
            System.out.println("Error al eliminar el aeropuerto.");
            e.printStackTrace();
        }
    }

    
}