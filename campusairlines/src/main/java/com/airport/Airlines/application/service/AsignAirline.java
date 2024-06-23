package com.airport.Airlines.application.service;

import java.util.List;

import com.airport.Airlines.domain.Airlines;
import com.airport.Airlines.infrastructure.adapter.out.AirlinesRepository;

public class AsignAirline {
    private AirlinesRepository airlinesRepository;

    public AsignAirline() {
        this.airlinesRepository = new AirlinesRepository();
    }

    public List<Airlines> getAllAirlines() {
        try {
            List<Airlines> airlinesList = airlinesRepository.findAll();
            return airlinesList;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener todas las aerolineas.");
            e.printStackTrace();
        }
        return null;
    }
}
