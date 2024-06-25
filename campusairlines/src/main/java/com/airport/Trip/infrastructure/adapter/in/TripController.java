package com.airport.Trip.infrastructure.adapter.in;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.airport.City.infrastructure.adapter.in.CityController;
import com.airport.Trip.application.service.TripService;
import com.airport.Trip.domain.Trip;
import com.airport.Trip.infrastructure.adapter.out.TripRepository;

/**
 * TripController
 */
public class TripController {

    private TripService tripService;
    private Scanner input;

    public TripController() {
        this.tripService = new TripService();
        this.input = new Scanner(System.in);
    }

    public Trip save() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CityController departureCityController = new CityController();
        CityController destinationCityController = new CityController();
        try {
            Trip trip = new Trip();
            System.out.println("Ingresa la fecha del viaje (yyyy-MM-dd): ");
            trip.setTrip_date(Date.valueOf(input.nextLine()));
            System.out.println("Ingresa el precio del viaje: ");
            trip.setPrice_trip(input.nextFloat());
            input.nextLine();  // limpiar buffer
            System.out.println("Selecciona la ciudad de salida: ");
            trip.setDeparture_city_id(departureCityController.listCities());
            System.out.println("Selecciona la ciudad de destino: ");
            trip.setDestination_city_id(destinationCityController.listCities());
            if (tripService.createTrip(trip) != null) {
                System.out.println("El viaje fue guardado exitosamente");
            }
            return trip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long listTrips() {
        try {
            List<Trip> trips = tripService.listTrips();
            System.out.println("Viajes disponibles:");
            for (Trip trip : trips) {
                System.out.println(String.format("ID: %d, Fecha: %s, Precio: %.2f", trip.getId(), trip.getTrip_date(), trip.getPrice_trip()));
            }
            System.out.println("Ingresa el ID del viaje:");
            Long id = input.nextLong();
            input.nextLine();  // limpiar buffer
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void informacionTrip() {
        try {
            Long id = this.listTrips();
            Trip trip = tripService.findTripById(id);
            if (trip == null) {
                System.out.println("Este viaje no existe.");
                return;
            }
            System.out.println("La información del viaje con ID: " + trip.getId());
            System.out.println("Fecha: " + trip.getTrip_date());
            System.out.println("Precio: " + trip.getPrice_trip());
            System.out.println("Ciudad de salida: " + trip.getDeparture_city_id());
            System.out.println("Ciudad de destino: " + trip.getDestination_city_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarTrip() {
        try {
            Long id = this.listTrips();
            tripService.deleteTrip(id);
            System.out.println(String.format("El viaje con ID %d fue eliminado exitosamente", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarTrip() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CityController departureCityController = new CityController();
        CityController destinationCityController = new CityController();
        try {
            Long id = this.listTrips();
            Trip trip = new Trip();
            System.out.println("Ingresa la nueva fecha del viaje (yyyy-MM-dd): ");
            trip.setTrip_date(Date.valueOf(input.nextLine()));
            System.out.println("Ingresa el nuevo precio del viaje: ");
            trip.setPrice_trip(input.nextFloat());
            input.nextLine();  // limpiar buffer
            System.out.println("Selecciona la nueva ciudad de salida: ");
            trip.setDeparture_city_id(departureCityController.listCities());
            System.out.println("Selecciona la nueva ciudad de destino: ");
            trip.setDestination_city_id(destinationCityController.listCities());
            tripService.updateTrip(id, trip);;
            System.out.println("El viaje fue actualizado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}