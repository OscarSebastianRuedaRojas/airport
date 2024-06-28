package com.airport.Admin.infrastructure.adapter.in;

import java.util.Scanner;

import com.airport.Admin.domain.Admin;

/**
 * AdminController
 */
public class AdminController {

    Admin admin;

    public AdminController() {
        this.admin = new Admin();
    }

    public void mostrarMenuAdmin(Scanner input) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nModo Administrador");
            System.out.println("1. Administrar avión");
            System.out.println("2. Administrar aeropuerto");
            System.out.println("3. Administrar trayecto");
            System.out.println("4. Administrar tripulación");
            System.out.println("5. Administrar escalas");
            System.out.println("6. Administrar tarifa");
            System.out.println("7. Administrar tipo de documento");
            System.out.println("8. Consultar información de vuelo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();  // limpiar el buffer

            switch (opcion) {
                case 1:
                    admin.getPlaneController().mostrarMenuAvion();
                    break;
                case 2:
                    admin.getAirportController().mostrarMenuAeropuerto();
                    break;
                case 3:
                    admin.getTripController().mostrarMenuTrip();
                    break;
                case 4:
                    admin.getTripCrewController().mostrarMenuTripCrew();
                    break;
                case 5:
                    admin.getFlightConnectionController().mostrarMenuFlightConnection();
                    break;
                case 6:
                    admin.getFlightFareController().mostrarMenuTarifa();
                    break;
                case 7:
                    admin.getDocumentTypeController().mostrarMenuTipoDocumento();
                    break;
                case 8:
                    admin.getTripController().informacionTrip();
                    break;
                case 0:
                    System.out.println("Saliendo del modo administrador...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

    }

    
}