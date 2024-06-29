package com.airport.TripBooking.infrastructure.adapter.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.airport.Trip.infrastructure.adapter.in.TripController;
import com.airport.TripBooking.application.service.TripBookingService;
import com.airport.TripBooking.domain.TripBooking;

/**
 * TripBookingController
 */
public class TripBookingController {

    private TripBookingService tripBookingService;
    private Scanner input;

    public TripBookingController() {
        this.tripBookingService = new TripBookingService();
        this.input = new Scanner(System.in);
    }

    public TripBooking registerTripBooking() throws ParseException{
        System.out.println("entramos aqui");
        try {
            TripBooking tripBooking = new TripBooking();
            TripController tripController = new TripController();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Ingresa la fecha para la reserva: ");
            String dateStr = input.nextLine();
            java.util.Date utilDate = dateFormat.parse(dateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            tripBooking.setDate(sqlDate);
            System.out.println("Selecciona el trayecto:");
            tripBooking.setTrip_id(tripController.listTrips());
            TripBooking savedTrip = tripBookingService.save(tripBooking);
            if (savedTrip != null) {
                System.out.println("Reserva creada exitosamente.");
            }
            return savedTrip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TripBooking findById(Long id){
        try {
            return tripBookingService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
