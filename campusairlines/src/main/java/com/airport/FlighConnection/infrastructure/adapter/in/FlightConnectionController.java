package com.airport.FlighConnection.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;
import com.airport.Airport.infrastructure.adapter.in.AirportController;
import com.airport.FlighConnection.application.service.FlightConnectionService;
import com.airport.FlighConnection.domain.FlightConnection;
import com.airport.Plane.domain.Plane;
import com.airport.Plane.infrastructure.adapter.in.PlaneController;
import com.airport.Trip.infrastructure.adapter.in.TripController;

/**
 * FlightConnectionController
 */
public class FlightConnectionController {

    private FlightConnectionService flightConnectionService;
    private AirportController airportController;
    private PlaneController planeController;
    private TripController tripController;

    private Scanner input;

    public FlightConnectionController() {
        this.flightConnectionService = new FlightConnectionService();
        this.input = new Scanner(System.in);
        this.planeController = new PlaneController();
        this.tripController = new TripController();
        this.airportController = new AirportController();
    }

    public FlightConnection save() {
        try {
            FlightConnection flightConnection = new FlightConnection();
            System.out.println("Ingresa el número de conexión: ");
            flightConnection.setConnection_number(input.nextLine());
            Long tripId = tripController.listTrips();
            flightConnection.setTrip_id(tripId);
            String planePlates = planeController.listPlanes();
            Plane selectedPlane = planeController.getPlane(planePlates);
            flightConnection.setPlane_id(selectedPlane.getId());
            System.out.println("Ingrese el id del aeropueto.");
            airportController.listAirports();
            flightConnection.setAirport_id(input.nextLine().toUpperCase());
            System.out.println(flightConnection);
            if (flightConnectionService.createFlightConnection(flightConnection) != null) {
                System.out.println("La conexión de vuelo fue guardada exitosamente");
            }
            return flightConnection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long listFlightConnections() {
        try {
            List<FlightConnection> flightConnections = flightConnectionService.listFlightConnections();
            System.out.println("Conexiones de vuelo disponibles:");
            for (FlightConnection flightConnection : flightConnections) {
                System.out.println(String.format("ID: %d, Número de conexión: %s, ID del viaje: %d, ID del avión: %d, ID del aeropuerto: %s",
                        flightConnection.getId(), flightConnection.getConnection_number(), flightConnection.getTrip_id(),
                        flightConnection.getPlane_id(), flightConnection.getAirport_id()));
            }
            System.out.println("Ingresa el ID de la conexión de vuelo:");
            Long id = input.nextLong();
            input.nextLine();  // limpiar buffer
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void informacionFlightConnection() {
        try {
            Long id = listFlightConnections();
            FlightConnection flightConnection = flightConnectionService.findFlightConnectionById(id);
            if (flightConnection == null) {
                System.out.println("Esta conexión de vuelo no existe.");
                return;
            }
            System.out.println("La información de la conexión de vuelo con ID: " + flightConnection.getId());
            System.out.println("Número de conexión: " + flightConnection.getConnection_number());
            System.out.println("ID del viaje: " + flightConnection.getTrip_id());
            System.out.println("ID del avión: " + flightConnection.getPlane_id());
            System.out.println("ID del aeropuerto: " + flightConnection.getAirport_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarFlightConnection() {
        try {
            Long id = this.listFlightConnections();
            flightConnectionService.deleteFlightConnection(id);
            System.out.println(String.format("La conexión de vuelo con ID %d fue eliminada exitosamente", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarFlightConnection() {
        try {
            Long id = listFlightConnections();
            FlightConnection flightConnection = new FlightConnection();
            System.out.println("Ingresa el nuevo número de conexión: ");
            flightConnection.setConnection_number(input.nextLine());
            Long tripId = tripController.listTrips();
            flightConnection.setTrip_id(tripId);
            String planePlates = planeController.listPlanes();
            Plane selectedPlane = planeController.getPlane(planePlates);
            flightConnection.setPlane_id(selectedPlane.getId());
            System.out.println("Ingrese el id del nuevo aeropueto.");
            airportController.listAirports();
            flightConnection.setAirport_id(input.nextLine().toUpperCase());
            flightConnectionService.updateFlightConnection(id, flightConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarMenuFlightConnection() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMenú de Gestión de Conexiones de Vuelo");
            System.out.println("1. Registrar conexión de vuelo");
            System.out.println("2. Consultar información de conexión de vuelo");
            System.out.println("3. Eliminar conexión de vuelo");
            System.out.println("4. Actualizar datos de conexión de vuelo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();  // limpiar el buffer

            switch (opcion) {
                case 1:
                    save();
                    break;
                case 2:
                    informacionFlightConnection();
                    break;
                case 3:
                    eliminarFlightConnection();
                    break;
                case 4:
                    actualizarFlightConnection();
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