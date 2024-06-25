package com.airport.Plane.application.port.in;

import com.airport.Plane.domain.Plane;

/**
 * PlaneService
 */
public interface IPlaneService {
    Plane save(Plane plane);
    Plane consultarPlane(String plates);
    void eliminarPlane(String plates);
    Plane UpdatePlane(String plates, Plane plane);
}