package com.airport.Country.infrastructure.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.airport.Country.domain.Country;
import com.airport.Country.application.service.CountryService;

/**
 * CountryController
 */
public class CountryController {
    private CountryService countryService;
    private Scanner input;
    public CountryController() {
        this.countryService = new CountryService();
        this.input = new Scanner(System.in);
    }
    public void registerCountry() {
        try {
            System.out.println("Ingrese nombre del pais");
            String CountryName = input.nextLine();
            System.out.println("Ingrese id del pais");
            String countryId = input.nextLine();
            Country newCountry = new Country(countryId, CountryName);
            Country createdCountry = countryService.createCountry(newCountry);
            if (createdCountry == null) {
                System.out.println("No se pudo registrar el pais.");
            } else {
                System.out.println("Pais registrado correctamente.\n\tNombre: " + createdCountry.getCountryName() + ".");
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar. Reintente.");
            e.printStackTrace();
        }
    }
    public String CountryList() {
        try {
            System.out.println("Paises registrados");
            List <Country> countryList = countryService.listCountry();
            countryList.forEach(System.out::println);
            System.out.println("Seleccione pais.");
            String countryId = countryService.listCountry().get(input.nextInt()).getId();
            return countryId;
        } catch (Exception e) {
            System.out.println("Error al seleccionar el pais");
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
    
}