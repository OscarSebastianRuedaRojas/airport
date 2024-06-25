package com.airport.Plane.application.port.out;

import java.util.List;

import com.airport.Plane.domain.Plane;

/**
 * PlaneRepositoryPort
 */
public interface PlaneRepositoryPort {
    Plane save(Plane plane);
    Plane findById(String plates);
    List<Plane> findAll();
    void deletePlane(String plates);
    Plane UpdatePlane(String plates, Plane plane);
}