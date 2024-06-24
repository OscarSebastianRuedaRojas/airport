package com.airport.FlightFare.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.FlightFare.application.service.FlightFareService;
import com.airport.FlightFare.domain.FlightFare;

/**
 * FlightFareController
 */
public class FlightFareController {

    private FlightFareService flightFareService;
    private Scanner input;

    public FlightFareController() {
        this.flightFareService = new FlightFareService();
        this.input = new Scanner(System.in);
    }

    public void registerFlightfare() {
        try {
            System.out.println("Ingrese nombre de la tarifa");
            String description = input.nextLine();
            System.out.println("Ingrese detalles de la tarifa");
            String details = input.nextLine();
            System.out.println("Ingrese valor de la tarifa");
            Double value = input.nextDouble();
            FlightFare newflightFare = new FlightFare(description, details, value);
            FlightFare createdFlightFare = flightFareService.createFlightFare(newflightFare);
            if (createdFlightFare == null) {
                System.out.println("No se pudo registrar la tarifa.");
            } else {
                System.out.println(
                        "Tarifa registrada correctamente.\n\tNombre: " + createdFlightFare.getDescription() + ".");
            }
        } catch (Exception e) {
            System.out.println("Error: No se pudo crear la tarifa.");
            e.printStackTrace();
        }
    }

    public Long flightFaresList() {
        try {
            System.out.println("Tarifas registradas");
            List<FlightFare> flightFaresList = flightFareService.listFlighFares();
            flightFaresList.forEach(System.out::println);
            System.out.println("Seleccione la tarifa.");
            Long flightFareIndex = input.nextLong();
            return flightFareIndex;
        } catch (Exception e) {
            System.out.println("Error al seleccionar la tarifa");
            e.printStackTrace();
        }
        return null;
    }
}