package com.airport.FlighConnection.application.service;

import java.util.List;

import com.airport.FlighConnection.application.port.in.IFlighConnectionService;
import com.airport.FlighConnection.domain.FlightConnection;
import com.airport.FlighConnection.infrastructure.adapter.out.FlightConnectionRepository;

/**
 * FlighConnectionService
 */
public class FlightConnectionService implements IFlighConnectionService{

    private FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionService() {
        this.flightConnectionRepository = new FlightConnectionRepository();
    }

    @Override
    public FlightConnection createFlightConnection(FlightConnection flightConnection) {
        try {
            return flightConnectionRepository.save(flightConnection);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateFlightConnection(Long id, FlightConnection flightConnection) {
        try {
            flightConnectionRepository.update(flightConnection, id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlightConnection(Long id) {
        try {
            flightConnectionRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public List<FlightConnection> listFlightConnections() {
        try {
            return flightConnectionRepository.findAll();
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FlightConnection findFlightConnectionById(Long id) {
        try {
            return flightConnectionRepository.findById(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
}