package com.airport.Trip.application.port.in;

import java.util.ArrayList;

import com.airport.Trip.domain.Trip;

/**
 * ITripService
 */
public interface ITripService {

    Trip register(Trip trip);
    ArrayList<Trip> findAll();
    Trip update(Trip trip, Long id);
    void delete(Long id);
    Trip findById(Trip trip);
}