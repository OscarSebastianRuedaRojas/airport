package com.airport.TripBooking.application.service;

import com.airport.TripBooking.application.port.in.ITripBookingService;
import com.airport.TripBooking.domain.TripBooking;
import com.airport.TripBooking.infrastructure.adapter.out.TripBookingRepository;

/**
 * TripBookingService
 */
public class TripBookingService implements ITripBookingService{

    private TripBookingRepository tripBookingRepository;

    

    public TripBookingService() {
        this.tripBookingRepository = new TripBookingRepository();
    }

    @Override
    public TripBooking save(TripBooking tripBooking) {
        try {
            TripBooking newTripBooking = tripBookingRepository.save(tripBooking);
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
            TripBooking newTripBooking = tripBookingRepository.findById(id);
            if (newTripBooking!= null) {
                return newTripBooking;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}