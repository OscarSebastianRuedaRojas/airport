package com.airport.Plane.application.service;

import java.util.List;

import com.airport.Plane.application.port.in.IPlaneService;
import com.airport.Plane.domain.Plane;
import com.airport.Plane.infrastructure.adapter.out.PlaneRepository;

/**
 * PlaneService
 */
public class PlaneService implements IPlaneService{
    private PlaneRepository planeRepository;


    public PlaneService() {
        this.planeRepository = new PlaneRepository();
    }

    @Override
    public Plane save(Plane plane) {
        try {
            Plane newPlane = planeRepository.save(plane);
            return newPlane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Plane consultarPlane(String plates) {
        try {
            Plane plane = planeRepository.findById(plates);
            return plane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminarPlane(String plates) {
        try {
            planeRepository.deletePlane(plates);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane UpdatePlane(String plates, Plane plane) {
        try {
            Plane newPlane = planeRepository.UpdatePlane(plates, plane);
            return newPlane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Plane> findAll(){
        try {
            List<Plane> planes = planeRepository.findAll();
            return planes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}