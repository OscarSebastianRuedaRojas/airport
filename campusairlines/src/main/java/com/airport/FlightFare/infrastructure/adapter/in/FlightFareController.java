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
            Long flightFareIndex = flightFareService.listFlighFares().get(input.nextInt()-1).getId();
            return flightFareIndex;
        } catch (Exception e) {
            System.out.println("Error al seleccionar la tarifa");
            e.printStackTrace();
        }
        return null;
    }
    public void deleteFlightFare() {
        try {
            Long flightfareId = flightFaresList();
            FlightFare toDeleteFlightFare = flightFareService.findById(flightfareId);
            flightFareService.deleteFlightFare(toDeleteFlightFare);
        } catch (Exception e) {
            System.out.println("Error al eliminar la tarifa.");
           e.printStackTrace();
        }
        System.out.println("Tarifa eliminada correctamente.");
    }
    public void updateFlightFare() {
        System.out.println("Seleccione FlightFare a modificar:");
        // List all FlightFares (assuming you have a method for this)
        long flightFareIndex = flightFaresList();  FlightFare selectedFlightFare = flightFareService.findById(flightFareIndex);
        if (selectedFlightFare == null) {
            System.out.println("FlightFare no encontrado, intente nuevamente.");
            return;
        }
        System.out.println("FlightFare seleccionado: " + selectedFlightFare.getDescription());

        while (true) {
            try {
                System.out.println("1. Modificar descripción\n2. Modificar detalles\n3. Modificar valor\n4. Guardar\n5. Regresar");
                int opc = input.nextInt();
                input.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("Introduzca nueva descripción:");
                        String newDescription = input.nextLine();
                        selectedFlightFare.setDescription(newDescription);
                        System.out.println("Se configuró la descripción: " + newDescription);
                        break;
                    case 2:
                        System.out.println("Modificar detalles:");
                        String newDetails = input.nextLine();
                        selectedFlightFare.setDetails(newDetails);
                        System.out.println("Se configuraron los detalles: " + newDetails);
                        break;
                    case 3:
                        System.out.println("Modificar valor:");
                        double newValue = input.nextDouble();
                        input.nextLine();
                        selectedFlightFare.setValue(newValue);
                        System.out.println("Se configuró el valor: " + newValue);
                        break;
                    case 4:
                        try {
                            flightFareService.updateFlightFare(selectedFlightFare);
                        } catch (Exception e) {
                            System.out.println("Ocurrió un error al actualizar la información del FlightFare.");
                            e.printStackTrace();
                        }
                        System.out.println("Información del FlightFare actualizada correctamente.");
                        return;
                    case 5:
                        return;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                e.printStackTrace();
                input.nextLine();
            }
        }
    }
}