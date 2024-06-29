package com.airport.TripBookingDetail.infrastructure.adapter.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airport.Customer.infrastructure.adapter.in.CustomerController;
import com.airport.CustomerPayment.infrastructure.adapter.in.CustomerPaymentController;
import com.airport.FlightFare.infrastructure.adapter.in.FlightFareController;
import com.airport.Trip.infrastructure.adapter.in.TripController;
import com.airport.TripBooking.application.service.TripBookingService;
import com.airport.TripBooking.domain.TripBooking;
import com.airport.TripBookingDetail.application.service.TripBookingDetailService;
import com.airport.TripBookingDetail.domain.TripBookingDetail;

/**
 * TripBookingDetailController
 */
public class TripBookingDetailController {

    private final TripBookingDetailService tripBookingDetailService;
    private final TripBookingService tripBookingService;
    private final Scanner input;
    private final CustomerController customerController;
    private final FlightFareController flightFareController;
    private final CustomerPaymentController customerPaymentController;

    public TripBookingDetailController() {
        this.tripBookingDetailService = new TripBookingDetailService();
        this.tripBookingService = new TripBookingService();
        this.input = new Scanner(System.in);
        this.customerController = new CustomerController();
        this.flightFareController = new FlightFareController();
        this.customerPaymentController = new CustomerPaymentController(); 
    }

