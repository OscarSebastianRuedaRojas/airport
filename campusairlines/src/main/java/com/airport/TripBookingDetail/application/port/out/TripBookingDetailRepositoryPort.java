package com.airport.TripBookingDetail.application.port.out;

import java.util.List;

import com.airport.TripBookingDetail.domain.TripBookingDetail;

/**
 * TripBookingDetailRepositoryPort
 */
public interface TripBookingDetailRepositoryPort {

    TripBookingDetail save(TripBookingDetail tripBookingDetail);
    TripBookingDetail findById(Long id);
    List<TripBookingDetail> findAll();
    void deleteById(Long id);
    TripBookingDetail update(Long id, TripBookingDetail tripBookingDetail);
}