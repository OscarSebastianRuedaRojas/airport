package com.airport.TripCrew.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Employee.infrastructure.adapter.in.EmployeeController;
import com.airport.FlighConnection.infrastructure.adapter.in.FlightConnectionController;
import com.airport.TripCrew.application.port.in.ITripCrewService;
import com.airport.TripCrew.application.service.TripCrewService;
import com.airport.TripCrew.domain.TripCrew;

/**
 * TripCrewController
 */
public class TripCrewController {
    private ITripCrewService tripCrewService;
    private Scanner input;
    private EmployeeController employeeController;
    private FlightConnectionController connectionController;

    public TripCrewController() {
        this.tripCrewService = new TripCrewService();
        this.input = new Scanner(System.in);
        this.employeeController = new EmployeeController();
        this.connectionController = new FlightConnectionController();
    }

    private TripCrew save() {
        try {
            TripCrew tripCrew = new TripCrew();
            System.out.println("Selecciona el ID del empleado: ");
            tripCrew.setEmployee_id(employeeController.listEmployees());
            System.out.println("Selecciona el ID de la conexión: ");
            tripCrew.setConnection_id(connectionController.listFlightConnections());
            if (tripCrewService.save(tripCrew) != null) {
                System.out.println("La tripulación fue guardada exitosamente");
            }
            return tripCrew;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void listTripCrews() {
        try {
            List<TripCrew> tripCrews = tripCrewService.findAll();
            System.out.println("Tripulaciones disponibles:");
            for (TripCrew tripCrew : tripCrews) {
                System.out.println(String.format("Employee ID: %s, Connection ID: %d", tripCrew.getEmployee_id(), tripCrew.getConnection_id()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void informacionTripCrew() {
        try {
            System.out.println("Ingresa el ID del empleado: ");
            String employeeId = input.nextLine();
            System.out.println("Ingresa el ID de la conexión: ");
            Long connectionId = input.nextLong();
            input.nextLine(); // limpiar el buffer
            TripCrew tripCrew = tripCrewService.findById(employeeId, connectionId);
            if (tripCrew == null) {
                System.out.println("Esta tripulación no existe.");
                return;
            }
            System.out.println("Información de la tripulación:");
            System.out.println("ID del empleado: " + tripCrew.getEmployee_id());
            System.out.println("ID de la conexión: " + tripCrew.getConnection_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarMenuTripCrew() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMenú de Gestión de Tripulaciones");
            System.out.println("1. Registrar tripulación");
            System.out.println("2. Consultar información de tripulación");
            System.out.println("3. Listar tripulaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.informacionTripCrew();
                    break;
                case 3:
                    this.listTripCrews();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}