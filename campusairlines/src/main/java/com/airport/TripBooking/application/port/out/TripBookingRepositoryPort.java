package com.airport.TripBooking.application.port.out;

import com.airport.TripBooking.domain.TripBooking;

/**
 * TripBookingRepositoryPort
 */
public interface TripBookingRepositoryPort {

    TripBooking save(TripBooking tripBooking);
    TripBooking findById(Long id);
    
}