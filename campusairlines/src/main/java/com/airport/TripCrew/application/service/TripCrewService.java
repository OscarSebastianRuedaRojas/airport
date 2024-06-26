package com.airport.TripCrew.application.service;

import java.util.List;

import com.airport.TripCrew.application.port.in.ITripCrewService;
import com.airport.TripCrew.domain.TripCrew;
import com.airport.TripCrew.infrastructure.adapter.out.TripCrewRepository;

/**
 * TripCrewService
 */
public class TripCrewService implements ITripCrewService{
    private TripCrewRepository tripCrewRepository;

    public TripCrewService() {
        this.tripCrewRepository = new TripCrewRepository();
    }

    @Override
    public TripCrew save(TripCrew tripCrew) {
        try {
            return tripCrewRepository.save(tripCrew);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TripCrew findById(String employeeId, Long connectionId) {
        try {
            return tripCrewRepository.findById(employeeId, connectionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TripCrew> findAll() {
        try {
            return tripCrewRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}