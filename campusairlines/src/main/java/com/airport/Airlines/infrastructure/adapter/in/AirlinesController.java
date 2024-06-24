package com.airport.Airlines.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;
import com.airport.Airlines.application.service.AirlinesService;
import com.airport.Airlines.domain.Airlines;

/**
 * AirlinesController
 */
public class AirlinesController {
    private AirlinesService airlinesService;
    private Scanner input;

    public AirlinesController() {
        this.airlinesService = new AirlinesService();
        this.input = new Scanner(System.in);
    }

    public void registerAirline() {
        try {
            System.out.println("Ingrese nombre de la nueva aerolinea");
            String airlineName = input.nextLine();
            Airlines newAirline = new Airlines(airlineName);
            Airlines createdAirline = airlinesService.createAirlines(newAirline);
            if (createdAirline == null) {
                System.out.println("No se pudo registrar la aerolinea.");
            } else {
                System.out.println(
                        "Aerolinea registrada correctamente.\n\tNombre: " + createdAirline.getairline_name() + ".");
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar la nueva aerolinea. Reintente.");
            e.printStackTrace();
        }
    }

    public void updateAirline() {
        try {
            Long airlineIndex = airlinesList();
            System.out.print("Ingrese el nuevo nombre: ");
            String newAirlineNamw = input.nextLine();
            airlinesService.updateAirline(airlineIndex, newAirlineNamw);
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la solicitud.");
            e.printStackTrace();
        }
    }

    public void deleteAirline() {
        try {
            Long airlineIndex = airlinesList();
            Airlines toDeleteAirline = airlinesService.findAirlineById(airlineIndex);
            System.out.println("Desea eliminar la aerolinea: " + toDeleteAirline.getairline_name()+"?");
            if (confirmation()) {
                airlinesService.deleteAirline(airlineIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long airlinesList() {
        try {
            System.out.println("Aerolineas registradas");
            List<Airlines> airlines = airlinesService.listAirlines();
            for (Airlines airline : airlines) {
                System.out.println(String.format("%d. %s", airline.getId(), airline.getairline_name()));
            }
            System.out.println("Seleccione la aerolinea.");
            Long airlineIndex = input.nextLong();
            return airlineIndex;
        } catch (Exception e) {
            System.out.println("Error al seleccionar la aerolinea");
            e.printStackTrace();
        }
        return null;
    }
    public boolean confirmation(){
        System.out.println("¿Esta seguro de su eleccion?\n\t1. Sí\n\t2. No.");
        int option = input.nextInt();
        if (option == 1) {
            return true;
        }
        return false;
    }
}