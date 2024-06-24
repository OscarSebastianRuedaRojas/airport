package com.airport.TripulationRol.application.service;

import java.util.List;

import com.airport.TripulationRol.application.port.in.ITripulationRolService;
import com.airport.TripulationRol.domain.TripulationRol;
import com.airport.TripulationRol.infrastructure.adapter.out.TripulationRolRepository;

public class TripulationRolService implements ITripulationRolService{
    
    TripulationRolRepository tripulationRolRepository;

    
    public TripulationRolService() {
        this.tripulationRolRepository = new TripulationRolRepository();
    }

    @Override
    public TripulationRol save(TripulationRol tripulationRol) {
        try {
            TripulationRol newTripulationRol = tripulationRolRepository.save(tripulationRol);
            return newTripulationRol;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TripulationRol> listTripulationRol() {
        try {
            List<TripulationRol> tripulationRols = tripulationRolRepository.findAll();
            return tripulationRols;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}