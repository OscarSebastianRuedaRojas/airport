package com.airport.TripulationRol.application.port.out;

import java.util.List;

import com.airport.TripulationRol.domain.TripulationRol;

public interface TripulationRolRepositoryPort {
    TripulationRol save(TripulationRol tripulationRol);
    List<TripulationRol> findAll();
}