package com.airport.SellAgent.infraestructure.adapter;

import java.util.Scanner;

import com.airport.SellAgent.domain.SellAgent;

public class SellAgentController {
    private SellAgent sellAgent;

    public SellAgentController() {
        this.sellAgent = new SellAgent();
    }

    public void menuSaleAgent(){
        Scanner input = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nModo Agente de ventas");
            System.out.println("1. Administrar cliente");
            System.out.println("2. Administrar reserva de vuelo");
            System.out.println("3. Consultar informacion de vuelo");
            System.out.println("4. Consultar informacion de asignacion de tripulacion");
            System.out.println("5. Consultar escalas de trayecto");
            System.out.println("6. Consultar tarifas de vuelo");
            System.out.println("7. Consultar tipos de documento");
            System.out.println("8. Consultar información de vuelo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();  // limpiar el buffer

            switch (opcion) {
                case 1:
                    sellAgent.getCustomerController().showMenu();
                    break;
                case 2:
                    sellAgent.getTripBookingDetailController().agenteMenu();
                    break;
                case 3:
                    sellAgent.getTripController().informacionTrip();
                    break;
                case 4:
                    sellAgent.getTripCrewController().informacionTripCrew();
                    break;
                case 5:
                    sellAgent.getFlightConnectionController().informacionFlightConnection();
                    break;
                case 6:
                    sellAgent.getFlightFareController().flightFaresList();
                    break;
                case 7:
                    sellAgent.getDocumentTypeController().selectDocumentTypeList();
                    break;
                case 8:
                    sellAgent.getTripController().informacionTrip();
                    break;
                case 0:
                    System.out.println("Saliendo del modo Agente de Ventas...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        input.close();
    }
}
