package com.airport.TripulationRol.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.TripulationRol.application.service.TripulationRolService;
import com.airport.TripulationRol.domain.TripulationRol;

public class TripulationRolController {

    TripulationRolService tripulationRolService;
    Scanner input;

    public TripulationRolController() {
        this.tripulationRolService = new TripulationRolService();
        this.input = new Scanner(System.in);
    }

    public void registerTripulationRol(){
        try {
            TripulationRol tripulationRol = new TripulationRol();
            System.out.println("Ingresa el nombre del rol de la tripulacion");
            tripulationRol.setRol_name(input.nextLine());
            tripulationRolService.save(tripulationRol);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long listTripulationRol(){
        try {
            System.out.println("Roles de la tripulacion disponibles: ");
            List<TripulationRol> tripulation_roles = tripulationRolService.listTripulationRol();
            for (TripulationRol tripulationRol : tripulation_roles) {
                System.out.println(String.format("%d. %s", tripulationRol.getId(), tripulationRol.getRol_name()));
            }
            Long id = input.nextLong();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}