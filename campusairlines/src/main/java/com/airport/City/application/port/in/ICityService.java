package com.airport.City.application.port.in;

import java.util.List;

import com.airport.City.domain.City;

/**
 * CityService
 */
public interface ICityService {
    City createCity(City city);
    List<City> listCity();
}