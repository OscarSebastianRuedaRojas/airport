package com.airport.Customer.infrastructure.adapter.in;

import java.util.Scanner;

import com.airport.Trip.infrastructure.adapter.in.TripController;
import com.airport.TripBooking.domain.TripBooking;
import com.airport.TripBooking.infrastructure.adapter.in.TripBookingController;
import com.airport.TripBookingDetail.infrastructure.adapter.in.TripBookingDetailController;

public class CustomerBookingController {
    private TripController tripController;
    private TripBookingDetailController tripBookingDetailController;
    private Scanner input;

    public CustomerBookingController() {
        this.tripController = new TripController();
        this.tripBookingDetailController = new TripBookingDetailController();
        this.input = new Scanner(System.in);
    }

    public void CreateFlightBooking() {
        while (true) {
            System.out.println("Bienvenido al portal de reservas de vuelo GLOBAL VUELING S.A.S");
            System.out.println("1. Buscar vuelos.");
            System.out.println("0. Regresar.");
            int opc = input.nextInt();
            switch (opc) {
                case 1:
                    tripController.buscarTripPorFechaSalidaLLegada();
                    System.out.println("Desea continuar?\n\t1. Si\n\t2. No");
                    if (input.nextInt() != 2) {
                        try {
                            System.out.println("Aqui se hace el de la reserva principa");
                            TripBookingController tripBookingController = new TripBookingController();
                            TripBooking tripBooking = tripBookingController.registerTripBooking();
                            while (true) {
                                tripBookingDetailController.registerTripBookingDetailSinTripBooking(tripBooking);
                                System.out.println("Desea agregar mas pasajeros a la reserva?");
                                System.out.println("1. Si.");
                                System.out.println("2. No.");
                                if (input.nextInt() == 2) {
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ocurrio un error al crear la reserva de vuelo.");
                            e.printStackTrace();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Ocurrio un error.");
                    break;
            }
        }

    }
}
