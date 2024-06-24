package com.airport.City.application.service;

import java.util.List;

import com.airport.City.application.port.in.ICityService;
import com.airport.City.domain.City;
import com.airport.City.infrastructure.adapter.out.CityRepository;

/**
 * CityService
 */
public class CityService implements ICityService {
    private CityRepository cityRepository;
    

    public CityService() {
        this.cityRepository = new CityRepository();
    }

    @Override
    public City createCity(City city) {
        try {
            City newCity = cityRepository.save(city);
            return newCity;
        } catch (Exception e) {
            System.out.println("Error al guardad ciudad en base de datos.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> listCity() {
        try {
            List<City> cityList = cityRepository.findAll();
            return cityList;
        } catch (Exception e) {
            System.out.println("Erro al recuperar el listado de ciudad.");
            e.printStackTrace();
        }
        return null;
    }

    
}