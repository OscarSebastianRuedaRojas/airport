package com.airport.City.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.City.application.service.CityService;
import com.airport.City.domain.City;
import com.airport.Country.infrastructure.adapter.in.CountryController;

/**
 * CityController
 */
public class CityController {
    private CityService cityService;
    private CountryController countryController;
    private Scanner input;

    public CityController() {
        this.cityService = new CityService();
        this.input = new Scanner(System.in);
        this.countryController = new CountryController();
    }
    
    public void registerCity() {
        try {
            System.out.println("Ingrese el nombre de la ciudad");
            String name = input.nextLine();
            System.out.println("Ingres el id de la ciudad.");
            String airportId = input.nextLine();
            String countryId = countryController.CountryList();
            City neeCity = new City(airportId, name, countryId);
            City createdCity = cityService.createCity(neeCity);
            if (createdCity != null) {
                System.out.println("Se registro correctamente la ciuedad: "+ createdCity.getName());
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la ciudad.");
            e.printStackTrace();
        }
    }
    public City getCity(String id) {
        try {
            City city = cityService.getCity(id);
            return city;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String cityList() {
        try {
            System.out.println("Ciudades registradas");
            List<City> cityList = cityService.listCity();
            cityList.forEach(System.out::println);
            System.out.println("Seleccione la ciudad.");
            String cityId = cityService.listCity().get(input.nextInt()-1).getId();
            return cityId;
        } catch (Exception e) {
            System.out.println("Error al seleccionar la ciudad");
            e.printStackTrace();
        }
        return null;
    }
    public boolean confirmation(){
        System.out.println("¿Esta seguro de su eleccion?\n\t1. Sí\n\t2. No.");
        int option = input.nextInt();
        if (option == 1) {
            return true;
        }
        return false;
    }
    public void listCities() {
        List<City> cities = cityService.listCity();
        cities.forEach(city -> {
            System.out.println("id:"+city.getId()+ "Nombre: "+ city.getName()+ "Pais:"+ countryController.get(city.getCountryId()).getCountryName());
        });
    }
}