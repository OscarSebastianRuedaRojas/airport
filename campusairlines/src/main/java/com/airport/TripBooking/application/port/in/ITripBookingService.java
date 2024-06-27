package com.airport.TripBooking.application.port.in;

import com.airport.TripBooking.domain.TripBooking;

/**
 * TripBookingService
 */
public interface ITripBookingService {

    TripBooking save(TripBooking tripBooking);
    TripBooking findById(Long id);

}