package com.airport.TripBookingDetail.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

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

    public TripBookingDetailController() {
        this.tripBookingDetailService = new TripBookingDetailService();
        this.tripBookingService = new TripBookingService();
        this.input = new Scanner(System.in);
    }

    public void registerTripBookingDetail() {
        try {
            TripBookingDetail tripBookingDetail = new TripBookingDetail();
    
            // Solicitar y guardar el TripBooking
            TripBooking tripBooking = new TripBooking();
            TripController tripController = new TripController();
            System.out.println("Ingrese la fecha para la reserva (yyyy-MM-dd): ");
            String dateStr = input.nextLine();
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateStr);
            tripBooking.setDate(sqlDate);
            System.out.println("Seleccione el trayecto:");
            tripBooking.setTrip_id(tripController.listTrips());
            tripBooking = tripBookingService.save(tripBooking);  // Guardar y obtener el tripBooking con ID
            tripBookingDetail.setTripBookingId(tripBooking.getId());
    
            // Solicitar y guardar detalles de TripBookingDetail
            System.out.println("Ingrese el ID del cliente:");
            tripBookingDetail.setCustomerId(input.nextLine());
            System.out.println("Ingrese el ID de la tarifa:");
            tripBookingDetail.setFaresId(input.nextInt());
            input.nextLine();  // Limpiar buffer
            tripBookingDetailService.save(tripBookingDetail);
            System.out.println("Detalle de reserva registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            existingDetail.setCustomerId(input.nextLine());
            System.out.println("Ingrese el nuevo ID de la tarifa:");
            existingDetail.setFaresId(input.nextInt());
            input.nextLine();  // Limpiar buffer
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
}