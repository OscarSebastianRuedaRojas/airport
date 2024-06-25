package com.airport.FlighConnection.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.FlighConnection.application.service.FlightConnectionService;
import com.airport.FlighConnection.domain.FlightConnection;

/**
 * FlightConnectionController
 */
public class FlightConnectionController {

    private FlightConnectionService flightConnectionService;
    private Scanner input;

    public FlightConnectionController() {
        this.flightConnectionService = new FlightConnectionService();
        this.input = new Scanner(System.in);
    }

    public FlightConnection save() {
        try {
            FlightConnection flightConnection = new FlightConnection();
            System.out.println("Ingresa el número de conexión: ");
            flightConnection.setConnection_number(input.nextLine());
            System.out.println("Selecciona el ID del viaje: ");
            flightConnection.setTrip_id(input.nextLong());
            System.out.println("Selecciona el ID del avión: ");
            flightConnection.setPlane_id(input.nextLong());
            System.out.println("Selecciona el ID del aeropuerto: ");
            flightConnection.setAirport_id(input.nextLong());
            input.nextLine();  // limpiar buffer
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
                System.out.println(String.format("ID: %d, Número de conexión: %s, ID del viaje: %d, ID del avión: %d, ID del aeropuerto: %d",
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
            Long id = this.listFlightConnections();
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
            Long id = this.listFlightConnections();
            FlightConnection flightConnection = new FlightConnection();
            System.out.println("Ingresa el nuevo número de conexión: ");
            flightConnection.setConnection_number(input.nextLine());
            System.out.println("Selecciona el nuevo ID del viaje: ");
            flightConnection.setTrip_id(input.nextLong());
            System.out.println("Selecciona el nuevo ID del avión: ");
            flightConnection.setPlane_id(input.nextLong());
            System.out.println("Selecciona el nuevo ID del aeropuerto: ");
            flightConnection.setAirport_id(input.nextLong());
            input.nextLine();  // limpiar buffer
            flightConnectionService.updateFlightConnection(id, flightConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}