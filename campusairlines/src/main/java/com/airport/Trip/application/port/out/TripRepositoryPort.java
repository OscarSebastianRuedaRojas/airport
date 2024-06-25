package com.airport.Trip.application.port.out;

import java.util.ArrayList;

import com.airport.Trip.domain.Trip;

/**
 * TripRepositoryPort
 */
public interface TripRepositoryPort {
    Trip save(Trip trip);
    ArrayList<Trip> findAll();
    Trip update(Trip trip, Long id);
    void delete(Long id);
    Trip findById(Trip trip);
}