package com.airport.TripBooking.application.service;

import com.airport.TripBooking.application.port.in.ITripBookingService;
import com.airport.TripBooking.domain.TripBooking;

/**
 * TripBookingService
 */
public class TripBookingService implements ITripBookingService{

    private TripBookingService tripBookingService;

    

    public TripBookingService() {
        this.tripBookingService = new TripBookingService();
    }

    @Override
    public TripBooking save(TripBooking tripBooking) {
        try {
            TripBooking newTripBooking = tripBookingService.save(tripBooking);
            if (newTripBooking!= null) {
                return newTripBooking;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TripBooking findById(Long id) {
        try {
            TripBooking newTripBooking = tripBookingService.findById(id);
            if (newTripBooking!= null) {
                return newTripBooking;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}