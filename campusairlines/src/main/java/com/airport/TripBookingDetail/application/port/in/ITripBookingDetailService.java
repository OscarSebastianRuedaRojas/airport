package com.airport.TripBookingDetail.application.port.in;

import java.util.List;

import com.airport.TripBookingDetail.domain.TripBookingDetail;

/**
 * TripBookingDetailService
 */
public interface ITripBookingDetailService {

    TripBookingDetail save(TripBookingDetail tripBookingDetail);
    TripBookingDetail findById(Long id);
    List<TripBookingDetail> findAll();
    void deleteById(Long id);
    TripBookingDetail update(Long id, TripBookingDetail tripBookingDetail);
}