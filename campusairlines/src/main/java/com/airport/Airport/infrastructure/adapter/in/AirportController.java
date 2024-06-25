package com.airport.Airport.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Airport.application.service.AirportService;
import com.airport.Airport.domain.Airport;
import com.airport.City.domain.City;
import com.airport.City.infrastructure.adapter.in.CityController;

/**
 * AirportController
 */
public class AirportController {
    private AirportService airportService;
    private CityController cityController;
    private Scanner input;

    public AirportController() {
        this.airportService = new AirportService();
        this.cityController = new CityController();
        this.input = new Scanner(System.in);
    }

    public void registerAirport() {
        System.out.println("Ingrese nombre del aeropuerto");
        String name = input.nextLine();
        System.out.println("Ingrese codigo del aeropuerto");
        String id = input.nextLine();
        String cityId = cityController.cityList();
        Airport newAirport = new Airport(id, name, cityId);
        Airport createdAirport = airportService.createAirport(newAirport);
        if (createdAirport != null) {
            City airportCity = cityController.getCity(cityId);
            System.out.println("Aeropuerto registrado correctamente.");
            System.out.println("1.Nombre " + createdAirport.getName() + " 2. Ciudad:" + airportCity.getName());
        }
    }

    public void getAirportInfo() {
        try {
            System.out.println("Ingrese el id de el aeropuerto");
            String airportId = input.nextLine();
            Airport getAirport = airportService.getAirportInformation(airportId);
            System.out.println(String.format("1. id: %s.\n2.Nombre: %s.\n3. Ciudad: %s.", getAirport.getId(),
                    getAirport.getName(), cityController.getCity(getAirport.getCityId())));
        } catch (Exception e) {
            System.out.println("No hay aeropuerto con el id introducido.");
            e.printStackTrace();
        }
    }

    public void updateAirport() {
        System.out.println("Seleccione aeropuerto a modificar:");
        listAirports();
        String id = input.nextLine();
        Airport selectedAirport = airportService.getAirportInformation(id);
        if (selectedAirport == null) {
            System.out.println("Aeropuerto no encontrado, intente nuevamente.");
        }
        System.out.println("Aeropuerto seleccionado: " + selectedAirport.getName());
        while (true) {

            try {

                System.out.println("1. Modificar nombre\n2. Modificar ciudad\n3. Guardar\n4. Regresar");
                int opc = input.nextInt();
                input.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("Introduzca nuevo nombre:");
                        String newName = input.nextLine();
                        selectedAirport.setName(newName);
                        System.out.println("Se configuró el nombre: " + newName);
                        break;
                    case 2:
                        System.out.println("Modificar ciudad:");
                        String cityIndex = cityController.cityList();
                        selectedAirport.setCityId(cityIndex);
                        System.out.println("Se configuró la ciudad: " + cityController.getCity(cityIndex));
                        break;
                    case 3:
                        try {
                            airportService.updateAirportInformation(selectedAirport);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Información del aeropuerto actualizada correctamente.");
                        return;
                    case 4:
                        return;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                e.printStackTrace();
                input.nextLine();
            }
        }
    }

    public void deleteAirpot() {
        try {
            System.out.println("Seleccione aeropuerto por el id: ");
            airportService.listAirports();
            String id = input.nextLine().toUpperCase();
            Airport toDeleteAirport = airportService.getAirportInformation(id);
            System.out.println("Se eliminara el aeropuerto" + toDeleteAirport.getName());
            if (confirmation()) {
                airportService.deleteAirport(toDeleteAirport);
            }
        } catch (Exception e) {
            System.out.println("Error al introduci el id.");
            e.printStackTrace();
        }
    }

    public void listAirports() {
        List<Airport> airportList = airportService.listAirports();
        airportList.forEach(System.out::println);
    }

    public boolean confirmation() {
        System.out.println("¿Esta seguro de su eleccion?\n\t1. Sí\n\t2. No.");
        int option = input.nextInt();
        if (option == 1) {
            return true;
        }
        return false;
    }
}