package com.airport.Trip.application.port.out;

import java.util.List;

import com.airport.Trip.domain.Trip;

/**
 * TripRepositoryPort
 */
public interface TripRepositoryPort {
    Trip save(Trip trip);
    List<Trip> findAll();
    Trip update(Trip trip, Long id);
    void delete(Long id);
    Trip findById(Long id);
}