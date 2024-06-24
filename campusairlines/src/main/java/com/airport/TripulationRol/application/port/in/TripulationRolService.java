package com.airport.TripulationRol.application.port.in;

import java.util.List;

import com.airport.TripulationRol.domain.TripulationRol;

public interface TripulationRolService {
    TripulationRol save(TripulationRol tripulationRol);
    List<TripulationRol> findAll();
}