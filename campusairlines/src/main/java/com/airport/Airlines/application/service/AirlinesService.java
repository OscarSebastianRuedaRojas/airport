package com.airport.Airlines.application.service;

import java.util.List;

import com.airport.Airlines.application.port.in.IAirlinesService;
import com.airport.Airlines.domain.Airlines;
import com.airport.Airlines.infrastructure.adapter.out.AirlinesRepository;

/**
 * AirlinesService
 */
public class AirlinesService implements IAirlinesService {
    private AirlinesRepository airlinesRepository;
    public AirlinesService() {
        this.airlinesRepository = new AirlinesRepository();
    }
    @Override
    public Airlines createAirlines(Airlines airline) {
        try {
            Airlines createdAirline = airlinesRepository.save(airline);
            return createdAirline;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void updateAirline(Long id, String newAirlineNamw) {
        try {
            airlinesRepository.update(id, newAirlineNamw);
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
    }
    @Override
    public void deleteAirline(Long id) {
        try {
            airlinesRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
    }
    @Override
    public List<Airlines> listAirlines() {
        try {
            List<Airlines> airlinesList = airlinesRepository.findAll();
            return airlinesList;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Airlines findAirlineById(Long id) {
        try {
            Airlines airline = airlinesRepository.findById(id);
            return airline;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Airlines findAirlineByName(String airlineName) {
        try {
            Airlines airline = airlinesRepository.findByName(airlineName);
            return airline;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }
    
}