    public TripBookingDetail registerTripBookingDetail() {
        try {
            TripBookingDetail tripBookingDetail = new TripBookingDetail();
    
            TripBooking tripBooking = new TripBooking();
            TripController tripController = new TripController();
            System.out.println("Ingrese la fecha para la reserva (yyyy-MM-dd): ");
            String dateStr = input.nextLine();
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateStr);
            tripBooking.setDate(sqlDate);
            System.out.println("Seleccione el trayecto:");
            tripBooking.setTrip_id(tripController.listTrips());
            tripBooking = tripBookingService.save(tripBooking); 
            tripBookingDetail.setTripBookingId(tripBooking.getId());
            System.out.println("Ingrese el ID del cliente:");
            customerController.listCustomers();
            tripBookingDetail.setCustomerId(input.nextLine());
            System.out.println("Ingrese el ID de la tarifa:");
            flightFareController.listFlightFare();
            tripBookingDetail.setFaresId(input.nextInt());
            input.nextLine();  
            System.out.println("Seleccione metodo de pago registrado para:" + customerController.getCustomer(tripBookingDetail.getCustomerId()).getCustomer_name());
            customerPaymentController.listCustomerPayments();
            int customerPaymentId = input.nextInt();
            tripBookingDetail.setCustomerPaymentId(customerPaymentId);
            TripBookingDetail newTripBooking = tripBookingDetailService.save(tripBookingDetail);
            System.out.println("Detalle de reserva registrado exitosamente.");
            return newTripBooking;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TripBookingDetail registerTripBookingDetailSinTripBooking(TripBooking tripBooking) {
        input.nextLine();
        try {
            TripBookingDetail tripBookingDetail = new TripBookingDetail();
            tripBookingDetail.setTripBookingId(tripBooking.getId());
            System.out.println("Ingrese el ID del cliente:");
            customerController.listCustomers();
            tripBookingDetail.setCustomerId(input.nextLine());
            System.out.println("Ingrese el ID de la tarifa:");
            flightFareController.listFlightFare();
            tripBookingDetail.setFaresId(input.nextInt());
            input.nextLine();
            List<TripBookingDetail> reservasDeVuelo = tripBookingDetailService.findAll();
            List <String> usedSeat = new ArrayList<>();
            reservasDeVuelo.forEach(reserva -> {
                usedSeat.add(reserva.getSeat());
            });
            while (true) {
                System.out.println("Digite el asiento que desea.");
                printDiagram();
                String seat = input.nextLine().toUpperCase();
                if (usedSeat.contains(seat)) {
                    System.out.println("El asiento: " + seat + " esta ocupado, seleccione otro.");
                } else {
                    usedSeat.add(seat);
                    tripBookingDetail.setSeat(seat);
                    break;
                }
            }  
            System.out.println("Seleccione metodo de pago registrado para:" + customerController.getCustomer(tripBookingDetail.getCustomerId()).getCustomer_name());
            customerPaymentController.listCustomerPayments();
            int customerPaymentId = input.nextInt();
            tripBookingDetail.setCustomerPaymentId(customerPaymentId);
            TripBookingDetail newTripBooking = tripBookingDetailService.save(tripBookingDetail);
            System.out.println("Detalle de reserva registrado exitosamente.");
            return newTripBooking;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listTripBookingDetails() {
        try {
            List<TripBookingDetail> tripBookingDetails = tripBookingDetailService.findAll();
            tripBookingDetails.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTripBookingDetail() {
        try {
            System.out.println("Ingrese el ID del detalle de reserva a actualizar:");
            Long id = input.nextLong();
            input.nextLine();  // Limpiar buffer
            TripBookingDetail existingDetail = tripBookingDetailService.findById(id);
            if (existingDetail == null) {
                System.out.println("Detalle de reserva no encontrado.");
                return;
            }
            System.out.println("Ingrese el nuevo ID del cliente:");
            customerController.listCustomers();
            existingDetail.setCustomerId(input.nextLine());
            System.out.println("Ingrese el nuevo ID de la tarifa:");
            flightFareController.listFlightFare();
            existingDetail.setFaresId(input.nextInt());
            input.nextLine();  // Limpiar buffer
            System.out.println("Ingrese id de la nueva opcion de pago");
            customerPaymentController.listCustomerPayments();
            existingDetail.setCustomerPaymentId(input.nextInt());
            tripBookingDetailService.update(id, existingDetail);
            System.out.println("Detalle de reserva actualizado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTripBookingDetail() {
        try {
            System.out.println("Ingrese el ID del detalle de reserva a eliminar:");
            Long id = input.nextLong();
            input.nextLine();  // Limpiar buffer
            tripBookingDetailService.deleteById(id);
            System.out.println("Detalle de reserva eliminado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findTripBookingDetailById() {
        try {
            System.out.println("Ingrese el ID del detalle de reserva:");
            Long id = input.nextLong();
            input.nextLine();  // Limpiar buffer
            TripBookingDetail tripBookingDetail = tripBookingDetailService.findById(id);
            if (tripBookingDetail != null) {
                System.out.println("Detalle de Reserva ID: " + tripBookingDetail.getId());
                System.out.println("TripBooking ID: " + tripBookingDetail.getTripBookingId());
                System.out.println("Customer ID: " + tripBookingDetail.getCustomerId());
                System.out.println("Fares ID: " + tripBookingDetail.getFaresId());
                TripBooking tripBooking = tripBookingService.findById(tripBookingDetail.getTripBookingId());
                if (tripBooking != null) {
                    System.out.println("Fecha de Reserva: " + tripBooking.getDate());
                    System.out.println("Trip ID: " + tripBooking.getTrip_id());
                }
            } else {
                System.out.println("Detalle de reserva no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Menú Agente ventas: Crear, Consultar, Eliminar reserva
    public void agenteMenu(){
        int option;
        do {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Crear detalle de reserva");
            System.out.println("2. Consultar detalle de reserva");
            System.out.println("3. Eliminar detalle de reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    registerTripBookingDetail();
                    break;
                case 2:
                    findTripBookingDetailById();
                    break;
                case 3:
                    deleteTripBookingDetail();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (option != 0);
    }

    // Menú de Cliente
    public void clienteMenu() {
        int option;
        do {
            System.out.println("----- Menú Modificar/Consultar -----");
            System.out.println("1. Modificar detalle de reserva");
            System.out.println("2. Consultar detalle de reserva");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    updateTripBookingDetail();
                    break;
                case 2:
                    findTripBookingDetailById();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (option != 0);
    }
    public static void printDiagram() {
        System.out.println("                 _________");
        System.out.println("                /         \\");
        System.out.println("               /           \\");
        System.out.println("              /             \\");
        System.out.println("             /               \\");
        System.out.println("            /_________________\\");
        int row = 1;
        while (row <= 35) {
            System.out.printf("            | %2d  A B C   D E F |\n", row);
            row++;
        }
        System.out.println("            \\                 /");
        System.out.println("             \\               /");
        System.out.println("              \\             /");
        System.out.println("               \\           /");
        System.out.println("                \\_________/");
    }

}