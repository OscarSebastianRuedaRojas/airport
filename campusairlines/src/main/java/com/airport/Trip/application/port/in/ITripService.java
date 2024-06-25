package com.airport.Trip.application.port.in;

import java.util.List;

import com.airport.Trip.domain.Trip;

/**
 * ITripService
 */
public interface ITripService {

    Trip createTrip(Trip trip);
    void updateTrip(Long id, Trip trip);
    void deleteTrip(Long id);
    List<Trip> listTrips();
    Trip findTripById(Long id);
}