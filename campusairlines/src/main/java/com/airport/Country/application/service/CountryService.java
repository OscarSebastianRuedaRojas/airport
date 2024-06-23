package com.airport.Country.application.service;

import java.util.List;

import com.airport.Country.domain.Country;
import com.airport.Country.application.port.in.ICountryService;
import com.airport.Country.infrastructure.adapter.out.CountryRepository;

/**
 * CountryService
 */
public class CountryService implements ICountryService{

    private CountryRepository countryRepository;

    public CountryService() {
        this.countryRepository = new CountryRepository();
    }

    @Override
    public Country createCountry(Country country) {
        try {
            Country createdCountry = countryRepository.save(country);
            return createdCountry;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCountry(String id) {
        try {
            countryRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        
    }

    @Override
    public Country findCountryById(String id) {
        try {
            Country country = countryRepository.findById(id);
            return country;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Country findCountryByName(String countryName) {
        try {
            Country country = countryRepository.findByName(countryName);
            return country;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Country> listCountry() {
        try {
            List<Country> CountryList = countryRepository.findAll();
            return CountryList;
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCountry(String id, String newCountryName) {
        try {
            countryRepository.update(id, newCountryName);
        } catch (Exception e) {
            System.out.println("Ocurrio una interrupcion del sistema. Reintente.");
            e.printStackTrace();
        }
        
    }
    
}