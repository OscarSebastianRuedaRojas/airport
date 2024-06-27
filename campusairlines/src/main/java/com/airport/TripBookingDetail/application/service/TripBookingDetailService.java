package com.airport.TripBookingDetail.application.service;

import java.util.List;

import com.airport.TripBookingDetail.application.port.in.ITripBookingDetailService;
import com.airport.TripBookingDetail.domain.TripBookingDetail;
import com.airport.TripBookingDetail.infrastructure.adapter.out.TripBookingDetailRepository;

/**
 * TripBookingDetailService
 */
public class TripBookingDetailService implements ITripBookingDetailService{

    private final TripBookingDetailRepository tripBookingDetailRepository;

    public TripBookingDetailService() {
        this.tripBookingDetailRepository = new TripBookingDetailRepository();
    }

    @Override
    public TripBookingDetail save(TripBookingDetail tripBookingDetail) {
        return tripBookingDetailRepository.save(tripBookingDetail);
    }

    @Override
    public TripBookingDetail findById(Long id) {
        return tripBookingDetailRepository.findById(id);
    }

    @Override
    public List<TripBookingDetail> findAll() {
        return tripBookingDetailRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        tripBookingDetailRepository.deleteById(id);
    }

    @Override
    public TripBookingDetail update(Long id, TripBookingDetail tripBookingDetail) {
        return tripBookingDetailRepository.update(id, tripBookingDetail);
    }
}