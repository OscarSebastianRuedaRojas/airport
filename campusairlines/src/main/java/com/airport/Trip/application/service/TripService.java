package com.airport.Trip.application.service;

import java.sql.Date;
import java.util.List;

import com.airport.Trip.application.port.in.ITripService;
import com.airport.Trip.domain.Trip;
import com.airport.Trip.infrastructure.adapter.out.TripRepository;

/**
 * TripService
 */
public class TripService implements ITripService {

    private TripRepository tripRepository;

    public TripService() {
        this.tripRepository = new TripRepository();
    }

    @Override
    public Trip createTrip(Trip trip) {
        try {
            Trip createdTrip = tripRepository.save(trip);
            return createdTrip;
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTrip(Long id, Trip trip) {
        try {
            tripRepository.update(trip, id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTrip(Long id) {
        try {
            tripRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Trip> listTrips() {
        try {
            List<Trip> tripsList = tripRepository.findAll();
            return tripsList;
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Trip findTripById(Long id) {
        try {
            Trip trip = tripRepository.findById(id);
            return trip;
        } catch (Exception e) {
            System.out.println("Ocurrió una interrupción del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Trip findTripByDateDepartureCityArrivalCity(String departureCityId, String destinationCityId,
            Date tripDate) {
        try {
            return tripRepository.findTripByDateDepartureCityArrivalCity(departureCityId, destinationCityId, tripDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}